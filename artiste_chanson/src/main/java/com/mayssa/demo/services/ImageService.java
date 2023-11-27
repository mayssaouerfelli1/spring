package com.mayssa.demo.services;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.mayssa.demo.entities.Image;

public interface ImageService {
    Image uploadImage(MultipartFile file) throws IOException;
    Image getImageDetails(Long id) throws IOException;
    ResponseEntity<byte[]> getImage(Long id) throws IOException;
    void deleteImage(Long id);
    
    Image uplaodImageChan(MultipartFile file,Long idChanson) throws IOException;
    List<Image> getImagesParChan(Long chanId);
}
