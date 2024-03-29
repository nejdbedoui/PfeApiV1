package com.bprice.bpapipos.service.Impl;

import com.bprice.bpapipos.Enum.EnumMessage;
import com.bprice.bpapipos.repository.IActionMarketingRepository;
import com.bprice.bpapipos.repository.IParametreActionMarketingRepository;
import com.bprice.bpapipos.repository.IPartenaireBpriceRepository;
import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.bpapipos.service.IActionMarketingService;
import com.bprice.bpapipos.service.IParametreActionMarketingService;
import com.bprice.bpapipos.service.IPartenaireBpriceService;
import com.bprice.persistance.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ParametreActionMarketingServiceImpl implements IParametreActionMarketingService {

    @Autowired
    IPartenaireBpriceService partenaireBpriceService;
    @Autowired
    IParametreActionMarketingRepository parametreActionMarketingRepository;
    @Autowired
    IActionMarketingService actionMarketingService;
    @Autowired
    IActionMarketingRepository actionMarketingRepository;
    @Override
    public ResponseObject CreateParametreActionMarketing(ParametreActionMarketing parametreActionMarketing) {
        System.out.println(parametreActionMarketing);
        try {
            if (parametreActionMarketing != null) {
                if (parametreActionMarketing.getIdPartenaireCible() != null) {
                    PartenaireBprice partenaireBprice = (PartenaireBprice) partenaireBpriceService.findByIdPartenaire(parametreActionMarketing.getIdPartenaireCible())
                            .getObjectResponse();
                    if (partenaireBprice != null) {
                        ActionMarketing actionMarketing = (ActionMarketing) actionMarketingService.findByIdActionMarketing(parametreActionMarketing.getIdActionMarketing())
                                .getObjectResponse();
                        if(actionMarketing!=null) {
                           ParametreActionMarketing result = parametreActionMarketingRepository.save(parametreActionMarketing);
                            return new ResponseObject(EnumMessage.SUCCESS_CREATION.code,
                                    EnumMessage.SUCCESS_CREATION.label, result);
                        }
                        else {
                            return new ResponseObject(EnumMessage.ACTIONMARKETING_NOT_EXIST.code,
                                    EnumMessage.ACTIONMARKETING_NOT_EXIST.label, null);
                        }


                    } else {
                        return new ResponseObject(EnumMessage.PARTENAIREBPRICE_NOT_EXIST.code,
                                EnumMessage.PARTENAIREBPRICE_NOT_EXIST.label, null);

                    }
                } else {
                    return new ResponseObject(EnumMessage.PARTENAIREBPRICE_EMPTY.code,
                            EnumMessage.PARTENAIREBPRICE_EMPTY.label, null);
                }
            } else {
                return new ResponseObject(EnumMessage.ACTIONMARKETING_EMPTY.code, EnumMessage.ACTIONMARKETING_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, e.getMessage(), null);
        }
    }

    @Override
    public ResponseObject DeleteParametreActionMarketing(String Idaction) {
        return null;
    }

    @Override
    public ResponseObject UpdateParametreActionMarketing(ParametreActionMarketing parametreActionMarketing) {
        try {
            if (parametreActionMarketing != null) {
                if (parametreActionMarketingRepository.existsById(parametreActionMarketing.getIdParametreAction())) {


                    ParametreActionMarketing result = parametreActionMarketingRepository.save(parametreActionMarketing);
                    return new ResponseObject(EnumMessage.SUCCESS_UPDATE.code,
                            EnumMessage.SUCCESS_UPDATE.label, result);




                } else {
                    return new ResponseObject(EnumMessage.CANALEDIFFUSION_NOT_EXIST.code, EnumMessage.CANALEDIFFUSION_NOT_EXIST.label,
                            null);

                }

            } else {
                return new ResponseObject(EnumMessage.CANALEDIFFUSION_EMPTY.code, EnumMessage.CANALEDIFFUSION_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, e.getMessage(), null);
        }
    }

    @Override
    public ResponseObject findByIdParametreActionMarketing(String IdAction) {
        try {
            if (IdAction != null) {
                ParametreActionMarketing result = parametreActionMarketingRepository.findParametreActionMarketingByIdParametreAction(IdAction);
                if (result != null) {
                    return new ResponseObject(EnumMessage.ACTIONMARKETING_EXIST.code, EnumMessage.ACTIONMARKETING_EXIST.label, result);
                } else {
                    return new ResponseObject(EnumMessage.ACTIONMARKETING_NOT_EXIST.code, EnumMessage.ACTIONMARKETING_NOT_EXIST.label,
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
    public ResponseObject findAllByIdPartenaireAndDateCreation(String IdPartenaire, Date DateDebut, Date DateFin) {
        return null;
    }

    @Override
    public ResponseObject findAllByDateCreation(Date DateDebut, Date DateFin) {
        return null;
    }

    @Override
    public ResponseObject findAllByIdPartenaire(String IdPartenaire) {
        return null;
    }

    @Override
    public ResponseObject findAll() {
        try {
            List<ParametreActionMarketing> result = parametreActionMarketingRepository.findAll();
            if (result.size() >0) {
                return new ResponseObject(EnumMessage.LIST_ACTIONMARKETING_NOT_EMPTY.code, EnumMessage.LIST_ACTIONMARKETING_NOT_EMPTY.label,
                        result);
            } else {
                return new ResponseObject(EnumMessage.LIST_ACTIONMARKETING_EMPTY.code, EnumMessage.LIST_ACTIONMARKETING_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

    @Override
    public ResponseObject findByIdActionMarketingAndIdPartenaireCible(String idActionMarketing, String idPartenaireCible) {
        try {
            if (idActionMarketing != null && idPartenaireCible!=null) {
                ParametreActionMarketing result = parametreActionMarketingRepository.findByIdActionMarketingAndIdPartenaireCible(idActionMarketing,idPartenaireCible);
                if (result != null) {
                    return new ResponseObject(EnumMessage.ACTIONMARKETING_EXIST.code, EnumMessage.ACTIONMARKETING_EXIST.label, result);
                } else {
                    return new ResponseObject(EnumMessage.ACTIONMARKETING_NOT_EXIST.code, EnumMessage.ACTIONMARKETING_NOT_EXIST.label,
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
    public ResponseObject findAllByIdPartenaireCibleAndStatut(String idPartenaire, int statut) {
        try {
            List<ParametreActionMarketing> result = parametreActionMarketingRepository.findAllByIdPartenaireCibleAndStatut(idPartenaire, statut);
            if (result != null) {
                return new ResponseObject(EnumMessage.LIST_ACTIONMARKETING_NOT_EMPTY.code, EnumMessage.LIST_ACTIONMARKETING_NOT_EMPTY.label,
                        result);
            } else {
                return new ResponseObject(EnumMessage.LIST_ACTIONMARKETING_EMPTY.code, EnumMessage.LIST_ACTIONMARKETING_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

    @Override
    public ResponseObject findAllByIdActionMarketingAndStatut(String idAction,int statut) {
        try {
            List<ParametreActionMarketing> result = parametreActionMarketingRepository.findAllByIdActionMarketingAndStatut(idAction, statut);
            if (result != null) {
                return new ResponseObject(EnumMessage.LIST_ACTIONMARKETING_NOT_EMPTY.code, EnumMessage.LIST_ACTIONMARKETING_NOT_EMPTY.label,
                        result);
            } else {
                return new ResponseObject(EnumMessage.LIST_ACTIONMARKETING_EMPTY.code, EnumMessage.LIST_ACTIONMARKETING_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }    }
}
