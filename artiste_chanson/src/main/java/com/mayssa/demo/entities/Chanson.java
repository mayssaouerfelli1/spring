package com.mayssa.demo.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

@Entity
public class Chanson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idChanson;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;
	
	@NotNull
	private String nom;
	
	@ManyToOne
	public Artiste artiste;
	
	
	/*@OneToOne
	private Image image;*/
	
	@OneToMany (mappedBy = "chanson")
	 private List<Image> images;
	
	public Chanson() {
		super();
	}
	
	public Chanson(Date dateCreation, String nom, Artiste artiste) {
		super();
		this.dateCreation = dateCreation;
		this.nom = nom;
		this.artiste = artiste;
	}
	

	


	public Long getIdChanson() {
		return idChanson;
	}

	public void setIdChanson(Long idChanson) {
		this.idChanson = idChanson;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Artiste getArtiste() {
		return artiste;
	}

	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}

	

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Chanson [idChanson=" + idChanson + ", dateCreation=" + dateCreation + ", nom=" + nom + ", artiste="
				+ artiste +"]";
	}

	
	
}
