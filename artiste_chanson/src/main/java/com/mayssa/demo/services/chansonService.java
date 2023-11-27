package com.mayssa.demo.services;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.mayssa.demo.entities.Artiste;
import com.mayssa.demo.entities.Chanson;
import com.mayssa.demo.entities.Image;


public interface chansonService {
	Chanson saveChanson(Chanson p);
	Chanson updateChanson(Chanson p);
	void deleteChanson(Chanson p);
	 void deleteChansonById(Long id);
	 Chanson getChanson(Long id);
	List<Chanson> getAllChansons();
	Page<Chanson> getAllChansonsParPage(int page, int size);
	List<Artiste> getAllArtistes();
	List<Chanson> findByArtiste (Artiste artiste);
	List<Chanson> findByArtisteIdArtiste(Long idChanson);

	
}
