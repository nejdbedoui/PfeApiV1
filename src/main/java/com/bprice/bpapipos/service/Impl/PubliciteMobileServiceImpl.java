package com.bprice.bpapipos.service.Impl;

import com.bprice.bpapipos.Enum.EnumMessage;
import com.bprice.bpapipos.repository.IPubliciteMobileRepository;
import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.bpapipos.service.IActionMarketingService;
import com.bprice.bpapipos.service.IPubliciteMobileService;
import com.bprice.persistance.model.ActionMarketing;
import com.bprice.persistance.model.FormatAffichage;
import com.bprice.persistance.model.PartenaireBprice;
import com.bprice.persistance.model.PubliciteMobile;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PubliciteMobileServiceImpl implements IPubliciteMobileService {
    IPubliciteMobileRepository publiciteMobileRepository;
    IActionMarketingService actionMarketingService;

    @Override
    public ResponseObject findAllPubliciteMobile() {
        try {
            List<PubliciteMobile> result = publiciteMobileRepository.findAll();
            if (result.size() >0) {
                return new ResponseObject(EnumMessage.LIST_PUBLICITEMOBILE_NOT_EMPTY.code, EnumMessage.LIST_PUBLICITEMOBILE_NOT_EMPTY.label,
                        result);
            } else {
                return new ResponseObject(EnumMessage.LIST_PUBLICITEMOBILE_EMPTY.code, EnumMessage.LIST_PUBLICITEMOBILE_EMPTY.label, null);
            }
        } catch (Exception e) {
            return new ResponseObject(EnumMessage.ERREUR_QUERY.code, EnumMessage.ERREUR_QUERY.label, null);

        }
    }

    @Override
    public ResponseObject createPubliciteMobile(PubliciteMobile publiciteMobile) {
       return null;
    }

    @Override
    public ResponseObject deletePubliciteMobile(String idPubliciteMobile) {
        return null;
    }

    @Override
    public ResponseObject findAllPubliciteMobileByStatut(int statut) {
        return null;
    }

    @Override
    public ResponseObject findPubliciteMobileById(String idPubliciteMobile) {
        return null;
    }

    @Override
    public ResponseObject findPubliciteMobileByIdPartenaireCible(String idPartenaireCible) {
        return null;
    }
}
