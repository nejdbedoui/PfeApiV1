package com.bprice.bpapipos.dto;

import com.bprice.persistance.model.PointVente;

import java.util.List;

public class PointeVentePartenaireDTO {

    private List<PointVente> listePointVente;
    private String idPartenaire;
    private String abbreviation;
    private String adresse;
    private String idSecteur;
    private String nTel;
    private int statut;

    private int prix;

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public String getnTel() {
        return nTel;
    }

    public void setnTel(String nTel) {
        this.nTel = nTel;
    }

    public String getIdSecteur() {
        return idSecteur;
    }

    public void setIdSecteur(String idSecteur) {
        this.idSecteur = idSecteur;
    }

    public List<PointVente> getListePointVente() {
        return listePointVente;
    }

    public void setListePointVente(List<PointVente> listePointVente) {
        this.listePointVente = listePointVente;
    }

    public String getIdPartenaire() {
        return idPartenaire;
    }

    public void setIdPartenaire(String idPartenaire) {
        this.idPartenaire = idPartenaire;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
