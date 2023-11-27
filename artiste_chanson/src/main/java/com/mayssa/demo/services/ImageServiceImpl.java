package com.mayssa.demo.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mayssa.demo.entities.Chanson;
import com.mayssa.demo.entities.Image;
import com.mayssa.demo.repos.ChansonRepository;
import com.mayssa.demo.repos.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ChansonRepository chansonRepository;

    @Override
    public Image uploadImage(MultipartFile file) throws IOException {
        return imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(file.getBytes())
                .build());
    }

    @Override
    public Image getImageDetails(Long id) throws IOException {
        final Optional<Image> dbImage = imageRepository.findById(id);
        return dbImage.orElse(null);
    }

    @Override
    public ResponseEntity<byte[]> getImage(Long id) throws IOException {
        Optional<Image> dbImage = imageRepository.findById(id);
        if (dbImage.isPresent()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(dbImage.get().getType()))
                    .body(dbImage.get().getImage());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

    @Override
    public Image uplaodImageChan(MultipartFile file, Long idChanson) throws IOException {
        Optional<Chanson> chansonOptional = chansonRepository.findById(idChanson);
        if (chansonOptional.isPresent()) {
            Chanson chanson = chansonOptional.get();
            return imageRepository.save(Image.builder()
                    .name(file.getOriginalFilename())
                    .type(file.getContentType())
                    .image(file.getBytes())
                    .chanson(chanson)
                    .build());
        } else {
            throw new IllegalArgumentException("Chanson not found with id: " + idChanson);
        }
    }

    @Override
    public List<Image> getImagesParChan(Long chanId) {
        Optional<Chanson> optionalChanson = chansonRepository.findById(chanId);
        if (optionalChanson.isPresent()) {
            Chanson chanson = optionalChanson.get();
            return chanson.getImages();
        } else {
            return null;
        }
    }
}
