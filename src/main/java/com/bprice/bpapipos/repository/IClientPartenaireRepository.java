package com.bprice.bpapipos.repository;

import com.bprice.persistance.model.ClientPartenaire;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IClientPartenaireRepository extends MongoRepository<ClientPartenaire,String> {
}
