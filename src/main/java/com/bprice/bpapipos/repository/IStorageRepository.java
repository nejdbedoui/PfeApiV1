package com.bprice.bpapipos.repository;


import com.bprice.persistance.model.Storage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IStorageRepository extends MongoRepository<Storage,String> {
    public Storage findByIdStorage(String id);
    public List<Storage> findAll();

}
