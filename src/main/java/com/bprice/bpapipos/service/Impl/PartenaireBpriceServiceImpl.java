package com.bprice.bpapipos.service.Impl;


import com.bprice.bpapipos.Enum.EnumMessage;
import com.bprice.bpapipos.dto.ActionMarketingDTO;
import com.bprice.bpapipos.dto.PointeVentePartenaireDTO;
import com.bprice.bpapipos.repository.IPartenaireBpriceRepository;
import com.bprice.bpapipos.repository.IPointVenteRepository;
import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.bpapipos.service.IActionMarketingService;
import com.bprice.bpapipos.service.IParametreActionMarketingService;
import com.bprice.bpapipos.service.IPartenaireBpriceService;
import com.bprice.persistance.model.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ahmed on 18/01/2020.
 */
@Service
public class PartenaireBpriceServiceImpl implements IPartenaireBpriceService {

    @Autowired
    private IPartenaireBpriceRepository partenaireBpriceRepository;
    @Autowired
    IPointVenteRepository pointVenteRepository;

    @Autowired
    IParametreActionMarketingService parametreActionMarketingService;


    @Override
    public ResponseObject CreatePartenaireBprice(PartenaireBprice partenaireBprice) {
        try {
            if(partenaireBprice!=null){
                // if(chartGraphqiueRepository.existsById(partenaireBprice.getIdChart())){
                //     if(villeRepository.existsById(partenaireBprice.getIdVille())){
                        if(partenaireBprice.getMatriculeFiscale()!=null){
                            if(partenaireBpriceRepository.findByMatriculeFiscale(partenaireBprice.getMatriculeFiscale())==null){
                                PartenaireBprice result=partenaireBpriceRepository.save(partenaireBprice);
                                return new ResponseObject(EnumMessage.SUCCESS_CREATION.code, EnumMessage.SUCCESS_CREATION.label, result);
                            }else{
                                return new ResponseObject(EnumMessage.MATRICULE_EXIST.code, EnumMessage.MATRICULE_EXIST.label, null);
                            }
                        }else{
                            return new ResponseObject(EnumMessage.MATRICULE_EMPTY.code, EnumMessage.MATRICULE_EMPTY.label, null);
                        }
                //     }else{
                //         return new ResponseObject(EnumMessage.VILLE_NOT_EXIST.code, EnumMessage.VILLE_NOT_EXIST.label, null);
                //     }
                // }else{
                //     return new ResponseObject(EnumMessage.CHART_NOT_EXIST.code, EnumMessage.CHART_NOT_EXIST.label, null);
                // }
            }else{
                return new ResponseObject(EnumMessage.PARTENAIREBPRICE_EMPTY.code, EnumMessage.PARTENAIREBPRICE_EMPTY.label, null);

            }
        }catch (Exception e){
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

    @Override
    public ResponseObject CreateManyPartenaireBprice(List<PartenaireBprice> partenaireBprices) {
        try {
            if(partenaireBprices!=null){
                List<PartenaireBprice>  result=partenaireBpriceRepository.saveAll(partenaireBprices);
                return new ResponseObject(EnumMessage.SUCCESS_CREATION.code, EnumMessage.SUCCESS_CREATION.label, result);

            }else{
                return new ResponseObject(EnumMessage.LIST_PARTENAIREBPRICES_EMPTY.code, EnumMessage.LIST_PARTENAIREBPRICES_EMPTY.label, null);

            }
        }catch (Exception e){
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }



    @Override
    public ResponseObject DeletePartenaireBprice(String idPartenaire) {
        try {
            if(idPartenaire!=null){
                if(partenaireBpriceRepository.existsById(idPartenaire)){
                    partenaireBpriceRepository.deleteById(idPartenaire);
                    return new ResponseObject(EnumMessage.SUCCESS_DELETE.code, EnumMessage.SUCCESS_DELETE.label, true);
                }else{
                    return new ResponseObject(EnumMessage.PARTENAIREBPRICE_NOT_EXIST.code, EnumMessage.PARTENAIREBPRICE_NOT_EXIST.label, false);
                }
            }else{
                return new ResponseObject(EnumMessage.ID_EMPTY.code, EnumMessage.ID_EMPTY.label, false);

            }
        }catch (Exception e){
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

    @Override
    public ResponseObject findByIdPartenaire(String idPartenaire) {
        try {
            if(idPartenaire!=null){
                PartenaireBprice partenaireBprice=partenaireBpriceRepository.findByIdPartenaire(idPartenaire);
                if(partenaireBprice!=null){
                    return new ResponseObject(EnumMessage.PARTENAIREBPRICE_EXIST.code, EnumMessage.PARTENAIREBPRICE_EXIST.label, partenaireBprice);
                }else{
                    return new ResponseObject(EnumMessage.PARTENAIREBPRICE_NOT_EXIST.code, EnumMessage.PARTENAIREBPRICE_NOT_EXIST.label, null);
                }
            }else{
                return new ResponseObject(EnumMessage.ID_EMPTY.code, EnumMessage.ID_EMPTY.label, null);

            }
        }catch (Exception e){
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

    @Override
    public ResponseObject findAllByFActif(Short factif) {
        try {
            if(factif!=null){
                    List<PartenaireBprice> partenaireBprices=partenaireBpriceRepository.findAllByFActif(factif);
                    if(partenaireBprices.size()>0){
                        return new ResponseObject(EnumMessage.LIST_PARTENAIREBPRICE_NOT_EMPTY.code, EnumMessage.LIST_PARTENAIREBPRICE_NOT_EMPTY.label, partenaireBprices);
                    }else{
                        return new ResponseObject(EnumMessage.LIST_PARTENAIREBPRICES_EMPTY.code, EnumMessage.LIST_PARTENAIREBPRICES_EMPTY.label, null);
                    }
            }else{
                return new ResponseObject(EnumMessage.PARAMETRE_EMPTY.code, EnumMessage.PARAMETRE_EMPTY.label, null);

            }
        }catch (Exception e){
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

//    @Override
//    public ResponseObject findAllByIdSector(String idSector) {
//        try {
//            if(idSector!=null){
//                List<PartenaireBprice> partenaireBprices=partenaireBpriceRepository.findAllByIdSector(idSector);
//                if(partenaireBprices.size()>0){
//                    return new ResponseObject(EnumMessage.LIST_PARTENAIREBPRICE_NOT_EMPTY.code, EnumMessage.LIST_PARTENAIREBPRICE_NOT_EMPTY.label, partenaireBprices);
//                }else{
//                    return new ResponseObject(EnumMessage.LIST_PARTENAIREBPRICES_EMPTY.code, EnumMessage.LIST_PARTENAIREBPRICES_EMPTY.label, null);
//                }            }else{
//                return new ResponseObject(EnumMessage.PARAMETRE_EMPTY.code, EnumMessage.PARAMETRE_EMPTY.label, null);
//
//            }
//        }catch (Exception e){
//            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);
//
//        }
//    }

    @Override
    public ResponseObject findAllByIdVille(String idVille) {
        try {
            if(idVille!=null){
                List<PartenaireBprice> partenaireBprices=partenaireBpriceRepository.findAllByIdVille(idVille);
                if(partenaireBprices.size()>0){
                    return new ResponseObject(EnumMessage.LIST_PARTENAIREBPRICE_NOT_EMPTY.code, EnumMessage.LIST_PARTENAIREBPRICE_NOT_EMPTY.label, partenaireBprices);
                }else{
                    return new ResponseObject(EnumMessage.LIST_PARTENAIREBPRICES_EMPTY.code, EnumMessage.LIST_PARTENAIREBPRICES_EMPTY.label, null);
                }            }else{
                return new ResponseObject(EnumMessage.PARAMETRE_EMPTY.code, EnumMessage.PARAMETRE_EMPTY.label, null);

            }
        }catch (Exception e){
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

//    @Override
//    public ResponseObject findAllByIdSectorAndFActif(String idSector, Short factif) {
//        try {
//            if(idSector!=null && factif!=null){
//                List<PartenaireBprice> partenaireBprices=partenaireBpriceRepository.findAllByIdSectorAndFActif(idSector,factif);
//                if(partenaireBprices.size()>0){
//                    return new ResponseObject(EnumMessage.LIST_PARTENAIREBPRICE_NOT_EMPTY.code, EnumMessage.LIST_PARTENAIREBPRICE_NOT_EMPTY.label, partenaireBprices);
//                }else{
//                    return new ResponseObject(EnumMessage.LIST_PARTENAIREBPRICES_EMPTY.code, EnumMessage.LIST_PARTENAIREBPRICES_EMPTY.label, null);
//                }            }else{
//                return new ResponseObject(EnumMessage.PARAMETRE_EMPTY.code, EnumMessage.PARAMETRE_EMPTY.label, null);
//
//            }
//        }catch (Exception e){
//            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);
//
//        }
//    }

    @Override
    public ResponseObject findAllByIdVilleAndFActif(String idVille, Short factif) {
        try {
            if(idVille!=null && factif!=null){
                List<PartenaireBprice> partenaireBprices=partenaireBpriceRepository.findAllByIdVilleAndFActif(idVille,factif);
                if(partenaireBprices.size()>0){
                    return new ResponseObject(EnumMessage.LIST_PARTENAIREBPRICE_NOT_EMPTY.code, EnumMessage.LIST_PARTENAIREBPRICE_NOT_EMPTY.label, partenaireBprices);
                }else{
                    return new ResponseObject(EnumMessage.LIST_PARTENAIREBPRICES_EMPTY.code, EnumMessage.LIST_PARTENAIREBPRICES_EMPTY.label, null);
                }            }else{
                return new ResponseObject(EnumMessage.PARAMETRE_EMPTY.code, EnumMessage.PARAMETRE_EMPTY.label, null);

            }
        }catch (Exception e){
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }



    public PointeVentePartenaireDTO entityToDto( PartenaireBprice partenaireBprice,String idActionMarketing){

PointeVentePartenaireDTO pointeVentePartenaireDTO = new PointeVentePartenaireDTO();
        pointeVentePartenaireDTO.setIdPartenaire(partenaireBprice.getIdPartenaire());
        pointeVentePartenaireDTO.setAbbreviation(partenaireBprice.getAbbreviation());
        pointeVentePartenaireDTO.setAdresse(partenaireBprice.getAdresse());
        if(partenaireBprice.getnTel()!=null){
            pointeVentePartenaireDTO.setnTel(partenaireBprice.getnTel());
        }


     List<PointVente> listePointVente = pointVenteRepository.findAllByIdPartenaireAndFActifAndTypePv(partenaireBprice.getIdPartenaire(),(short) 1,"pointVente");

     if(listePointVente.size()>0){
         pointeVentePartenaireDTO.setListePointVente(listePointVente);
     }
     pointeVentePartenaireDTO.setIdSecteur(partenaireBprice.getIdPartenaire());

     ParametreActionMarketing parametreActionMarketing = (ParametreActionMarketing) parametreActionMarketingService.findByIdActionMarketingAndIdPartenaireCible(idActionMarketing,partenaireBprice.getIdPartenaire())
             .getObjectResponse();


     if(parametreActionMarketing!=null){
         pointeVentePartenaireDTO.setStatut(parametreActionMarketing.getStatut());
         pointeVentePartenaireDTO.setPrix(parametreActionMarketing.getPrix());
     }else {
         pointeVentePartenaireDTO.setStatut(0);
     }





            return pointeVentePartenaireDTO;

    }

    @Autowired
    IActionMarketingService actionMarketingService;

    @Override
    public ResponseObject entityToDto(String idActionMarketing,short fActif) {
        try {
            if(idActionMarketing!=null){
                ActionMarketing actionMarketing = (ActionMarketing) actionMarketingService.findByIdActionMarketing(idActionMarketing)
                        .getObjectResponse();
                if(actionMarketing!=null) {
                    PartenaireBprice partenaireBprice = (PartenaireBprice) this.findByIdPartenaire(actionMarketing.getIdPartenaire()).getObjectResponse();
                    if (partenaireBprice != null) {
                        List<PartenaireBprice> partenaireBprices = partenaireBpriceRepository.findAllByFActifAndIdSectorIsNotAndIdPartenaireIsNot(fActif, partenaireBprice.getIdSector(), actionMarketing.getIdPartenaire());
                        if (partenaireBprices.size() > 0) {
                            return new ResponseObject(EnumMessage.LIST_PARTENAIREBPRICE_NOT_EMPTY.code, EnumMessage.LIST_PARTENAIREBPRICE_NOT_EMPTY.label, partenaireBprices.stream().map(x -> entityToDto(x,idActionMarketing)).collect(Collectors.toList()));
                        } else {
                            return new ResponseObject(EnumMessage.PARTENAIREBPRICE_NOT_EXIST.code, EnumMessage.PARTENAIREBPRICE_NOT_EXIST.label, null);
                        }
                    } else {
                        return new ResponseObject(EnumMessage.LIST_PARTENAIREBPRICES_EMPTY.code, EnumMessage.LIST_PARTENAIREBPRICES_EMPTY.label, null);
                    }
                }
                else{
                    return new ResponseObject(EnumMessage.ACTIONMARKETING_NOT_EXIST.code, EnumMessage.ACTIONMARKETING_NOT_EXIST.label, null);
                }
            }else{
                return new ResponseObject(EnumMessage.ID_EMPTY.code, EnumMessage.ID_EMPTY.label, null);

            }
        }catch (Exception e){
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }



    }

}
