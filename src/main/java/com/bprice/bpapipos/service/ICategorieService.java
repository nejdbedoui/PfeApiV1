package com.bprice.bpapipos.service;

import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.persistance.model.Categorie;

public interface ICategorieService {
    public ResponseObject CreateCategorie(Categorie categorie);
    public ResponseObject DeleteCategorie(String Idcat);
    public ResponseObject UpdateCategorie(Categorie categorie);
    public ResponseObject findByIdCategorie(String Idcat);
    public ResponseObject findAllByIdActionMarketing();
    public ResponseObject findAll();
}
