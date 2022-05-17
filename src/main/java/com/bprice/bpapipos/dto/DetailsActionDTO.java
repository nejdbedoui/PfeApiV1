package com.bprice.bpapipos.dto;

import java.util.List;

public class DetailsActionDTO {
    private String sector;
    private List<String> secteurCible;
    private List<Integer> age;//30-40
    private int sexe;//h,f,h-f

    public List<String> getSecteurCible() {
        return secteurCible;
    }

    public void setSecteurCible(List<String> secteurCible) {
        this.secteurCible = secteurCible;
    }

    public List<Integer> getAge() {
        return age;
    }

    public void setAge(List<Integer> age) {
        this.age = age;
    }

    private List<String> ville;
    private String namefile;
    private int typefile;
    private String urlmedia;
    private String canaldifusion;
    private String formataffichage;

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
