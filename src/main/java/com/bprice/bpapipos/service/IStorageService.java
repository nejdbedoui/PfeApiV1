package com.bprice.bpapipos.service;

import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.persistance.model.Storage;
import org.springframework.web.multipart.MultipartFile;

public interface IStorageService {
    public ResponseObject AddtoStorage(MultipartFile storage);
    public ResponseObject Deleteitem(String id);
    public ResponseObject finditembyid(String id);
}
