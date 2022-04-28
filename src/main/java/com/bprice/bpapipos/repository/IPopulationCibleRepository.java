package com.bprice.bpapipos.repository;

import com.bprice.persistance.model.Categorie;
import com.bprice.persistance.model.PopulationCible;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IPopulationCibleRepository extends MongoRepository<PopulationCible,String> {
    public PopulationCible findPopulationCibleByIdPopulationCible(String idPopulation);
    public List<PopulationCible> findAll();
    public PopulationCible findPopulationCibleByAgeEqualsAndSexeEqualsAndVilleEquals(String age,String sexe,String ville );
}
