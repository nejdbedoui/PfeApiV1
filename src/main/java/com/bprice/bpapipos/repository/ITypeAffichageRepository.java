package com.bprice.bpapipos.repository;

import com.bprice.persistance.model.FormatAffichage;
import com.bprice.persistance.model.TypeAffichage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ITypeAffichageRepository extends MongoRepository<TypeAffichage, String> {
    public List<TypeAffichage> findAll();
    public List<TypeAffichage> findAllByFActifEquals(int fActif);
}
