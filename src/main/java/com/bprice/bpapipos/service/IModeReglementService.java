package com.bprice.bpapipos.service;

import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.persistance.model.ModeReglement;

/**
 * Created by ahmed on 06/02/2020.
 */
public interface IModeReglementService {
    public ResponseObject CreateModeReglement(ModeReglement modeReglement);
    public ResponseObject DeleteModeReglement(String idModeReglement);
    public ResponseObject UpdateModeReglement(ModeReglement modeReglement);
    public ResponseObject findByIdModeReglement(String idModeReglement);
    public ResponseObject findAllByIdPointVente(String idpointvente);
    public ResponseObject findAll();
}
