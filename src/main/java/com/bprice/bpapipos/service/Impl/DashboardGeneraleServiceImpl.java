package com.bprice.bpapipos.service.Impl;

import com.bprice.bpapipos.Enum.EnumMessage;
import com.bprice.bpapipos.dto.ActionEnCoursDeDiffusionDTO;
import com.bprice.bpapipos.dto.DemandeActionMarketingWithDetailActionDTO;
import com.bprice.bpapipos.dto.DemandeDiffusionDTO;
import com.bprice.bpapipos.repository.IDemandeActionMarketingRepository;
import com.bprice.bpapipos.repository.IParametreActionMarketingRepository;
import com.bprice.bpapipos.repository.IStorageRepository;
import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.bpapipos.service.*;
import com.bprice.persistance.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardGeneraleServiceImpl implements IDashboardGeneraleService {
    @Autowired
    ICanalDiffusionService canalDiffusionService;
    @Autowired
    IDemandeActionMarketingRepository demandeActionMarketingRepository;
    @Autowired
    IActionMarketingService actionMarketingService;
    @Autowired    IDemandeActionMarketingService demandeActionMarketingService;
    @Autowired
    IParametreActionMarketingService parametreActionMarketingService;
    @Autowired
    IParametreActionMarketingRepository parametreActionMarketingRepository;

    @Autowired
    IStorageRepository storageRepository;
    @Override
    public ResponseObject findAllDemandeDiffusionDTOByIdPartenaire(String idPartenaire) {
        try {
            List<ParametreActionMarketing> result = parametreActionMarketingRepository.findAllByIdPartenaireCibleAndStatut(idPartenaire,1);
            if (result.size() >0) {
                return new ResponseObject(EnumMessage.LIST_ACTIONMARKETING_NOT_EMPTY.code, EnumMessage.LIST_ACTIONMARKETING_NOT_EMPTY.label,
                        result.stream().map(this::demandeDiffusionDTO).collect(Collectors.toList()));
            } else {
                return new ResponseObject(EnumMessage.LIST_ACTIONMARKETING_EMPTY.code, EnumMessage.LIST_ACTIONMARKETING_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

    @Override
    public ResponseObject findAllActionEnCourDeDiffusionByIdPartenaire(String idPartenaire) {
        try {
            List<DemandeActionMarketing> result = demandeActionMarketingRepository.findAllByIdPartenaireAndStatutEqualsOrderByDateCreationDesc(idPartenaire,1);
            if (result.size() >0) {
                return new ResponseObject(EnumMessage.LIST_ACTIONMARKETING_NOT_EMPTY.code, EnumMessage.LIST_ACTIONMARKETING_NOT_EMPTY.label,
                        result.stream().map(this::actionEnCoursDeDiffusionDTO).collect(Collectors.toList()));
            } else {
                return new ResponseObject(EnumMessage.LIST_ACTIONMARKETING_EMPTY.code, EnumMessage.LIST_ACTIONMARKETING_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

    @Override
    public ResponseObject findTotalRevenueAndNombreDemandeEnCour(String idPartenaire) {
        try {
            List<ParametreActionMarketing> result = parametreActionMarketingRepository.findAllByIdPartenaireCible(idPartenaire);
            if (result.size() >0) {
                DetailDashboardTotalRevenueAndCountEnCour detailDashboardTotalRevenueAndCountEnCour = new DetailDashboardTotalRevenueAndCountEnCour();
                double price = 0;
                for (ParametreActionMarketing value : result) {
                    price += value.getPrix();

                }
                detailDashboardTotalRevenueAndCountEnCour.setTotalRevenueDesDemandes(price);
                detailDashboardTotalRevenueAndCountEnCour.setDemandeEncoursDeDiffusion(result.size());
                return new ResponseObject(EnumMessage.LIST_ACTIONMARKETING_NOT_EMPTY.code, EnumMessage.LIST_ACTIONMARKETING_NOT_EMPTY.label,
                        detailDashboardTotalRevenueAndCountEnCour);
            } else {
                return new ResponseObject(EnumMessage.LIST_ACTIONMARKETING_EMPTY.code, EnumMessage.LIST_ACTIONMARKETING_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

    public DemandeDiffusionDTO demandeDiffusionDTO(ParametreActionMarketing parametreActionMarketing){

        ActionMarketing actionMarketing = (ActionMarketing) actionMarketingService.findByIdActionMarketing(parametreActionMarketing.getIdActionMarketing())
                .getObjectResponse();
        System.out.println(parametreActionMarketing);

        DemandeDiffusionDTO demandeDiffusionDTO = new DemandeDiffusionDTO();
        demandeDiffusionDTO.setIdActionMarketing(parametreActionMarketing.getIdActionMarketing());
        demandeDiffusionDTO.setIdParametreActionMarketing(parametreActionMarketing.getIdParametreAction());
        CanalDiffusion canalDiffusion = (CanalDiffusion) canalDiffusionService.findByIdCanalDiffusion(actionMarketing.getIdCanaldiffusion())
                .getObjectResponse();
        demandeDiffusionDTO.setLibelleCanal(canalDiffusion.getLibelle());
        demandeDiffusionDTO.setPrix(parametreActionMarketing.getPrix());
        demandeDiffusionDTO.setTitre(actionMarketing.getTitre());
        if (actionMarketing.getIdStorage()!=null) {
            Storage storage = storageRepository.findByIdStorage(actionMarketing.getIdStorage());
            demandeDiffusionDTO.setUrl(storage.getUrl());

            demandeDiffusionDTO.setType(storage.getType());
        }




        return demandeDiffusionDTO;
    }


    public ActionEnCoursDeDiffusionDTO actionEnCoursDeDiffusionDTO(DemandeActionMarketing demandeActionMarketing){
        ActionEnCoursDeDiffusionDTO actionEnCoursDeDiffusionDTO = new ActionEnCoursDeDiffusionDTO();
        ActionMarketing actionMarketing = (ActionMarketing) actionMarketingService.findByIdActionMarketing(demandeActionMarketing.getIdActionMarketing())
                .getObjectResponse();
        CanalDiffusion canalDiffusion = (CanalDiffusion) canalDiffusionService.findByIdCanalDiffusion(actionMarketing.getIdCanaldiffusion())
                .getObjectResponse();

        actionEnCoursDeDiffusionDTO.setCanal(canalDiffusion.getLibelle());
        actionEnCoursDeDiffusionDTO.setTitre(actionMarketing.getTitre());
        actionEnCoursDeDiffusionDTO.setDatedebut(actionMarketing.getDateDebut());
        actionEnCoursDeDiffusionDTO.setDatefin(actionMarketing.getDateFin());
        actionEnCoursDeDiffusionDTO.setIdActionMarketing(demandeActionMarketing.getIdActionMarketing());
        actionEnCoursDeDiffusionDTO.setIdDemandeActionMarketing(demandeActionMarketing.getIdDemandeActionMarketing());



        return actionEnCoursDeDiffusionDTO;
    }

}
