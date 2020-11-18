package com.article.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idArticle;
	private String libelle;
	private String description;
	private String marque;
	private double prixUnitaire;
	private Date dateCreation;
	@ManyToOne
	private Client client;
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article(String libelle, String description, String marque, double prixUnitaire, Date dateCreation) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.marque = marque;
		this.prixUnitaire = prixUnitaire;
		this.dateCreation = dateCreation;
	}

	public Long getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public double getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", libelle=" + libelle + ", description=" + description + ", marque="
				+ marque + ", prixUnitaire=" + prixUnitaire + ", dateCreation=" + dateCreation + "]";
	}

	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
}
