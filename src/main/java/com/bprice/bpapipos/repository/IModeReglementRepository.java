package com.bprice.bpapipos.repository;

import com.bprice.persistance.model.ModeReglement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ahmed on 06/02/2020.
 */
@Repository
public interface IModeReglementRepository extends MongoRepository<ModeReglement,String> {
    public ModeReglement findByIdModeReglement(String idModeReglement);
    public ModeReglement findAllByCode(String code);
    public ModeReglement findAllByCodeAndIdPointVente(String code,String idPointVente);
    public List<ModeReglement>  findAllByIdPointVente(String idPointVente);
    public List<ModeReglement>  findAllByIdPointVenteIsNull();


}
