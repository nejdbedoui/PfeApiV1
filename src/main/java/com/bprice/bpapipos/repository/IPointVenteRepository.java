package com.bprice.bpapipos.repository;

import com.bprice.persistance.model.PointVente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ahmed on 18/01/2020.
 */
@Repository
public interface IPointVenteRepository extends MongoRepository<PointVente,String> {
    public PointVente findByIdPointVente(String idPointVente);
    public List<PointVente> findAllByFActif(short fActif);
    public List<PointVente> findAllByIdPartenaire(String idPartenaireBprice);
    public List<PointVente> findAllByIdPartenaireAndFActif(String idPartenaireBprice, short fActif);

}
