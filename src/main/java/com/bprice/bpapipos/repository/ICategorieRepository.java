package com.bprice.bpapipos.repository;

import com.bprice.persistance.model.Categorie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ICategorieRepository extends MongoRepository<Categorie, String> {
    public List<Categorie> findAll();
    public Categorie findCategorieByIdCategorie(String idCategorie);
    public List<Categorie> findCategorieByIdActionMarketing(String idAction);
}
