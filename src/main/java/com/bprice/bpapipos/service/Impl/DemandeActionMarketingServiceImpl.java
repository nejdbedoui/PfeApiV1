package com.bprice.bpapipos.service.Impl;

import com.bprice.bpapipos.Enum.EnumMessage;
import com.bprice.bpapipos.dto.ActionMarketingDTO;
import com.bprice.bpapipos.dto.DemandeActionMarketingWithDetailActionDTO;
import com.bprice.bpapipos.repository.IActionMarketingRepository;
import com.bprice.bpapipos.repository.IDemandeActionMarketingRepository;
import com.bprice.bpapipos.repository.IPartenaireBpriceRepository;
import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.bpapipos.service.IActionMarketingService;
import com.bprice.bpapipos.service.IDemandeActionMarketingService;
import com.bprice.bpapipos.service.IPartenaireBpriceService;
import com.bprice.persistance.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemandeActionMarketingServiceImpl implements IDemandeActionMarketingService {

    @Autowired
    IPartenaireBpriceService partenaireBpriceService;
    @Autowired
    IPartenaireBpriceRepository partenaireBpriceRepository;
    @Autowired
    IActionMarketingRepository actionMarketingRepository;
    @Autowired
    IDemandeActionMarketingRepository demandeActionMarketingRepository;
    @Autowired
    IActionMarketingService actionMarketingService;
    @Override
    public ResponseObject CreateActionMarketing(DemandeActionMarketing demandeActionMarketing) {
        return null;
    }

    @Override
    public ResponseObject DeleteDemandeActionMarketing(String idDemande) {
        try {
            if (idDemande != null) {
                if (demandeActionMarketingRepository.existsById(idDemande)) {
                    DemandeActionMarketing demandeActionMarketing = (DemandeActionMarketing) this.findByIdDemandeActionMarketing(idDemande).getObjectResponse();
                    actionMarketingRepository.deleteById(demandeActionMarketing.getIdActionMarketing());
                    demandeActionMarketingRepository.deleteById(idDemande);

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
    public ResponseObject UpdateDemandeActionMarketing(DemandeActionMarketing demandeActionMarketing) {
        try {
            if (demandeActionMarketing != null) {
                if (demandeActionMarketingRepository.existsById(demandeActionMarketing.getIdDemandeActionMarketing())) {
                    if (demandeActionMarketing.getIdPartenaire() != null) {
                        PartenaireBprice partenaireBprice = (PartenaireBprice) partenaireBpriceService
                                .findByIdPartenaire(demandeActionMarketing.getIdPartenaire()).getObjectResponse();
                        if (partenaireBprice != null) {
                            ActionMarketing actionMarketing = (ActionMarketing) actionMarketingService
                                    .findByIdActionMarketing(demandeActionMarketing.getIdActionMarketing()).getObjectResponse();
                            if(actionMarketing!=null) {
                                DemandeActionMarketing result = demandeActionMarketingRepository.save(demandeActionMarketing);
                                return new ResponseObject(EnumMessage.SUCCESS_UPDATE.code,
                                        EnumMessage.SUCCESS_UPDATE.label, result);
                            }else{
                                return new ResponseObject(EnumMessage.ACTIONMARKETING_NOT_EXIST.code,
                                        EnumMessage.ACTIONMARKETING_NOT_EXIST.label, null);
                            }


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
    public ResponseObject findByIdDemandeActionMarketing(String idDemande) {
        try {
            if (idDemande != null) {
                DemandeActionMarketing result = demandeActionMarketingRepository.findDemandeActionMarketingByIdDemandeActionMarketing(idDemande);
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
            List<DemandeActionMarketing> result = demandeActionMarketingRepository.findAllDemandeActionMarketingByIdPartenaireAndDateCreationBetweenOrderByDateCreationDesc(IdPartenaire,DateDebut,DateFin);
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
            List<DemandeActionMarketing> result = demandeActionMarketingRepository.findDemandeActionMarketingByDateCreationBetweenOrderByDateCreationDesc(DateDebut,DateFin);
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
            List<DemandeActionMarketing> result = demandeActionMarketingRepository.findAllByIdPartenaireOrderByDateCreationDesc(IdPartenaire);
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
            List<DemandeActionMarketing> result = demandeActionMarketingRepository.findAll();
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
    public ResponseObject findAllDemandeActionMarketingDTOWithStatutBiggerThan(Integer statut) {
        return null;
    }

    public DemandeActionMarketingWithDetailActionDTO entityToOneDto(DemandeActionMarketing demandeActionMarketing){
        DemandeActionMarketingWithDetailActionDTO demandeActionMarketingdDTO=new DemandeActionMarketingWithDetailActionDTO();
        ActionMarketing actionMarketing = (ActionMarketing) actionMarketingService.findByIdActionMarketing(demandeActionMarketing.getIdActionMarketing())
                        .getObjectResponse();
        demandeActionMarketingdDTO.setIdActionMarketing(actionMarketing.getIdActionMarketing());
        demandeActionMarketingdDTO.setIdDemandeActionMarketing(demandeActionMarketing.getIdDemandeActionMarketing());
        demandeActionMarketingdDTO.setStatut(demandeActionMarketing.getStatut());
        demandeActionMarketingdDTO.setCanal(actionMarketing.getIdCanaldiffusion());
        demandeActionMarketingdDTO.setDateCreation(demandeActionMarketing.getDateCreation());
        if(actionMarketing.getIdTypeAffichage()!=null) {
            demandeActionMarketingdDTO.setIdTypeAffichage(actionMarketing.getIdTypeAffichage());
        }


        return demandeActionMarketingdDTO;
    }

@Override
    public ResponseObject entityToDto(List<DemandeActionMarketing> demandeActionMarketings){
        return new ResponseObject(EnumMessage.LIST_ACTIONMARKETING_NOT_EMPTY.code, EnumMessage.LIST_ACTIONMARKETING_NOT_EMPTY.label,
                demandeActionMarketings.stream().map(x -> entityToOneDto(x)).collect(Collectors.toList()));
    }
}
