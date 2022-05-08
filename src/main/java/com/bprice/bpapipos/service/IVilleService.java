package com.bprice.bpapipos.service;

import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.persistance.model.Ville;

public interface IVilleService {
    public ResponseObject findAllVille();
    public ResponseObject createVille(Ville villep);
    public ResponseObject updateVille(Ville villep);
    public ResponseObject deleteVille(String id);
    public ResponseObject findAllActiveVille();
}
