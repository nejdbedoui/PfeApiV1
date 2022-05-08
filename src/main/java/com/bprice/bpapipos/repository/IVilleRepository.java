package com.bprice.bpapipos.repository;

import com.bprice.persistance.model.Ville;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IVilleRepository extends MongoRepository<Ville,String> {
    public List<Ville> findAllByFActiveEquals(int active);
    public List<Ville> findAll();


}
