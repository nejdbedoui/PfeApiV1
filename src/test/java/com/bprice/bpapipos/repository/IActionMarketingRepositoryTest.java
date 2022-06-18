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

   private final IActionMarketingService undertest=new ActionMarketingServiceImpl();



    @Test
    void findAllaction() {
        assertNotNull(undertest.findAll());
    }

    @Test
    void createaction(){
        ActionMarketing a=new ActionMarketing();
        a.setExternUrl("azer");
        a.setDescription("aeff");
        a.setIdPartenaire("6051af0a33c276f08d303946");
        a.setFrequence(5);
        ResponseObject a2=undertest.CreateActionMarketing(a);
        assertNotNull(a2);
    }

    @Test
    void updateaction(){
        ActionMarketing a=new ActionMarketing();
        a.setExternUrl("azer");
        a.setDescription("aeff");
        a.setIdPartenaire("6051af0a33c276f08d303946");
        a.setFrequence(5);
        ResponseObject a2=undertest.CreateActionMarketing(a);
        assertNotNull(a2);
    }



    @Test
    void deleteaction(){
        assertNotNull(undertest.DeleteActionMarketing("azed"));
    }

    @Test
    void findAllByIdPartenaireOrderByDateCreationDesc(){
        assertNotNull(undertest.findAll().getResult());
    }
    @Test
    void findByIdActionMarketing(){
        assertNotNull(undertest.findByIdActionMarketing("azfds"));
    }



}