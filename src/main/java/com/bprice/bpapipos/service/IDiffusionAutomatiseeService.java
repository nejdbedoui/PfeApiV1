package com.bprice.bpapipos.service;

import com.bprice.bpapipos.response.ResponseObject;

public interface IDiffusionAutomatiseeService {
    public void MiseAJour();

    public ResponseObject check(String id);

    void click(String idClient);



}
