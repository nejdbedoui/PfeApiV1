package com.bprice.bpapipos.repository;


import com.bprice.persistance.model.ActionMarketing;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface IActionMarketingRepository extends MongoRepository<ActionMarketing,String> {
    public List<ActionMarketing> findAllByIdPartenaire(String IdPartenaire);
    public List<ActionMarketing> findAll();
    public List<ActionMarketing> findAllByStatut(int statut);
    public List<ActionMarketing> findAllByStatutGreaterThan(int statut);
    public ActionMarketing findActionMarketingByIdActionMarketing(String IdAction);
    public List<ActionMarketing> findAllActionMarketingByIdPartenaireAndDateCreationBetween(String IdPartenaire,Date DateDebut,Date DateFin);
    public List<ActionMarketing> findActionMarketingByDateCreationBetween(Date DateDebut,Date DateFin);
    public List<ActionMarketing> findAllByIdCanaldiffusionAndStatutGreaterThan(String idCanal,int statut);

}
