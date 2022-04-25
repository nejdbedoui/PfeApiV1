package com.bprice.bpapipos.repository;


import com.bprice.persistance.model.ActionMarketing;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface IActionMarketingRepository extends MongoRepository<ActionMarketing,String> {
    public List<ActionMarketing> findAllByIdPartenaireAndDateCreation(String IdPartenaire,Date DateDebut,Date DateFin);
    public List<ActionMarketing> findAllByDateCreation(Date DateDebut,Date DateFin);
    public List<ActionMarketing> findAllByIdPartenaire(String IdPartenaire);
    public List<ActionMarketing> findAll();
    public ActionMarketing findActionMarketingByIdActionMarketing(String IdAction);
    public List<ActionMarketing> findActionMarketingByIdPartenaireAndDateCreationBetween(String IdPartenaire,Date DateDebut,Date DateFin);
    public List<ActionMarketing> findActionMarketingByDateCreationBetween(Date DateDebut,Date DateFin);
}
