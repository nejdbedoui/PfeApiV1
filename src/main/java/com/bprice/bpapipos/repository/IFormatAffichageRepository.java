package com.bprice.bpapipos.repository;


import com.bprice.persistance.model.FormatAffichage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IFormatAffichageRepository extends MongoRepository<FormatAffichage,String> {
    public List<FormatAffichage> findAll();
    public List<FormatAffichage> findAllByTypeAndFActifEquals(String type,int active);
}
