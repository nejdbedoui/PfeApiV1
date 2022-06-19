package com.bprice.bpapipos.repository;

import com.bprice.persistance.model.Historique;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IHistoriqueRepository extends MongoRepository<Historique,String> {
   public List<Historique> findAllByIdActionmarketingAndIdClient(String idAction,String idClient);
}
