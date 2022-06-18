package com.bprice.bpapipos.service;

import com.bprice.bpapipos.response.ResponseObject;

public interface IDashboardGeneraleService {
    public ResponseObject findAllDemandeDiffusionDTOByIdPartenaire(String idPartenaire);
    public ResponseObject findAllActionEnCourDeDiffusionByIdPartenaire(String idPartenaire);

    public ResponseObject findTotalRevenueAndNombreDemandeEnCour(String idPartenaire);

}
