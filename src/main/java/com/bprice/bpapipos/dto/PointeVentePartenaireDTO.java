package com.bprice.bpapipos.dto;

import com.bprice.persistance.model.PointVente;

import java.util.List;

public class PointeVentePartenaireDTO {

    private List<PointVente> listePointVente;
    private String idPartenaire;
    private String abbreviation;
    private String adresse;


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
