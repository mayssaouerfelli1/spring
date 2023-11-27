package com.mayssa.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mayssa.demo.entities.Artiste;
import com.mayssa.demo.entities.Chanson;
import com.mayssa.demo.repos.ArtisteRepository;
import com.mayssa.demo.repos.ChansonRepository;
import com.mayssa.demo.repos.ImageRepository;
@Service
public class ChansonServiceImpl implements chansonService{
	@Autowired
	ChansonRepository chansonRepository;
	
	
	@Autowired
	ArtisteRepository artisteRepository;
	
	@Autowired
	ImageRepository imageRepository;
	
	@Override
	public Chanson saveChanson(Chanson p) {
		
		return chansonRepository.save(p);
	}

	@Override
	public Chanson updateChanson(Chanson p) {
		//Long oldChanImageId = this.getChanson(p.getIdChanson()).getImage().getIdImage();
		//Long newChanImageId = p.getImage().getIdImage();
		Chanson ChanUpdated = chansonRepository.save(p);
		//if (oldChanImageId != newChanImageId) 
		//	imageRepository.deleteById(oldChanImageId);
		return ChanUpdated;
	}

	@Override
	public void deleteChanson(Chanson p) {
		chansonRepository.delete(p);
		
	}

	@Override
	public void deleteChansonById(Long id) {
		chansonRepository.deleteById(id);
		
	}

	@Override
	public Chanson getChanson(Long id) {
		
		return chansonRepository.findById(id).get();
	}

	@Override
	public List<Chanson> getAllChansons() {
		
		return chansonRepository.findAll();
	}

	@Override
	public Page<Chanson> getAllChansonsParPage(int page, int size) {
		
		return chansonRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Chanson> findByArtiste(Artiste artiste) {
		
		return chansonRepository.findByArtiste(artiste);
	}

	@Override
	public List<Chanson> findByArtisteIdArtiste(Long id) {
		
		return chansonRepository.findByArtisteIdArtiste(id);
	}

	@Override
	public List<Artiste> getAllArtistes() {
		
		return artisteRepository.findAll();
	}


}
