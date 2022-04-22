package com.bprice.bpapipos.service.Impl;

import com.bprice.bpapipos.Enum.EnumMessage;
import com.bprice.bpapipos.repository.IModeReglementRepository;
import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.bpapipos.service.IModeReglementService;
import com.bprice.bpapipos.service.IPointVenteService;
import com.bprice.persistance.model.ModeReglement;
import com.bprice.persistance.model.PointVente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ahmed on 06/02/2020.
 */
@Service
public class ModeReglementServiceImpl implements IModeReglementService {

    @Autowired
    private IModeReglementRepository modeReglementRepository;

    @Autowired
    private IPointVenteService pointVenteService;
    @Override
    public ResponseObject CreateModeReglement(ModeReglement modeReglement) {
        try {
            if(modeReglement!=null){

                        if(modeReglement.getCode()!=null){
                            ModeReglement modeReglement1=modeReglementRepository.findAllByCodeAndIdPointVente(modeReglement.getCode(),modeReglement.getIdPointVente());
                            if(modeReglement1==null){
                                ModeReglement result=modeReglementRepository.save(modeReglement);
                                return new ResponseObject(EnumMessage.SUCCESS_CREATION.code, EnumMessage.SUCCESS_CREATION.label, result);
                            }else{
                                return new ResponseObject(EnumMessage.CODE_EXIST.code, EnumMessage.CODE_EXIST.label, null);

                            }

                        }else{
                            return new ResponseObject(EnumMessage.CODE_EMPTY.code, EnumMessage.POINTVENTE_NOT_EXIST_FOR_JOURNEE.label, null);

                        }




            }else{
                return new ResponseObject(EnumMessage.DEVISE_EMPTY.code, EnumMessage.DEVISE_EMPTY.label, null);

            }
        }catch (Exception e){
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, e.getMessage(), null);

        }
    }

    @Override
    public ResponseObject DeleteModeReglement(String idModeReglement) {
        try {
            if(idModeReglement!=null){
                if(modeReglementRepository.existsById(idModeReglement)){
                    modeReglementRepository.deleteById(idModeReglement);
                    return new ResponseObject(EnumMessage.SUCCESS_DELETE.code, EnumMessage.SUCCESS_DELETE.label, true);
                }else{
                    return new ResponseObject(EnumMessage.MODEREGELEMNT_NOT_EXIST.code, EnumMessage.MODEREGELEMNT_NOT_EXIST.label, false);
                }
            }else{
                return new ResponseObject(EnumMessage.ID_EMPTY.code, EnumMessage.ID_EMPTY.label, false);

            }
        }catch (Exception e){
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

    @Override
    public ResponseObject UpdateModeReglement(ModeReglement modeReglement) {
        try {
            if(modeReglement!=null){
                if(modeReglementRepository.existsById(modeReglement.getIdModeReglement())){

                            if(modeReglement.getCode()!=null){
                                ModeReglement modeReglement1=modeReglementRepository.findAllByCode(modeReglement.getCode());
                                if(modeReglement1==null || modeReglement1.getIdModeReglement().equals(modeReglement.getIdModeReglement()) ){
                                    ModeReglement result=modeReglementRepository.save(modeReglement);
                                    return new ResponseObject(EnumMessage.SUCCESS_UPDATE.code, EnumMessage.SUCCESS_UPDATE.label, result);
                                }else if(modeReglement1.getIdModeReglement().equals(modeReglement.getIdModeReglement())){
                                    ModeReglement result=modeReglementRepository.save(modeReglement);
                                    return new ResponseObject(EnumMessage.SUCCESS_UPDATE.code, EnumMessage.SUCCESS_UPDATE.label, result);
                                }else{
                                    return new ResponseObject(EnumMessage.CODE_EXIST.code, EnumMessage.CODE_EXIST.label, null);
                                }
                            }else{
                                return new ResponseObject(EnumMessage.CODE_EMPTY.code, EnumMessage.POINTVENTE_NOT_EXIST_FOR_JOURNEE.label, null);
                            }

                }else{
                    return new ResponseObject(EnumMessage.DEVISE_NOT_EXIST.code, EnumMessage.DEVISE_NOT_EXIST.label, null);
                }
            }else{
                return new ResponseObject(EnumMessage.DEVISE_EMPTY.code, EnumMessage.DEVISE_EMPTY.label, null);
            }
        }catch (Exception e){
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, e.getMessage(), null);
        }
    }

    @Override
    public ResponseObject findByIdModeReglement(String idModeReglement) {
        try {
            if(idModeReglement!=null){
                ModeReglement result=modeReglementRepository.findByIdModeReglement(idModeReglement);
                if(result!=null){
                    return new ResponseObject(EnumMessage.MODEREGELEMNT_EXIST.code, EnumMessage.MODEREGELEMNT_EXIST.label, result);
                }else{
                    return new ResponseObject(EnumMessage.MODEREGELEMNT_NOT_EXIST.code, EnumMessage.MODEREGELEMNT_NOT_EXIST.label, null);
                }
            }else{
                return new ResponseObject(EnumMessage.ID_EMPTY.code, EnumMessage.ID_EMPTY.label, null);

            }
        }catch (Exception e){
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

    @Override
    public ResponseObject findAllByIdPointVente(String idpointvente) {
        try {
            if(idpointvente!=null){
                List<ModeReglement>  result=modeReglementRepository.findAllByIdPointVente(idpointvente);
                if(result.size()>0){
                    return new ResponseObject(EnumMessage.LIST_MODEREGELEMNT_NOT_EMPTY.code, EnumMessage.LIST_MODEREGELEMNT_NOT_EMPTY.label, result);
                }else{
                    return new ResponseObject(EnumMessage.LIST_MODEREGELEMNT_EMPTY.code, EnumMessage.LIST_MODEREGELEMNT_EMPTY.label, null);
                }
            }else{
                List<ModeReglement>  result=modeReglementRepository.findAllByIdPointVenteIsNull();
                if(result.size()>0){
                    return new ResponseObject(EnumMessage.LIST_MODEREGELEMNT_NOT_EMPTY.code, EnumMessage.LIST_MODEREGELEMNT_NOT_EMPTY.label, result);
                }else{
                    return new ResponseObject(EnumMessage.LIST_MODEREGELEMNT_EMPTY.code, EnumMessage.LIST_MODEREGELEMNT_EMPTY.label, null);
                }
            }
        }catch (Exception e){
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

    @Override
    public ResponseObject findAll() {
        try {
            List<ModeReglement> result=modeReglementRepository.findAll();
            if(result.size()>0){
                return new ResponseObject(EnumMessage.LIST_MODEREGELEMNT_NOT_EMPTY.code, EnumMessage.LIST_MODEREGELEMNT_NOT_EMPTY.label, result);
            }else{
                return new ResponseObject(EnumMessage.LIST_MODEREGELEMNT_EMPTY.code, EnumMessage.LIST_MODEREGELEMNT_EMPTY.label, null);
            }
        }catch (Exception e){
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);
        }
    }
}
