package com.bprice.bpapipos.dto;

import java.util.Date;

/**
 * Created by ahmed on 19/03/2020.
 */
public class TableReservationDto {
    private String idPointVente;
    private Date datereservation;

    public TableReservationDto() {
    }

    public String getIdPointVente() {
        return idPointVente;
    }

    public void setIdPointVente(String idPointVente) {
        this.idPointVente = idPointVente;
    }

    public Date getDatereservation() {
        return datereservation;
    }

    public void setDatereservation(Date datereservation) {
        this.datereservation = datereservation;
    }
}
