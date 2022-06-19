package com.bprice.bpapipos.service.Impl;

import com.bprice.bpapipos.Enum.EnumMessage;
import com.bprice.bpapipos.dto.ActionMarketingDTO;
import com.bprice.bpapipos.dto.DetailsActionDTO;
import com.bprice.bpapipos.repository.*;
import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.bpapipos.service.IDetailsActionDTOService;
import com.bprice.persistance.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class IDetailsActionDTOServiceImpl implements IDetailsActionDTOService {
    @Autowired
    IFormatAffichageRepository iFormatAffichageRepository;
    @Autowired
    IActionMarketingRepository actionMarketingRepository;
    @Autowired
    IStorageRepository storageRepository;
    @Autowired
    IVilleRepository iVillepRepository;
    @Autowired
    IPopulationCibleRepository populationCibleRepository;
    @Autowired
    ICategorieRepository categorieRepository;
    @Autowired
    ICanalDiffusionRepository canalDiffusionRepository;



    @Override
    public ResponseObject findDetailsByAction(ActionMarketing actionMarketing) {
        try {
            DetailsActionDTO details=new DetailsActionDTO();
            Categorie categorie=categorieRepository.findById(actionMarketing.getIdCategorie()).orElse(null);
            CanalDiffusion canalDiffusion=canalDiffusionRepository.findById(actionMarketing.getIdCanaldiffusion()).orElse(null);
            PopulationCible populationCible=populationCibleRepository.findById(actionMarketing.getIdPopulationCible()).orElse(null);
            if(categorie !=null)
            details.setSector(categorie.getDesignation());
            if(canalDiffusion !=null )
            details.setCanaldifusion(canalDiffusion.getLibelle());

            if(populationCible != null){
                details.setAgeMin(populationCible.getAgeMin());
                details.setAgeMax(populationCible.getAgeMax());
                details.setSexe(populationCible.getSexe());
            }


            if(actionMarketing.getSecteurcible().size()>0){
                List<String> listesecteur = new ArrayList<>();
                for (int i = 0; i < actionMarketing.getSecteurcible().size(); i++) {
                    listesecteur.add(categorieRepository.findById(actionMarketing.getSecteurcible().get(i)).orElse(null).getDesignation());
                }
                if(listesecteur.size()>0){
                    details.setSecteurCible(listesecteur);
                }
            }

            List<String> ville = new ArrayList<>();
            for (int i = 0; i < populationCible.getVille().size(); i++) {
                ville.add(iVillepRepository.findById(populationCible.getVille().get(i)).orElse(null).getLibelle());
            }
            details.setVille(ville);
            if (actionMarketing.getIdStorage()!=null) {
                Storage storage = storageRepository.findByIdStorage(actionMarketing.getIdStorage());
                FormatAffichage formatAffichage = iFormatAffichageRepository.findById(actionMarketing.getIdFormatAffichage()).orElse(null);
                details.setUrlmedia(storage.getUrl());
                details.setNamefile(storage.getName());
                details.setTypefile(actionMarketing.getTypeContenue());
                details.setFormataffichage(formatAffichage.getLibelle());
            }

            return new ResponseObject(EnumMessage.DETAILS_NOT_EMPTY.code, EnumMessage.DETAILS_NOT_EMPTY.label, details);

        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, e.getMessage(), null);
        }
    }
}
