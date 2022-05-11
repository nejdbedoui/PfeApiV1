package com.bprice.bpapipos.EndPoint;

import com.bprice.bpapipos.repository.IActionMarketingRepository;
import com.bprice.bpapipos.repository.IParametreActionMarketingRepository;
import com.bprice.bpapipos.service.IActionMarketingService;
import com.bprice.bpapipos.service.IParametreActionMarketingService;
import com.bprice.persistance.model.ActionMarketing;
import com.bprice.persistance.model.ParametreActionMarketing;
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
public class ParametreActionMarketingEndPoint {
    @Autowired
    IParametreActionMarketingService parametreActionMarketingService;
    @Autowired
    IParametreActionMarketingRepository parametreActionMarketingRepository;


    @PostMapping("/CreateParametreActionMarketing/{idAction}")
    @ApiOperation(value = "créer une parametre d'Action Marketing", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object CreateParametreActionMarketing(HttpServletRequest request, @RequestBody @Valid ParametreActionMarketing parametreActionMarketing,@PathVariable("idAction") String idAction){
        return parametreActionMarketingService.CreateParametreActionMarketing(parametreActionMarketing,idAction);
    }

    @GetMapping("/findAllParametreActionMarketing")
    @ApiOperation(value = "Afficher la list des Actions Marketing ", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllParametreActionMarketing(HttpServletRequest request){
        return  parametreActionMarketingService.findAll();
    }
}
