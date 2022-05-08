package com.bprice.bpapipos.service.Impl;

import com.bprice.bpapipos.Enum.EnumMessage;
import com.bprice.bpapipos.repository.IFormatAffichageRepository;
import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.bpapipos.service.IFormatAffichageService;

import com.bprice.persistance.model.CanalDiffusion;
import com.bprice.persistance.model.FormatAffichage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FormatAffichageServiceImpl implements IFormatAffichageService {
    @Autowired
    IFormatAffichageRepository iFormatAffichageRepository;




    @Override
    public ResponseObject createformat(FormatAffichage formatAffichage) {
        try {
            if (formatAffichage != null) {

                FormatAffichage result = iFormatAffichageRepository.save(formatAffichage);

                return new ResponseObject(EnumMessage.SUCCESS_CREATION.code,
                        EnumMessage.SUCCESS_CREATION.label, result);

            } else {
                return new ResponseObject(EnumMessage.FORMATAFFICHAGE_EMPTY.code, EnumMessage.FORMATAFFICHAGE_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, e.getMessage(), null);
        }
    }

    @Override
    public ResponseObject updateformat(FormatAffichage formatAffichage) {
        try {
            if (formatAffichage != null) {
                if (iFormatAffichageRepository.existsById(formatAffichage.getIdFormatAffichage())) {


                    FormatAffichage result = iFormatAffichageRepository.save(formatAffichage);
                    return new ResponseObject(EnumMessage.SUCCESS_UPDATE.code,
                            EnumMessage.SUCCESS_UPDATE.label, result);




                } else {
                    return new ResponseObject(EnumMessage.FORMATAFFICHAGE_NOT_EXIST.code, EnumMessage.FORMATAFFICHAGE_NOT_EXIST.label,
                            null);

                }

            } else {
                return new ResponseObject(EnumMessage.FORMATAFFICHAGE_EMPTY.code, EnumMessage.FORMATAFFICHAGE_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, e.getMessage(), null);
        }
    }

    @Override
    public ResponseObject deleteformat(String id) {
        try {
            if (id != null) {
                if (iFormatAffichageRepository.existsById(id)) {
                    iFormatAffichageRepository.deleteById(id);
                    return new ResponseObject(EnumMessage.SUCCESS_DELETE.code, EnumMessage.SUCCESS_DELETE.label, true);
                } else {
                    return new ResponseObject(EnumMessage.FORMATAFFICHAGE_EMPTY.code, EnumMessage.FORMATAFFICHAGE_EMPTY.label,
                            false);
                }
            } else {
                return new ResponseObject(EnumMessage.FORMATAFFICHAGE_ID_EMPTY.code, EnumMessage.FORMATAFFICHAGE_ID_EMPTY.label, false);

            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

    @Override
    public ResponseObject findAllformat() {
        try {
            List<FormatAffichage> result = iFormatAffichageRepository.findAll();
            if (result.size() >0) {
                return new ResponseObject(EnumMessage.LIST_FORMATAFFICHAGE_NOT_EMPTY.code, EnumMessage.LIST_FORMATAFFICHAGE_NOT_EMPTY.label,
                        result);
            } else {
                return new ResponseObject(EnumMessage.LIST_FORMATAFFICHAGE_EMPTY.code, EnumMessage.LIST_FORMATAFFICHAGE_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

    @Override
    public ResponseObject findAllActiveformat(String type) {
        try {
            List<FormatAffichage> result = iFormatAffichageRepository.findAllByTypeAndFActifEquals(type,1);
            if (result.size() >0) {
                return new ResponseObject(EnumMessage.LIST_FORMATAFFICHAGE_NOT_EMPTY.code, EnumMessage.LIST_FORMATAFFICHAGE_NOT_EMPTY.label,
                        result);
            } else {
                return new ResponseObject(EnumMessage.LIST_FORMATAFFICHAGE_EMPTY.code, EnumMessage.LIST_FORMATAFFICHAGE_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

}
