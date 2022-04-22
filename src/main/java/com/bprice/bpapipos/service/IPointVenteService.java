package com.bprice.bpapipos.service;

import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.persistance.model.PointVente;

import java.util.List;

/**
 * Created by ahmed on 18/01/2020.
 */
public interface IPointVenteService {

    public ResponseObject CreatePointVente(PointVente pointVente);
    public ResponseObject CreateManyPointVente(List<PointVente> pointVentes);
    public ResponseObject UpdatePointVente(PointVente pointVente);
    public ResponseObject changeStatusPv(String idpointVente,Short status);
    public ResponseObject DeletePointVente(String idPointVente);
    public ResponseObject findByIdPointVente(String idPointVente);
    public ResponseObject findAllByFActif(Short fActif);
    public ResponseObject findAllByIdPartenaire(String idPartenaireBprice);
    public ResponseObject findAllByIdPartenaireAndFActif(String idPartenaireBprice, Short fActif);
}
