package com.bprice.bpapipos.service.Impl;


import com.bprice.bpapipos.Enum.EnumMessage;
import com.bprice.bpapipos.repository.IStorageRepository;
import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.bpapipos.service.IStorageService;
import com.bprice.persistance.model.Categorie;
import com.bprice.persistance.model.Storage;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.cloud.StorageClient;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.UUID;

@Service
public class StorageServiceImpl  implements IStorageService {
    @Autowired
    private IStorageRepository storageRepository;






    @Override
    public ResponseObject Deleteitem(String id) {
        try{
            storageRepository.deleteById(id);
            return new ResponseObject(EnumMessage.SUCCESS_DELETE.code, EnumMessage.SUCCESS_DELETE.label, true);
        }catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

    @Override
    public ResponseObject finditembyid(String id) {
        try{
            Storage s=storageRepository.findByIdStorage(id);

            return new ResponseObject(EnumMessage.SUCCESS_CREATION.code, EnumMessage.SUCCESS_CREATION.label,
                    s);
        }catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

    @Override
    public ResponseObject findAll() {
        try {
            List<Storage> result = storageRepository.findAll();
            if (result != null) {
                return new ResponseObject(EnumMessage.LIST_STORAGE_NOT_EMPTY.code, EnumMessage.LIST_STORAGE_NOT_EMPTY.label,
                        result);
            } else {
                return new ResponseObject(EnumMessage.LIST_STORAGE_EMPTY.code, EnumMessage.LIST_STORAGE_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }


    @Override
    public String uploadFile(File file, String fileName) throws IOException {
        BlobId blobId = BlobId.of("pfe2022-fbd5d.appspot.com", fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("E:/Users/nabil.NEJD23/Desktop/stage$/pfe2022-fbd5d-firebase-adminsdk-unkj7-39e4219d02.json"));
        com.google.cloud.storage.Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));
        return String.format("https://firebasestorage.googleapis.com/v0/b/pfe2022-fbd5d.appspot.com/o/%s?alt=media", URLEncoder.encode(fileName, String.valueOf(StandardCharsets.UTF_8)));
    }

    @Override
    public File convertToFile(MultipartFile multipartFile, String fileName) {
        File tempFile = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempFile;    }

    @Override
    public String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));    }
    @Override
    public ResponseObject CreateStorageItem(MultipartFile multipartFile) {

        try {
            if (multipartFile !=null) {
                Storage storage = new Storage();
                if(multipartFile.getOriginalFilename()!=null) {
                    String fileName =   multipartFile.getOriginalFilename();
                    File file = this.convertToFile(multipartFile, fileName);

                    storage.setSize(file.length());
                    storage.setName(fileName);
                    storage.setType(multipartFile.getContentType());
                    Storage result = storageRepository.save(storage);
                    if(result !=null) {
                        String TEMP_URL = this.uploadFile(file, result.getIdStorage().concat(getExtension(fileName)));
                        result.setUrl(TEMP_URL);
                        storageRepository.save(result);
                        file.delete();
                        return new ResponseObject(EnumMessage.SUCCESS_CREATION.code, EnumMessage.SUCCESS_CREATION.label, result);
                    }
                    else{
                        return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

                    }
                }
                else{
                    return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);
                }
            }
            else{
                return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code,  e.getMessage(), null);
        }
    }
    @Override
        public ResponseObject DeletePublicicteImage(String fileName) throws IOException {
            BlobId blobId = BlobId.of("pfe2022-fbd5d.appspot.com", fileName);
            Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("E:/Users/nabil.NEJD23/Desktop/stage$/pfe2022-fbd5d-firebase-adminsdk-unkj7-39e4219d02.json"));
            com.google.cloud.storage.Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
          boolean result=  storage.delete(blobId);

          if(result){
              return new ResponseObject(1, "Success delete",null);

          }else{
              return new ResponseObject(0, "Unsuccess delete", null);

          }

        }






}


