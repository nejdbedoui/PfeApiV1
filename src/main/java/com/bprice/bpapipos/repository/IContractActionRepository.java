package com.bprice.bpapipos.repository;

import com.bprice.persistance.model.CanalDiffusion;
import com.bprice.persistance.model.Contrat;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface IContractActionRepository extends MongoRepository<Contrat,String> {
    public Integer countAllByDateCreation(Date date);
    public List<Contrat> findAll();
    public  List<Contrat> findAllByIdPartenaire(String idPartenaire);
    public List<Contrat> findAllByIdActionMarketing(String IdAction);

}
