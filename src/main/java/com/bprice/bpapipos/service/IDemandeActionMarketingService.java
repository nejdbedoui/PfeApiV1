package com.bprice.bpapipos.service;

import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.persistance.model.ActionMarketing;
import com.bprice.persistance.model.DemandeActionMarketing;

import java.util.Date;
import java.util.List;

public interface IDemandeActionMarketingService {
    public ResponseObject CreateActionMarketing(DemandeActionMarketing demandeActionMarketing);
    public ResponseObject DeleteDemandeActionMarketing(String idDemande);
    public ResponseObject UpdateDemandeActionMarketing(DemandeActionMarketing demandeActionMarketing);
    public ResponseObject findByIdDemandeActionMarketing(String idDemande);
    public ResponseObject findAllByIdPartenaireAndDateCreation(String IdPartenaire, Date DateDebut, Date DateFin);
    public ResponseObject findAllByDateCreation(Date DateDebut, Date DateFin);
    public ResponseObject findAllByIdPartenaire(String IdPartenaire);
    public ResponseObject findAll();
    public ResponseObject findAllDemandeActionMarketingDTOWithStatutBiggerThan(Integer statut);
    public ResponseObject entityToDto(List<DemandeActionMarketing> demandeActionMarketings);
}
