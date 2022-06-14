package com.bprice.bpapipos.service.Impl;

import com.bprice.bpapipos.Enum.EnumMessage;
import com.bprice.bpapipos.repository.ICanalDiffusionRepository;
import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.bpapipos.service.ICanalDiffusionService;
import com.bprice.persistance.model.ActionMarketing;
import com.bprice.persistance.model.CanalDiffusion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CanalDiffusionServiceImpl implements ICanalDiffusionService {
    @Autowired
    ICanalDiffusionRepository canalDiffusionRepository;


    @Override
    public ResponseObject createCanal(CanalDiffusion canalDiffusion) {
        try {
            if (canalDiffusion != null) {

                CanalDiffusion result = canalDiffusionRepository.save(canalDiffusion);

                return new ResponseObject(EnumMessage.SUCCESS_CREATION.code,
                        EnumMessage.SUCCESS_CREATION.label, result);

            } else {
                return new ResponseObject(EnumMessage.CANALEDIFFUSION_EMPTY.code, EnumMessage.CANALEDIFFUSION_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, e.getMessage(), null);
        }
    }

    @Override
    public ResponseObject updateCanal(CanalDiffusion canalDiffusion) {
        try {
            if (canalDiffusion != null) {
                if (canalDiffusionRepository.existsById(canalDiffusion.getIdCanaldiffusion())) {


                    CanalDiffusion result = canalDiffusionRepository.save(canalDiffusion);
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
    public ResponseObject deleteCanal(String id) {
        try {
            if (id != null) {
                if (canalDiffusionRepository.existsById(id)) {
                    canalDiffusionRepository.deleteById(id);
                    return new ResponseObject(EnumMessage.SUCCESS_DELETE.code, EnumMessage.SUCCESS_DELETE.label, true);
                } else {
                    return new ResponseObject(EnumMessage.CANALEDIFFUSION_EMPTY.code, EnumMessage.CANALEDIFFUSION_EMPTY.label,
                            false);
                }
            } else {
                return new ResponseObject(EnumMessage.CANALEDIFFUSION_ID_EMPTY.code, EnumMessage.CANALEDIFFUSION_ID_EMPTY.label, false);

            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }



    @Override
    public ResponseObject findAllCanal() {

        try {
            List<CanalDiffusion> result = canalDiffusionRepository.findAll();
            if (result.size() >0) {
                return new ResponseObject(EnumMessage.LIST_CANALEDIFFUSION_NOT_EMPTY.code, EnumMessage.LIST_CANALEDIFFUSION_NOT_EMPTY.label,
                        result);
            } else {
                return new ResponseObject(EnumMessage.LIST_CANALEDIFFUSION_EMPTY.code, EnumMessage.LIST_CANALEDIFFUSION_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

    @Override
    public ResponseObject findAllActiveCanal() {
        try {
            List<CanalDiffusion> result = canalDiffusionRepository.findAllByFActifEquals(1);
            if (result.size() >0) {
                return new ResponseObject(EnumMessage.LIST_CANALEDIFFUSION_NOT_EMPTY.code, EnumMessage.LIST_CANALEDIFFUSION_NOT_EMPTY.label,
                        result);
            } else {
                return new ResponseObject(EnumMessage.LIST_CANALEDIFFUSION_EMPTY.code, EnumMessage.LIST_CANALEDIFFUSION_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

    @Override
    public ResponseObject findCanalBylibelle(String libelle) {
        try {
            CanalDiffusion result = canalDiffusionRepository.findCanalDiffusionByLibelle(libelle);
            if (result!=null) {
                return new ResponseObject(EnumMessage.LIST_CANALEDIFFUSION_NOT_EMPTY.code, EnumMessage.LIST_CANALEDIFFUSION_NOT_EMPTY.label,
                        result);
            } else {
                return new ResponseObject(EnumMessage.LIST_CANALEDIFFUSION_EMPTY.code, EnumMessage.LIST_CANALEDIFFUSION_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

    @Override
    public ResponseObject findByIdCanalDiffusion(String idCanal) {
        try {
            if (idCanal != null) {
                CanalDiffusion result = canalDiffusionRepository.findCanalDiffusionByIdCanaldiffusion(idCanal);
                if (result != null) {
                    return new ResponseObject(EnumMessage.CANALEDIFFUSION_EXIST.code, EnumMessage.CANALEDIFFUSION_EXIST.label, result);
                } else {
                    return new ResponseObject(EnumMessage.CANALEDIFFUSION_NOT_EXIST.code, EnumMessage.CANALEDIFFUSION_NOT_EXIST.label,
                            null);
                }
            } else {
                return new ResponseObject(EnumMessage.ID_EMPTY.code, EnumMessage.ID_EMPTY.label, null);

            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }
}
