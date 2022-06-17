package com.bprice.bpapipos.repository;

import com.bprice.persistance.model.PubliciteMobile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IPubliciteMobileRepository extends MongoRepository<PubliciteMobile, String> {
    public List<PubliciteMobile> findAll();
    public List<PubliciteMobile> findAllByStatut(int statut);
    List<PubliciteMobile> findAllByPartenaireCiblesIdContaining(String idPartenaire);
}
