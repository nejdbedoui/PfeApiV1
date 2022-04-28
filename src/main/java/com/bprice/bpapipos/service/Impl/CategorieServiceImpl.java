package com.bprice.bpapipos.service.Impl;

import com.bprice.bpapipos.Enum.EnumMessage;
import com.bprice.bpapipos.repository.ICategorieRepository;
import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.bpapipos.service.IActionMarketingService;
import com.bprice.bpapipos.service.ICategorieService;
import com.bprice.persistance.model.ActionMarketing;
import com.bprice.persistance.model.Categorie;
import com.bprice.persistance.model.PartenaireBprice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements ICategorieService {
    @Autowired
    IActionMarketingService actionMarketingService;
    @Autowired
    ICategorieRepository categorieRepository;
    @Override
    public ResponseObject CreateCategorie(Categorie categorie) {
        try {
            if (categorie != null) {


                        Categorie result = categorieRepository.save(categorie);
                        return new ResponseObject(EnumMessage.SUCCESS_CREATION.code,
                                EnumMessage.SUCCESS_CREATION.label, result);





            } else {
                return new ResponseObject(EnumMessage.CATEGORIE_EMPTY.code, EnumMessage.CATEGORIE_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, e.getMessage(), null);
        }
    }

    @Override
    public ResponseObject DeleteCategorie(String Idcat) {
        try {
            if (Idcat != null) {
                if (categorieRepository.existsById(Idcat)) {
                    categorieRepository.deleteById(Idcat);
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
    public ResponseObject UpdateCategorie(Categorie categorie) {
        try {
            if (categorie != null) {
                if (categorieRepository.existsById(categorie.getIdCategorie())) {


                            Categorie result = categorieRepository.save(categorie);
                            return new ResponseObject(EnumMessage.SUCCESS_UPDATE.code,
                                    EnumMessage.SUCCESS_UPDATE.label, result);




                } else {
                    return new ResponseObject(EnumMessage.CATEGORIE_NOT_EXIST.code, EnumMessage.CATEGORIE_NOT_EXIST.label,
                            null);

                }

            } else {
                return new ResponseObject(EnumMessage.CATEGORIE_EMPTY.code, EnumMessage.CATEGORIE_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, e.getMessage(), null);
        }
    }

    @Override
    public ResponseObject findByIdCategorie(String IdCat) {
        try {
            if (IdCat != null) {
                Categorie result = categorieRepository.findCategorieByIdCategorie(IdCat);
                if (result != null) {
                    return new ResponseObject(EnumMessage.CATEGORIE_EXIST.code, EnumMessage.CATEGORIE_EXIST.label, result);
                } else {
                    return new ResponseObject(EnumMessage.CATEGORIE_NOT_EXIST.code, EnumMessage.CATEGORIE_NOT_EXIST.label,
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
            List<Categorie> result = categorieRepository.findAll();
            if (result != null) {
                return new ResponseObject(EnumMessage.LIST_CATEGORIE_NOT_EMPTY.code, EnumMessage.LIST_CATEGORIE_NOT_EMPTY.label,
                        result);
            } else {
                return new ResponseObject(EnumMessage.LIST_CATEGORIE_EMPTY.code, EnumMessage.LIST_CATEGORIE_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }


    @Override
    public ResponseObject findAll() {
        try {
            List<Categorie> result = categorieRepository.findAll();
            if (result != null) {
                return new ResponseObject(EnumMessage.LIST_CATEGORIE_NOT_EMPTY.code, EnumMessage.LIST_CATEGORIE_NOT_EMPTY.label,
                        result);
            } else {
                return new ResponseObject(EnumMessage.LIST_CATEGORIE_EMPTY.code, EnumMessage.LIST_CATEGORIE_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }
}
