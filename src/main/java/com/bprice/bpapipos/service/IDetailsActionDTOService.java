package com.bprice.bpapipos.service;

import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.persistance.model.ActionMarketing;

public interface IDetailsActionDTOService {
    public ResponseObject findDetailsByAction(ActionMarketing actionMarketing);
}
