package com.bprice.bpapipos.service.Impl;

import com.bprice.bpapipos.Enum.EnumMessage;
import com.bprice.bpapipos.dto.ActionMarketingDTO;
import com.bprice.bpapipos.repository.*;
import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.bpapipos.service.IActionMarketingService;
import com.bprice.bpapipos.service.IPartenaireBpriceService;
import com.bprice.persistance.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActionMarketingServiceImpl implements IActionMarketingService {

    @Autowired
    IPartenaireBpriceService partenaireBpriceService;
    @Autowired
    IPartenaireBpriceRepository partenaireBpriceRepository;
    @Autowired
    IActionMarketingRepository actionMarketingRepository;
    @Autowired
    IStorageRepository storageRepository;
    @Autowired
    IDemandeActionMarketingRepository demandeActionMarketingRepository;
    @Autowired
    IHistoriqueRepository historiqueRepository;
@Autowired
ICanalDiffusionRepository iCanalDiffusionRepository;
  @Override
    public ResponseObject CreateActionMarketing(ActionMarketing actionMarketing) {
        try {
            if (actionMarketing != null) {
                if (actionMarketing.getIdPartenaire() != null) {
                    PartenaireBprice partenaireBprice = (PartenaireBprice) partenaireBpriceService.findByIdPartenaire(actionMarketing.getIdPartenaire())
                            .getObjectResponse();
                    if (partenaireBprice != null) {
                        actionMarketing.setStatut(0);
                        ActionMarketing result = actionMarketingRepository.save(actionMarketing);
                        DemandeActionMarketing demandeActionMarketing = new DemandeActionMarketing();
                        demandeActionMarketing.setStatut(0);
                        demandeActionMarketing.setDateCreation(actionMarketing.getDateCreation());
                        demandeActionMarketing.setNotification(0);
                        demandeActionMarketing.setIdPartenaire(actionMarketing.getIdPartenaire());
                        demandeActionMarketing.setIdActionMarketing(result.getIdActionMarketing());
                        demandeActionMarketingRepository.save(demandeActionMarketing);
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
                    ActionMarketing actionMarketing=actionMarketingRepository.findById(Idaction).orElse(null);
                    storageRepository.deleteById(actionMarketing.getIdStorage());
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
            List<ActionMarketing> result = actionMarketingRepository.findAllActionMarketingByIdPartenaireAndDateCreationBetweenOrderByDateCreationDesc(IdPartenaire,DateDebut,DateFin);
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
            List<ActionMarketing> result = actionMarketingRepository.findActionMarketingByDateCreationBetweenOrderByDateCreationDesc(DateDebut,DateFin);
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
            List<ActionMarketing> result = actionMarketingRepository.findAllByIdPartenaireOrderByDateCreationDesc(IdPartenaire);
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
    public ResponseObject findAllByIdCanalDiffusion(String idCanal) {
        try {
            List<ActionMarketing> result = actionMarketingRepository.findAllByIdCanaldiffusionAndStatutGreaterThanOrderByDateCreationDesc(idCanal,0);
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



    public ActionMarketingDTO entityToOneDto(ActionMarketing actionMarketing){
        ActionMarketingDTO action=new ActionMarketingDTO();
        action.setIdActionMarketing(actionMarketing.getIdActionMarketing());
        action.setDateDebut(actionMarketing.getDateDebut());
        action.setDateFin(actionMarketing.getDateFin());
        action.setDateCreation(actionMarketing.getDateCreation());
        action.setStatut(actionMarketing.getStatut());

        PartenaireBprice partenaireBprice = (PartenaireBprice) partenaireBpriceService.findByIdPartenaire(actionMarketing.getIdPartenaire())
                .getObjectResponse();
            if(partenaireBprice!=null) {
                action.setNomPartenaire(partenaireBprice.getAbbreviation());
            }

        action.setDescription(actionMarketing.getDescription());
        action.setTitre(actionMarketing.getTitre());
        CanalDiffusion canal=iCanalDiffusionRepository.findById(actionMarketing.getIdCanaldiffusion()).orElse(null);
        action.setCanal(canal.getLibelle());
        if (actionMarketing.getIdStorage()!=null) {
            Storage storage = storageRepository.findByIdStorage(actionMarketing.getIdStorage());
            action.setUrl(storage.getUrl());

            action.setType(storage.getType());
        }
        if(actionMarketing.getSmsBody()!=null){
            action.setSmsBody(actionMarketing.getSmsBody());
        }
        action.setTypeitem(actionMarketing.getTypeContenue());
        action.setTypeitemsec(actionMarketing.getIdTypeAffichage());

        return action;
    }


    @Override
    public ResponseObject entityToDto(List<ActionMarketing> actionMarketings){
        return new ResponseObject(EnumMessage.LIST_ACTIONMARKETING_NOT_EMPTY.code, EnumMessage.LIST_ACTIONMARKETING_NOT_EMPTY.label,
                actionMarketings.stream().map(x -> entityToOneDto(x)).collect(Collectors.toList()));
    }

    @Override
    public ResponseObject findAllHistoriqueInteraction(String idActionMarketing) {
        try {
            if(idActionMarketing!=null) {
                ActionMarketing actionMarketing = (ActionMarketing) this.findByIdActionMarketing(idActionMarketing).getObjectResponse();
                if (actionMarketing != null) {
                    List<Historique> result = historiqueRepository.findAllByIdActionmarketing(idActionMarketing);
                    if (result.size() > 0) {
                        return new ResponseObject(EnumMessage.LIST_HISTORIQUEINTERACTION_NOT_EMPTY.code, EnumMessage.LIST_HISTORIQUEINTERACTION_NOT_EMPTY.label,
                                result);

                    } else {
                        return new ResponseObject(EnumMessage.LIST_ACTIONMARKETING_EMPTY.code, EnumMessage.LIST_ACTIONMARKETING_EMPTY.label, null);
                    }
                } else {
                    return new ResponseObject(EnumMessage.ACTIONMARKETING_EMPTY.code, EnumMessage.ACTIONMARKETING_EMPTY.label, null);

                }
            }else{
                return new ResponseObject(EnumMessage.ID_EMPTY.code, EnumMessage.ID_EMPTY.label, null);
            }
        }catch (Exception e){
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, e);

        }
    }

    public ResponseObject findAllActionMarketingDTOWithStatutBiggerThan(Integer statut){
        try {
            if(statut!=null){
                List<ActionMarketing> actionMarketings=actionMarketingRepository.findAllByStatutOrderByDateCreationDesc(statut);
                if(actionMarketings.size()>0){
                    return new ResponseObject(EnumMessage.LIST_PARTENAIREBPRICE_NOT_EMPTY.code, EnumMessage.LIST_PARTENAIREBPRICE_NOT_EMPTY.label, actionMarketings.stream().map(x -> entityToOneDto(x)).collect(Collectors.toList()));
                }else{
                    return new ResponseObject(EnumMessage.LIST_PARTENAIREBPRICES_EMPTY.code, EnumMessage.LIST_PARTENAIREBPRICES_EMPTY.label, null);
                }            }else{
                return new ResponseObject(EnumMessage.PARAMETRE_EMPTY.code, EnumMessage.PARAMETRE_EMPTY.label, null);

            }
        }catch (Exception e){
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, e);

        }


    }

    @Override
    public int countActionMarketingByNotificationEquals(int num) {

        return actionMarketingRepository.countActionMarketingByNotificationEquals(num);

    }

    @Override
    public int countActionMarketingByNotificationEqualsAndIdPartenaire(int num, String idpartenaire) {
        return actionMarketingRepository.countActionMarketingByNotificationEqualsAndIdPartenaire(num,idpartenaire);
    }


}
