package com.bprice.bpapipos.service.Impl;


import com.bprice.bpapipos.Enum.EnumMessage;
import com.bprice.bpapipos.repository.IStorageRepository;
import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.bpapipos.service.IStorageService;
import com.bprice.persistance.model.Storage;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@Service
public class StorageServiceImpl  implements IStorageService {
    @Autowired
    private IStorageRepository storageRepository;

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFsOperations operations;
    @Override
    public ResponseObject AddtoStorage(MultipartFile file){
        try{
            Storage s=new Storage();


            if(file.getContentType().indexOf("image")!=-1){
                s.setName(StringUtils.cleanPath(file.getOriginalFilename()));
                s.setType(file.getContentType());
                s.setImagedata(file.getBytes());
                s.setSize(file.getSize());
                storageRepository.save(s);
                return new ResponseObject(EnumMessage.Image_added.code, EnumMessage.Image_added.label,
                        s);
            }else if(file.getContentType().indexOf("video")!=-1){
                DBObject metaData = new BasicDBObject();
                metaData.put("type", "video");
                ObjectId id = gridFsTemplate.store(
                        file.getInputStream(), file.getName(), file.getContentType(), metaData);



                s.setName(StringUtils.cleanPath(file.getOriginalFilename()));
                s.setType(file.getContentType());

                storageRepository.save(s);
                return new ResponseObject(EnumMessage.Video_added.code, EnumMessage.Video_added.label,
                        s);
            }else{
                return new ResponseObject(EnumMessage.File_added_failed.code, EnumMessage.File_added_failed.label,
                        null);
            }

        }catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }



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
}
