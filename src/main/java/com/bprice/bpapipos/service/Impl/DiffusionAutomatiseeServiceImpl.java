package com.bprice.bpapipos.service.Impl;

import com.bprice.bpapipos.service.IDiffusionAutomatiseeService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Configuration
@EnableScheduling
public class DiffusionAutomatiseeServiceImpl implements IDiffusionAutomatiseeService {


    @Override
    public void MiseAJour() {
        System.out.println("Now is "+ new Date());
    }
}
