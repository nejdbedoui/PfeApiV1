package com.bprice.bpapipos.service.Impl;

import com.bprice.bpapipos.Enum.EnumMessage;
import com.bprice.bpapipos.repository.IPopulationCibleRepository;
import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.bpapipos.service.IActionMarketingService;
import com.bprice.bpapipos.service.IPopulationCibleService;
import com.bprice.persistance.model.ActionMarketing;
import com.bprice.persistance.model.Categorie;
import com.bprice.persistance.model.PopulationCible;
import com.sun.org.apache.bcel.internal.generic.POP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPopulationCibleServiceImpl implements IPopulationCibleService {
    @Autowired
    IActionMarketingService actionMarketingService;
    @Autowired
    IPopulationCibleRepository populationCibleRepository;
    @Override
    public ResponseObject CreatePopulationCible(PopulationCible populationCible) {
        try {
            if (populationCible != null) {


                        PopulationCible result = populationCibleRepository.save(populationCible);
                        return new ResponseObject(EnumMessage.SUCCESS_CREATION.code,
                                EnumMessage.SUCCESS_CREATION.label, result);





            } else {
                return new ResponseObject(EnumMessage.POPULATIONCIBLE_EMPTY.code, EnumMessage.POPULATIONCIBLE_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, e.getMessage(), null);
        }
    }

    @Override
    public ResponseObject DeletePopulationCible(String IdPopulation) {
        try {
            if (IdPopulation != null) {
                if (populationCibleRepository.existsById(IdPopulation)) {
                    populationCibleRepository.deleteById(IdPopulation);
                    return new ResponseObject(EnumMessage.SUCCESS_DELETE.code, EnumMessage.SUCCESS_DELETE.label, true);
                } else {
                    return new ResponseObject(EnumMessage.CATEGORIE_EMPTY.code, EnumMessage.CATEGORIE_EMPTY.label,
                            false);
                }
            } else {
                return new ResponseObject(EnumMessage.ID_EMPTY.code, EnumMessage.ID_EMPTY.label, false);

            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

    @Override
    public ResponseObject UpdatePopulationCible(PopulationCible populationCible) {
        try {
            if (populationCible != null) {
                if (populationCibleRepository.existsById(populationCible.getIdPopulationCible())) {


                            PopulationCible result = populationCibleRepository.save(populationCible);
                            return new ResponseObject(EnumMessage.SUCCESS_UPDATE.code,
                                    EnumMessage.SUCCESS_UPDATE.label, result);



                } else {
                    return new ResponseObject(EnumMessage.POPULATIONCIBLE_NOT_EXIST.code, EnumMessage.POPULATIONCIBLE_NOT_EXIST.label,
                            null);

                }

            } else {
                return new ResponseObject(EnumMessage.POPULATIONCIBLE_EMPTY.code, EnumMessage.POPULATIONCIBLE_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, e.getMessage(), null);
        }
    }

    @Override
    public ResponseObject findByIdPopulationCible(String IdPopulation) {
        try {
            if (IdPopulation != null) {
                PopulationCible result = populationCibleRepository.findPopulationCibleByIdPopulationCible(IdPopulation);
                if (result != null) {
                    return new ResponseObject(EnumMessage.POPULATIONCIBLE_EXIST.code, EnumMessage.POPULATIONCIBLE_EXIST.label, result);
                } else {
                    return new ResponseObject(EnumMessage.POPULATIONCIBLE_NOT_EXIST.code, EnumMessage.POPULATIONCIBLE_NOT_EXIST.label,
                            null);
                }
            } else {
                return new ResponseObject(EnumMessage.ID_EMPTY.code, EnumMessage.ID_EMPTY.label, null);

            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

    @Override
    public ResponseObject findAllByIdActionMarketing() {
        try {
            List<PopulationCible> result = populationCibleRepository.findAll();
            if (result != null) {
                return new ResponseObject(EnumMessage.LIST_POPULATIONCIBLE_NOT_EMPTY.code, EnumMessage.LIST_POPULATIONCIBLE_NOT_EMPTY.label,
                        result);
            } else {
                return new ResponseObject(EnumMessage.LIST_POPULATIONCIBLE_EMPTY.code, EnumMessage.LIST_POPULATIONCIBLE_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);



    @Override
    public ResponseObject findAll() {
        try {
            List<PopulationCible> result = populationCibleRepository.findAll();
            if (result != null) {
                return new ResponseObject(EnumMessage.LIST_POPULATIONCIBLE_NOT_EMPTY.code, EnumMessage.LIST_POPULATIONCIBLE_NOT_EMPTY.label,
                        result);
            } else {
                return new ResponseObject(EnumMessage.LIST_POPULATIONCIBLE_EMPTY.code, EnumMessage.LIST_POPULATIONCIBLE_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }
}
