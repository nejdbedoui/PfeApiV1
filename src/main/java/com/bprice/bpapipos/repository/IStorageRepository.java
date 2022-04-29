package com.bprice.bpapipos.repository;


import com.bprice.persistance.model.Storage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IStorageRepository extends MongoRepository<Storage,String> {
    public Storage findByIdStorage(String id);

}
