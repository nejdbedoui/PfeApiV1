package com.bprice.bpapipos.service;

import com.bprice.bpapipos.dto.ActionMarketingDTO;
import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.persistance.model.Categorie;
import com.bprice.persistance.model.Contrat;

public interface IContratActionService {
    public ResponseObject CreateActionContract(ActionMarketingDTO actionMarketingDTO);
    public ResponseObject DeleteActionContract(String IdContract);
    public ResponseObject UpdateActionContract(Contrat contrat);
    public ResponseObject findByIdActionContract(String IdContract);
    public ResponseObject findAllContract();


}
