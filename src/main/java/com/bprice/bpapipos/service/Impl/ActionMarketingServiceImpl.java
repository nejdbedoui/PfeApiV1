package com.bprice.bpapipos.service.Impl;

import com.bprice.bpapipos.Enum.EnumMessage;
import com.bprice.bpapipos.repository.IActionMarketingRepository;
import com.bprice.bpapipos.repository.IPartenaireBpriceRepository;
import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.bpapipos.service.IActionMarketingService;
import com.bprice.bpapipos.service.IPartenaireBpriceService;
import com.bprice.persistance.model.ActionMarketing;
import com.bprice.persistance.model.ModeReglement;
import com.bprice.persistance.model.PartenaireBprice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ActionMarketingServiceImpl implements IActionMarketingService {
    @Autowired
    IPartenaireBpriceRepository partenaireBpriceRepository;
    @Autowired
    IPartenaireBpriceService partenaireBpriceService;
    @Autowired
    IActionMarketingRepository actionMarketingRepository;

    @Override
    public ResponseObject CreateActionMarketing(ActionMarketing actionMarketing) {
        try {
            if (actionMarketing != null) {
                if (actionMarketing.getIdPartenaire() != null) {
                    PartenaireBprice partenaireBprice = (PartenaireBprice) partenaireBpriceService.findByIdPartenaire(actionMarketing.getIdPartenaire())
                            .getObjectResponse();
                    if (partenaireBprice != null) {
                        ActionMarketing result = actionMarketingRepository.save(actionMarketing);
                        return new ResponseObject(EnumMessage.SUCCESS_CREATION.code,
                                EnumMessage.SUCCESS_CREATION.label, result);



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
    public ResponseObject DeleteActionMarketing(String Idaction) {
        try {
            if (Idaction != null) {
                if (actionMarketingRepository.existsById(Idaction)) {
                    actionMarketingRepository.deleteById(Idaction);
                    return new ResponseObject(EnumMessage.SUCCESS_DELETE.code, EnumMessage.SUCCESS_DELETE.label, true);
                } else {
                    return new ResponseObject(EnumMessage.ACTIONMARKETING_EMPTY.code, EnumMessage.ACTIONMARKETING_EMPTY.label,
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
    public ResponseObject UpdateActionMarketing(ActionMarketing actionMarketing) {
        try {
            if (actionMarketing != null) {
                if (actionMarketingRepository.existsById(actionMarketing.getIdActionMarketing())) {
                    if (actionMarketing.getIdPartenaire() != null) {
                        PartenaireBprice partenaireBprice = (PartenaireBprice) partenaireBpriceService
                                .findByIdPartenaire(actionMarketing.getIdPartenaire()).getObjectResponse();
                        if (partenaireBprice != null) {
                                    ActionMarketing result = actionMarketingRepository.save(actionMarketing);
                                    return new ResponseObject(EnumMessage.SUCCESS_UPDATE.code,
                                            EnumMessage.SUCCESS_UPDATE.label, result);


                        } else {
                            return new ResponseObject(EnumMessage.PARTENAIREBPRICE_EMPTY.code,
                                    EnumMessage.PARTENAIREBPRICE_EMPTY.label, null);

                        }
                    } else {
                        return new ResponseObject(EnumMessage.PARTENAIREBPRICE_ID_EMPTY.code,
                                EnumMessage.PARTENAIREBPRICE_ID_EMPTY.label, null);
                    }
                } else {
                    return new ResponseObject(EnumMessage.ACTIONMARKETING_NOT_EXIST.code, EnumMessage.ACTIONMARKETING_NOT_EXIST.label,
                            null);

                }

            } else {
                return new ResponseObject(EnumMessage.ACTIONMARKETING_EMPTY.code, EnumMessage.ACTIONMARKETING_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, e.getMessage(), null);
        }
    }

    @Override
    public ResponseObject findByIdActionMarketing(String IdAction) {
        try {
            if (IdAction != null) {
                ActionMarketing result = actionMarketingRepository.findActionMarketingByIdActionMarketing(IdAction);
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
        try {
            List<ActionMarketing> result = actionMarketingRepository.findActionMarketingByIdPartenaireAndDateCreationBetween(IdPartenaire,DateDebut,DateFin);
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
    public ResponseObject findAllByDateCreation(Date DateDebut, Date DateFin) {
        try {
            List<ActionMarketing> result = actionMarketingRepository.findActionMarketingByDateCreationBetween(DateDebut,DateFin);
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
    public ResponseObject findAllByIdPartenaire(String IdPartenaire) {
        try {
            List<ActionMarketing> result = actionMarketingRepository.findAllByIdPartenaire(IdPartenaire);
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
    public ResponseObject findAll() {
        try {
            List<ActionMarketing> result = actionMarketingRepository.findAll();
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
}
