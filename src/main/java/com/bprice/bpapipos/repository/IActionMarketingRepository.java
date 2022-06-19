package com.bprice.bpapipos.repository;


import com.bprice.persistance.model.ActionMarketing;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface IActionMarketingRepository extends MongoRepository<ActionMarketing,String> {
    public List<ActionMarketing> findAllByIdPartenaireOrderByDateCreationDesc(String IdPartenaire);
    public List<ActionMarketing> findAll();
    public List<ActionMarketing> findAllByStatutOrderByDateCreationDesc(int statut);
    public List<ActionMarketing> findAllByStatutGreaterThanOrderByDateCreationDesc(int statut);
    public ActionMarketing findActionMarketingByIdActionMarketing(String IdAction);
    public List<ActionMarketing> findAllActionMarketingByIdPartenaireAndDateCreationBetweenOrderByDateCreationDesc(String IdPartenaire,Date DateDebut,Date DateFin);
    public List<ActionMarketing> findActionMarketingByDateCreationBetweenOrderByDateCreationDesc(Date DateDebut,Date DateFin);
    public List<ActionMarketing> findAllByIdCanaldiffusionAndStatutGreaterThanOrderByDateCreationDesc(String idCanal,int statut);


    public int countActionMarketingByNotificationEquals(int num);
    public int countActionMarketingByNotificationEqualsAndIdPartenaire(int num,String idpartenaire);
   // public List<ActionMarketing> findAllByStatutAndAuto(int statut,boolean auto);




}
