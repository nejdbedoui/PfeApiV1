package com.bprice.bpapipos.repository;

import com.bprice.persistance.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IClientRepository extends MongoRepository<Client,String> {
}
