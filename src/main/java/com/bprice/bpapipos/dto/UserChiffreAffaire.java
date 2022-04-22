/*
 * creer par Oussama dridi 15 avr. 2020
 */
package com.bprice.bpapipos.dto;

public class UserChiffreAffaire {

	private String idUser;
	private String nomPrenomuser;
	private Float chiffreAffaire;

	public UserChiffreAffaire(String idUser, String nomPrenomuser, Float chiffreAffaire) {
		super();
		this.idUser = idUser;
		this.nomPrenomuser = nomPrenomuser;
		this.chiffreAffaire = chiffreAffaire;
	}

	public UserChiffreAffaire() {
		super();
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getNomPrenomuser() {
		return nomPrenomuser;
	}

	public void setNomPrenomuser(String nomPrenomuser) {
		this.nomPrenomuser = nomPrenomuser;
	}

	public Float getChiffreAffaire() {
		return chiffreAffaire;
	}

	public void setChiffreAffaire(Float chiffreAffaire) {
		this.chiffreAffaire = chiffreAffaire;
	}

}

