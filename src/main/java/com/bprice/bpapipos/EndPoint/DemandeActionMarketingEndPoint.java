package com.bprice.bpapipos.EndPoint;

import com.bprice.bpapipos.service.IDemandeActionMarketingService;
import com.bprice.persistance.model.ActionMarketing;
import com.bprice.persistance.model.DemandeActionMarketing;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1")
public class DemandeActionMarketingEndPoint {
    @Autowired
    IDemandeActionMarketingService iDemandeActionMarketingService;



}
