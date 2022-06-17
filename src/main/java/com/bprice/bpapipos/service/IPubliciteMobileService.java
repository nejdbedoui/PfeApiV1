package com.bprice.bpapipos.service;

import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.persistance.model.FormatAffichage;
import com.bprice.persistance.model.PubliciteMobile;

public interface IPubliciteMobileService {
    public ResponseObject findAllPubliciteMobile();
    public ResponseObject createPubliciteMobile(PubliciteMobile publiciteMobile);
    public ResponseObject deletePubliciteMobile(String idPubliciteMobile);
    public ResponseObject findAllPubliciteMobileByStatut(int statut);
    public ResponseObject findPubliciteMobileById(String idPubliciteMobile);
    public ResponseObject findPubliciteMobileByIdPartenaireCible(String idPartenaireCible);
}
