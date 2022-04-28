package com.bprice.bpapipos.service;

import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.persistance.model.PopulationCible;

public interface IPopulationCibleService {
    public ResponseObject CreatePopulationCible(PopulationCible populationCible);
    public ResponseObject DeletePopulationCible(String IdPopulation);
    public ResponseObject UpdatePopulationCible(PopulationCible populationCible);
    public ResponseObject findByIdPopulationCible(String IdPopulation);

    public ResponseObject findAllByIdActionMarketing();

    public ResponseObject findAll();
}
