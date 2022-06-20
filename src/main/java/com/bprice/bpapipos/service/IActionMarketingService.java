package com.bprice.bpapipos.service;

import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.persistance.model.ActionMarketing;

import java.util.Date;
import java.util.List;

public interface IActionMarketingService {
    public ResponseObject CreateActionMarketing(ActionMarketing actionMarketing);
    public ResponseObject DeleteActionMarketing(String Idaction);
    public ResponseObject UpdateActionMarketing(ActionMarketing actionMarketing);
    public ResponseObject findByIdActionMarketing(String IdAction);
    public ResponseObject findAllByIdPartenaireAndDateCreation(String IdPartenaire,Date DateDebut,Date DateFin);
    public ResponseObject findAllByDateCreation(Date DateDebut, Date DateFin);
    public ResponseObject findAllByIdPartenaire(String IdPartenaire);
    public ResponseObject findAllByIdCanalDiffusion(String idCanal);
    public ResponseObject findAll();
    public ResponseObject findAllActionMarketingDTOWithStatutBiggerThan(Integer statut);
    public int countActionMarketingByNotificationEquals(int num);
    public int countActionMarketingByNotificationEqualsAndIdPartenaire(int num, String idpartenaire);

    public int countActionMarketingByNotificationEquals(int num);

    public int countActionMarketingByNotificationEqualsAndIdPartenaire(int num,String idpartenaire);

    public ResponseObject entityToDto(List<ActionMarketing> actionMarketings);
}
