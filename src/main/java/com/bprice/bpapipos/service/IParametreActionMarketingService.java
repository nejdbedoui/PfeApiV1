package com.bprice.bpapipos.service;

import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.persistance.model.ParametreActionMarketing;

import java.util.Date;

public interface IParametreActionMarketingService {
    public ResponseObject CreateParametreActionMarketing(ParametreActionMarketing parametreActionMarketing,String idAction);
    public ResponseObject DeleteParametreActionMarketing(String Idaction);
    public ResponseObject UpdateParametreActionMarketing(ParametreActionMarketing parametreActionMarketing);
    public ResponseObject findByIdParametreActionMarketing(String IdAction);
    public ResponseObject findAllByIdPartenaireAndDateCreation(String IdPartenaire, Date DateDebut, Date DateFin);
    public ResponseObject findAllByDateCreation(Date DateDebut, Date DateFin);
    public ResponseObject findAllByIdPartenaire(String IdPartenaire);
    public ResponseObject findAll();
}
