package com.bprice.bpapipos.service;

import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.persistance.model.PartenaireBprice;
import com.bprice.persistance.model.PointVente;

import java.util.List;

/**
 * Created by ahmed on 18/01/2020.
 */
public interface IPartenaireBpriceService {

    public ResponseObject CreatePartenaireBprice(PartenaireBprice partenaireBprice);
    public ResponseObject CreateManyPartenaireBprice(List<PartenaireBprice> partenaireBprices);

    public ResponseObject DeletePartenaireBprice(String idPartenaire);
    public ResponseObject findByIdPartenaire(String idPartenaire);
    public ResponseObject findAllByFActif(Short factif);
   // public ResponseObject findAllByIdSector(String idSector);
    public ResponseObject findAllByIdVille(String idVille);
    //public ResponseObject findAllByIdSectorAndFActif(String idSector,Short factif);

    public ResponseObject findAllByIdVilleAndFActif(String idVille, Short factif) ;




    public ResponseObject entityToDto(String idPartenaire,short fActif);

}
