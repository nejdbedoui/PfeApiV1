package com.bprice.bpapipos.service;

import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.persistance.model.ActionMarketing;

import java.util.Date;

public interface IActionMarketingService {
    public ResponseObject CreateActionMarketing(ActionMarketing actionMarketing);
    public ResponseObject DeleteActionMarketing(String Idaction);
    public ResponseObject UpdateActionMarketing(ActionMarketing actionMarketing);
    public ResponseObject findByIdActionMarketing(String IdAction);
    public ResponseObject findAllByIdPartenaireAndDateCreation(String IdPartenaire,Date DateDebut,Date DateFin);
    public ResponseObject findAllByDateCreation(Date DateDebut, Date DateFin);
    public ResponseObject findAllByIdPartenaire(String IdPartenaire);
    public ResponseObject findAll();
}
