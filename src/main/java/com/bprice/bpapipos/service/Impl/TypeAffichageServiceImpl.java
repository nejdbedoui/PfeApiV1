package com.bprice.bpapipos.service.Impl;

import com.bprice.bpapipos.Enum.EnumMessage;
import com.bprice.bpapipos.repository.ITypeAffichageRepository;
import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.bpapipos.service.ITypeAffichageService;
import com.bprice.persistance.model.TypeAffichage;
import com.bprice.persistance.model.TypeAffichage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeAffichageServiceImpl implements ITypeAffichageService {
    @Autowired
    ITypeAffichageRepository typeAffichageRepository;
    @Override
    public ResponseObject findAllTypeAffichage() {
        try {
            List<TypeAffichage> result = typeAffichageRepository.findAll();
            if (result.size() >0) {
                return new ResponseObject(EnumMessage.LIST_TYPEAFFICHAGE_NOT_EMPTY.code, EnumMessage.LIST_TYPEAFFICHAGE_NOT_EMPTY.label,
                        result);
            } else {
                return new ResponseObject(EnumMessage.LIST_TYPEAFFICHAGE_EMPTY.code, EnumMessage.LIST_TYPEAFFICHAGE_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }    }

    @Override
    public ResponseObject createTypeAffichage(TypeAffichage typeAffichage) {
        try {
            if (typeAffichage != null) {

                TypeAffichage result = typeAffichageRepository.save(typeAffichage);

                return new ResponseObject(EnumMessage.SUCCESS_CREATION.code,
                        EnumMessage.SUCCESS_CREATION.label, result);

            } else {
                return new ResponseObject(EnumMessage.TYPEAFFICHAGE_EMPTY.code, EnumMessage.TYPEAFFICHAGE_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, e.getMessage(), null);
        }
    }

    @Override
    public ResponseObject updateTypeAffichage(TypeAffichage typeAffichage) {
        try {

            if (typeAffichage != null) {
                if (typeAffichageRepository.existsById(typeAffichage.getIdTypeAffichage())) {


                    TypeAffichage result = typeAffichageRepository.save(typeAffichage);
                    return new ResponseObject(EnumMessage.SUCCESS_UPDATE.code,
                            EnumMessage.SUCCESS_UPDATE.label, result);




                } else {
                    return new ResponseObject(EnumMessage.TYPEAFFICHAGE_NOT_EXIST.code, EnumMessage.TYPEAFFICHAGE_NOT_EXIST.label,
                            null);

                }

            } else {
                return new ResponseObject(EnumMessage.TYPEAFFICHAGE_EMPTY.code, EnumMessage.TYPEAFFICHAGE_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, e.getMessage(), null);
        }
    }

    @Override
    public ResponseObject deleteTypeAffichage(String idTypeAffichage) {
        try {
            if (idTypeAffichage != null) {
                if (typeAffichageRepository.existsById(idTypeAffichage)) {
                    typeAffichageRepository.deleteById(idTypeAffichage);
                    return new ResponseObject(EnumMessage.SUCCESS_DELETE.code, EnumMessage.SUCCESS_DELETE.label, true);
                } else {
                    return new ResponseObject(EnumMessage.TYPEAFFICHAGE_EMPTY.code, EnumMessage.TYPEAFFICHAGE_EMPTY.label,
                            false);
                }
            } else {
                return new ResponseObject(EnumMessage.TYPEAFFICHAGE_ID_EMPTY.code, EnumMessage.TYPEAFFICHAGE_ID_EMPTY.label, false);

            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

    @Override
    public ResponseObject findAllActiveTypeAffichage() {
        try {
            List<TypeAffichage> result = typeAffichageRepository.findAllByFActifEquals(1);
            if (result.size() >0) {
                return new ResponseObject(EnumMessage.LIST_TYPEAFFICHAGE_NOT_EMPTY.code, EnumMessage.LIST_TYPEAFFICHAGE_NOT_EMPTY.label,
                        result);
            } else {
                return new ResponseObject(EnumMessage.LIST_TYPEAFFICHAGE_EMPTY.code, EnumMessage.LIST_TYPEAFFICHAGE_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }
    }

