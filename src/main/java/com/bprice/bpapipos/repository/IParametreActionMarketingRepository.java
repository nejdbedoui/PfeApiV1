package com.bprice.bpapipos.repository;

import com.bprice.persistance.model.ParametreActionMarketing;
import com.bprice.persistance.model.ModeReglement;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface IParametreActionMarketingRepository extends MongoRepository<ParametreActionMarketing,String> {

    public List<ParametreActionMarketing> findAll();
    public ParametreActionMarketing findParametreActionMarketingByIdParametreAction(String IdParametre);
    public List<ParametreActionMarketing> findParametreActionMarketingByDateCreationBetween(Date DateDebut,Date DateFin);
    public ParametreActionMarketing findByIdActionMarketingAndIdPartenaireCible(String idActionMarketing, String idPartenaireCible);
    public List<ParametreActionMarketing> findAllByIdPartenaireCibleAndStatut(String idPartenaireCible,int statut);

    public List<ParametreActionMarketing> findByIdPartenaireCibleAndStatutAndIdActionMarketing(String idPartenaireCible,int statut,String idaction);

    public List<ParametreActionMarketing> findAllByIdPartenaireCible(String idPartenaireCible);

}
