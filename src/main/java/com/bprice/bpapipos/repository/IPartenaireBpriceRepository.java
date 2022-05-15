package com.bprice.bpapipos.repository;

import com.bprice.persistance.model.PartenaireBprice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ahmed on 18/01/2020.
 */
@Repository
public interface IPartenaireBpriceRepository extends MongoRepository<PartenaireBprice,String> {
    public PartenaireBprice findByIdPartenaire(String idPartenaire);
    public List<PartenaireBprice> findAllByFActif(short factif);
   // public List<PartenaireBprice> findAllByIdSector(String idSector);
    public List<PartenaireBprice> findAllByIdVille(String idVille);
   // public List<PartenaireBprice> findAllByIdSectorAndFActif(String idSector,short factif);
    public List<PartenaireBprice> findAllByIdVilleAndFActif(String idVille, short factif);
    public PartenaireBprice findByMatriculeFiscale(String matricule);
    public PartenaireBprice findPartenaireBpriceByIdPartenaire(String idPartenaire);




}
