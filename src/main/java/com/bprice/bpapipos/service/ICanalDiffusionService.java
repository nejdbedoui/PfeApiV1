package com.bprice.bpapipos.service;

import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.persistance.model.CanalDiffusion;


public interface ICanalDiffusionService {

    public ResponseObject findAllCanal();
    public ResponseObject createCanal(CanalDiffusion canalDiffusion);
    public ResponseObject updateCanal(CanalDiffusion canalDiffusion);
    public ResponseObject deleteCanal(String id);
    public ResponseObject findAllActiveCanal();
}
