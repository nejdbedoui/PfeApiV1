package com.bprice.bpapipos.dto;

public class DemandeDiffusionDTO {
    private String idParametreActionMarketing;
    private String idActionMarketing;
    private int prix;
    private String libelleCanal;

    private String url;
    private String type;
private String titre;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIdParametreActionMarketing() {
        return idParametreActionMarketing;
    }

    public void setIdParametreActionMarketing(String idParametreActionMarketing) {
        this.idParametreActionMarketing = idParametreActionMarketing;
    }

    public String getIdActionMarketing() {
        return idActionMarketing;
    }

    public void setIdActionMarketing(String idActionMarketing) {
        this.idActionMarketing = idActionMarketing;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getLibelleCanal() {
        return libelleCanal;
    }

    public void setLibelleCanal(String libelleCanal) {
        this.libelleCanal = libelleCanal;
    }
}
