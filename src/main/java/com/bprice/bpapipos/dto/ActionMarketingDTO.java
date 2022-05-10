package com.bprice.bpapipos.dto;




import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


public class ActionMarketingDTO {
    private String idActionMarketing;
    private String url;
    private String canal;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;

    private String smsBody;
    private String titre;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;


    public int getTypeitem() {
        return typeitem;
    }

    public void setTypeitem(int typeitem) {
        this.typeitem = typeitem;
    }

    public void setSmsBody(String smsBody){
        this.smsBody = smsBody;
    }
    public String getSmsBody(){
        return smsBody;
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    private int statut;
    private String type;
    private int typeitem;

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdActionMarketing() {
        return idActionMarketing;
    }

    public void setIdActionMarketing(String idActionMarketing) {
        this.idActionMarketing = idActionMarketing;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }


}
