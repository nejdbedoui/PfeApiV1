package com.bprice.bpapipos.service;

import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.persistance.model.Storage;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface IStorageService {
    public ResponseObject Deleteitem(String id);
    public ResponseObject finditembyid(String id);
    public String uploadFile(File file, String fileName) throws IOException;
    public File convertToFile(MultipartFile multipartFile, String fileName);
    public String getExtension(String fileName);
    public ResponseObject upload(MultipartFile multipartFile);
    public ResponseObject DeletePublicicteImage(String fileName) throws IOException;

    }
