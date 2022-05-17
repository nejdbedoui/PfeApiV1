package com.bprice.bpapipos.service.Impl;

import com.bprice.bpapipos.Enum.EnumMessage;
import com.bprice.bpapipos.dto.ActionMarketingDTO;
import com.bprice.bpapipos.repository.IActionMarketingRepository;
import com.bprice.bpapipos.repository.IContractActionRepository;
import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.bpapipos.service.IActionMarketingService;
import com.bprice.bpapipos.service.IContratActionService;
import com.bprice.bpapipos.service.IPartenaireBpriceService;
import com.bprice.persistance.model.ActionMarketing;
import com.bprice.persistance.model.Contrat;
import com.bprice.persistance.model.PartenaireBprice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ContractActionServiceImpl implements IContratActionService {

    @Autowired
    IActionMarketingService actionMarketingService;
    @Autowired
    IPartenaireBpriceService partenaireBpriceService;
    @Autowired
    IContractActionRepository contractActionRepository;
    @Autowired
    IActionMarketingRepository actionMarketingRepository;

    @Override
    public ResponseObject CreateActionContract(ActionMarketingDTO actionMarketingDTO) {

        if(contractActionRepository.findAllByIdActionMarketing(actionMarketingDTO.getIdActionMarketing()).size()==0) {

            if (actionMarketingDTO.getIdActionMarketing() != null) {
                ActionMarketing actionMarketing = (ActionMarketing) actionMarketingService.findByIdActionMarketing(actionMarketingDTO.getIdActionMarketing())
                        .getObjectResponse();
                if (actionMarketing != null) {
                    Contrat contrat = new Contrat();
                    contrat.setDateCreation(new Date());
                    contrat.setStatutContrat(0);
                    contrat.setDescriptionAction(actionMarketing.getDescription());
                    contrat.setDateDebut(actionMarketing.getDateDebut());
                    contrat.setDateFin(actionMarketing.getDateFin());
                    contrat.setIdPartenaire(actionMarketing.getIdPartenaire());
                    contrat.setIdActionMarketing(actionMarketing.getIdActionMarketing());
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(contrat.getDateCreation());
                    calendar.set(Calendar.HOUR_OF_DAY, 0);
                    calendar.set(Calendar.MINUTE, 0);
                    calendar.set(Calendar.SECOND, 0);
                    calendar.set(Calendar.MILLISECOND, 0);
                    int x = contractActionRepository.countAllByDateCreation(calendar.getTime()) + 1;
                    contrat.setNumeroContrat(Integer.toString(calendar.get(Calendar.YEAR)) + '-' + calendar.get(Calendar.MONTH) + '-' + calendar.get(Calendar.DAY_OF_MONTH) + "-c" + x);

                    Contrat result = contractActionRepository.save(contrat);
                    return new ResponseObject(EnumMessage.SUCCESS_CREATION.code,
                            EnumMessage.SUCCESS_CREATION.label, result);
                }
                return new ResponseObject(EnumMessage.ACTIONMARKETING_NOT_EXIST.code,
                        EnumMessage.ACTIONMARKETING_NOT_EXIST.label, null);
            } else {
                return new ResponseObject(EnumMessage.CONTRACT_EMPTY.code, EnumMessage.CONTRACT_EMPTY.label, null);

            }
        }
        else{
            return new ResponseObject(EnumMessage.CONTRACT_ALREADY_EXISTS.code, EnumMessage.CONTRACT_ALREADY_EXISTS.label, null);
        }
    }

    @Override
    public ResponseObject DeleteActionContract(String IdContract) {
        return null;
    }

    @Override
    public ResponseObject UpdateActionContract(Contrat contrat) {
        try {
            if (contrat != null) {
                if (contractActionRepository.existsById(contrat.getIdContrat())) {
                    if (contrat.getIdPartenaire() != null) {
                        PartenaireBprice partenaireBprice = (PartenaireBprice) partenaireBpriceService
                                .findByIdPartenaire(contrat.getIdPartenaire()).getObjectResponse();
                        if (partenaireBprice != null) {
                            System.out.println(contrat.getIdActionMarketing());
                            if (contrat.getIdActionMarketing()!=null){

                                ActionMarketing actionMarketing = (ActionMarketing) actionMarketingService.findByIdActionMarketing(contrat.getIdActionMarketing())
                                        .getObjectResponse();
                                if(actionMarketing!=null) {

                                    Contrat result = contractActionRepository.save(contrat);
                                    return new ResponseObject(EnumMessage.SUCCESS_UPDATE.code,
                                            EnumMessage.SUCCESS_UPDATE.label, result);
                                }
                                else {
                                    return new ResponseObject(EnumMessage.ACTIONMARKETING_NOT_EXIST.code,
                                            EnumMessage.ACTIONMARKETING_NOT_EXIST.label, null);
                                }
                            }
                            else {
                                return new ResponseObject(EnumMessage.ACTIONMARKETING_ID_EMPTY.code,
                                        EnumMessage.ACTIONMARKETING_ID_EMPTY.label, null);
                            }
                        } else {
                            return new ResponseObject(EnumMessage.PARTENAIREBPRICE_NOT_EXIST.code,
                                    EnumMessage.PARTENAIREBPRICE_NOT_EXIST.label, null);

                        }
                    } else {
                        return new ResponseObject(EnumMessage.PARTENAIREBPRICE_ID_EMPTY.code,
                                EnumMessage.PARTENAIREBPRICE_ID_EMPTY.label, null);
                    }
                } else {
                    return new ResponseObject(EnumMessage.CONTRACT_EMPTY.code, EnumMessage.CONTRACT_EMPTY.label,
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
    public ResponseObject findByIdActionContract(String IdContract) {
        return null;
    }

    @Override
    public ResponseObject findAllContract() {
        try {
            List<Contrat> result = contractActionRepository.findAll();
            if (result.size() >0) {
                return new ResponseObject(EnumMessage.LIST_CONTRACT_NOT_EMPTY.code, EnumMessage.LIST_ACTIONMARKETING_NOT_EMPTY.label,
                        result);
            } else {
                return new ResponseObject(EnumMessage.LIST_CONTRACT_EMPTY.code, EnumMessage.LIST_CONTRACT_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }    }

    @Override
    public ResponseObject findAllContratByIdPartenaire(String idPartenaire) {
        try {
            List<Contrat> result = contractActionRepository.findAllByIdPartenaire(idPartenaire);
            if (result.size() >0) {
                return new ResponseObject(EnumMessage.LIST_CONTRACT_NOT_EMPTY.code, EnumMessage.LIST_CONTRACT_NOT_EMPTY.label,
                        result);
            } else {
                return new ResponseObject(EnumMessage.LIST_CONTRACT_EMPTY.code, EnumMessage.LIST_CONTRACT_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }       }
}
