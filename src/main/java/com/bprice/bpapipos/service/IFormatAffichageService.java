package com.bprice.bpapipos.service;

import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.persistance.model.FormatAffichage;

public interface IFormatAffichageService {

    public ResponseObject findAllformat();
    public ResponseObject createformat(FormatAffichage formatAffichage);
    public ResponseObject updateformat(FormatAffichage formatAffichage);
    public ResponseObject deleteformat(String id);
    public ResponseObject findAllActiveformat();
}
