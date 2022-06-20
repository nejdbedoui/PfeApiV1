package com.bprice.bpapipos.dto;

import java.util.List;

public class DetailsActionDTO {
    private String sector;
    private List<String> secteurCible;
    private int ageMin;//30-40
    private int ageMax;
    private int sexe;//h,f,h-f
    private List<String> ville;
    private String namefile;
    private int typefile;
    private String urlmedia;
    private String canaldifusion;
    private String formataffichage;
    private String idSector;

    public String getIdSector() {
        return idSector;
    }

    public void setIdSector(String idSector) {
        this.idSector = idSector;
    }

    public List<String> getSecteurCible() {
        return secteurCible;
    }

    public void setSecteurCible(List<String> secteurCible) {
        this.secteurCible = secteurCible;
    }

    public int getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(int ageMin) {
        this.ageMin = ageMin;
    }

    public int getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(int ageMax) {
        this.ageMax = ageMax;
    }



    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }


    public int getSexe() {
        return sexe;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    public List<String> getVille() {
        return ville;
    }

    public void setVille(List<String> ville) {
        this.ville = ville;
    }

    public String getNamefile() {
        return namefile;
    }

    public void setNamefile(String namefile) {
        this.namefile = namefile;
    }

    public int getTypefile() {
        return typefile;
    }

    public void setTypefile(int typefile) {
        this.typefile = typefile;
    }

    public String getUrlmedia() {
        return urlmedia;
    }

    public void setUrlmedia(String urlmedia) {
        this.urlmedia = urlmedia;
    }

    public String getCanaldifusion() {
        return canaldifusion;
    }

    public void setCanaldifusion(String canaldifusion) {
        this.canaldifusion = canaldifusion;
    }

    public String getFormataffichage() {
        return formataffichage;
    }

    public void setFormataffichage(String formataffichage) {
        this.formataffichage = formataffichage;
    }
}
