package com.bprice.bpapipos.repository;

import com.bprice.bpapipos.response.ResponseObject;
import com.bprice.bpapipos.service.IActionMarketingService;
import com.bprice.bpapipos.service.IDashboardGeneraleService;
import com.bprice.bpapipos.service.Impl.ActionMarketingServiceImpl;
import com.bprice.bpapipos.service.Impl.DashboardGeneraleServiceImpl;
import com.bprice.persistance.model.ActionMarketing;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IActionMarketingRepositoryTest {

    private final IDashboardGeneraleService undertest=new DashboardGeneraleServiceImpl();



    @Test
    void findAllDemandeDiffusionDTOByIdPartenaire() {
        assertNotNull(undertest.findAllDemandeDiffusionDTOByIdPartenaire("6051af0a33c276f08d303946"));
    }
    @Test
   void findAllActionEnCourDeDiffusionByIdPartenaire(){
        assertNotNull(undertest.findAllActionEnCourDeDiffusionByIdPartenaire("6051af0a33c276f08d303946"));

    }



}