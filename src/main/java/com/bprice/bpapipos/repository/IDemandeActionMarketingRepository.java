package com.bprice.bpapipos.repository;

import com.bprice.persistance.model.ActionMarketing;
import com.bprice.persistance.model.DemandeActionMarketing;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface IDemandeActionMarketingRepository extends MongoRepository<DemandeActionMarketing,String> {
    public List<DemandeActionMarketing> findAllByIdPartenaireOrderByDateCreationDesc(String IdPartenaire);
    public List<DemandeActionMarketing> findAllByIdPartenaireAndStatutEqualsOrderByDateCreationDesc(String IdPartenaire,int statut);


    public List<DemandeActionMarketing> findAll();
    public List<DemandeActionMarketing> findAllByStatutOrderByDateCreationDesc(int statut);
    public List<DemandeActionMarketing> findAllByStatutGreaterThanOrderByDateCreationDesc(int statut);
    public DemandeActionMarketing findDemandeActionMarketingByIdDemandeActionMarketing(String idDemande);
    public List<DemandeActionMarketing> findAllDemandeActionMarketingByIdPartenaireAndDateCreationBetweenOrderByDateCreationDesc(String IdPartenaire, Date DateDebut, Date DateFin);
    public List<DemandeActionMarketing> findDemandeActionMarketingByDateCreationBetweenOrderByDateCreationDesc(Date DateDebut,Date DateFin);

}
