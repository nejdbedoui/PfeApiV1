package com.bprice.bpapipos.service;

import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.persistance.model.TypeAffichage;

public interface ITypeAffichageService {
    public ResponseObject findAllTypeAffichage();
    public ResponseObject createTypeAffichage(TypeAffichage typeAffichage);
    public ResponseObject updateTypeAffichage(TypeAffichage typeAffichage);
    public ResponseObject deleteTypeAffichage(String idTypeAffichage);
    public ResponseObject findAllActiveTypeAffichage();
}
