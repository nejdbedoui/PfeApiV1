package com.bprice.bpapipos.dto;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class DemandeActionMarketingWithDetailActionDTO {
    private String idDemandeActionMarketing;
    private String idActionMarketing;
    private String canal;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    private int statut;
    private String idTypeAffichage;

    public String getIdDemandeActionMarketing() {
        return idDemandeActionMarketing;
    }

    public void setIdDemandeActionMarketing(String idDemandeActionMarketing) {
        this.idDemandeActionMarketing = idDemandeActionMarketing;
    }

    public String getIdActionMarketing() {
        return idActionMarketing;
    }

    public void setIdActionMarketing(String idActionMarketing) {
        this.idActionMarketing = idActionMarketing;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public String getIdTypeAffichage() {
        return idTypeAffichage;
    }

    public void setIdTypeAffichage(String idTypeAffichage) {
        this.idTypeAffichage = idTypeAffichage;
    }
}
