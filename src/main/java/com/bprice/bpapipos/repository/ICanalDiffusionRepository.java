package com.bprice.bpapipos.repository;

import com.bprice.persistance.model.CanalDiffusion;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ICanalDiffusionRepository  extends MongoRepository<CanalDiffusion,String> {
    public List<CanalDiffusion> findAll();
    public List<CanalDiffusion> findAllByFActifEquals(int active);
    public CanalDiffusion findCanalDiffusionByLibelle(String libelle);
    public CanalDiffusion findCanalDiffusionByIdCanaldiffusion(String idCanalDiffusion);
}
