package com.bprice.bpapipos.service.Impl;

import com.bprice.bpapipos.Enum.EnumMessage;
import com.bprice.bpapipos.repository.IVilleRepository;
import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.bpapipos.service.IVilleService;
import com.bprice.persistance.model.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleServiceImpl implements IVilleService {
    @Autowired
    IVilleRepository iVillepRepository;

    @Override
    public ResponseObject createVille(Ville ville) {
        try {
            if (ville != null) {

                Ville result = iVillepRepository.save(ville);

                return new ResponseObject(EnumMessage.SUCCESS_CREATION.code,
                        EnumMessage.SUCCESS_CREATION.label, result);

            } else {
                return new ResponseObject(EnumMessage.VILLE_EMPTY.code, EnumMessage.VILLE_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, e.getMessage(), null);
        }
    }

    @Override
    public ResponseObject updateVille(Ville ville) {
        try {
            if (ville != null) {
                if (iVillepRepository.existsById(ville.getIdVille())) {


                    Ville result = iVillepRepository.save(ville);
                    return new ResponseObject(EnumMessage.SUCCESS_UPDATE.code,
                            EnumMessage.SUCCESS_UPDATE.label, result);

                } else {
                    return new ResponseObject(EnumMessage.VILLE_NOT_EXIST.code, EnumMessage.VILLE_NOT_EXIST.label,
                            null);

                }

            } else {
                return new ResponseObject(EnumMessage.VILLE_EMPTY.code, EnumMessage.VILLE_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, e.getMessage(), null);
        }
    }

    @Override
    public ResponseObject deleteVille(String id) {
        try {
            if (id != null) {
                if (iVillepRepository.existsById(id)) {
                    iVillepRepository.deleteById(id);
                    return new ResponseObject(EnumMessage.SUCCESS_DELETE.code, EnumMessage.SUCCESS_DELETE.label, true);
                } else {
                    return new ResponseObject(EnumMessage.VILLE_EMPTY.code, EnumMessage.VILLE_EMPTY.label,
                            false);
                }
            } else {
                return new ResponseObject(EnumMessage.VILLE_ID_EMPTY.code, EnumMessage.VILLE_ID_EMPTY.label, false);

            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }
    @Override
    public ResponseObject findAllVille() {
        try {
            List<Ville> result = iVillepRepository.findAll();
            if (result.size() >0) {
                return new ResponseObject(EnumMessage.LIST_VILLE_NOT_EMPTY.code, EnumMessage.LIST_VILLE_NOT_EMPTY.label,
                        result);
            } else {
                return new ResponseObject(EnumMessage.LIST_VILLE_EMPTY.code, EnumMessage.LIST_VILLE_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

    @Override
    public ResponseObject findAllActiveVille() {
        try {
            List<Ville> result = iVillepRepository.findAllByFActiveEquals(1);
            if (result.size() >0) {
                return new ResponseObject(EnumMessage.LIST_VILLE_NOT_EMPTY.code, EnumMessage.LIST_VILLE_NOT_EMPTY.label,
                        result);
            } else {
                return new ResponseObject(EnumMessage.LIST_VILLE_EMPTY.code, EnumMessage.LIST_VILLE_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

}
