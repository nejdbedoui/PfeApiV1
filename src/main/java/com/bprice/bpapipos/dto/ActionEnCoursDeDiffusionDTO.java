package com.bprice.bpapipos.dto;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class ActionEnCoursDeDiffusionDTO {
    private String idActionMarketing;
    private String idDemandeActionMarketing;
    private String titre;
    private String canal;
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedebut;
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefin;

    public String getIdActionMarketing() {
        return idActionMarketing;
    }

    public void setIdActionMarketing(String idActionMarketing) {
        this.idActionMarketing = idActionMarketing;
    }

    public String getIdDemandeActionMarketing() {
        return idDemandeActionMarketing;
    }

    public void setIdDemandeActionMarketing(String idDemandeActionMarketing) {
        this.idDemandeActionMarketing = idDemandeActionMarketing;
    }



    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }


}
