package com.bprice.bpapipos.EndPoint;

import com.bprice.bpapipos.dto.ActionMarketingDTO;
import com.bprice.bpapipos.service.IContratActionService;
import com.bprice.persistance.model.ActionMarketing;
import com.bprice.persistance.model.Contrat;
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
public class ContratActionEndPoint {

    @Autowired
IContratActionService contratActionService;


    @PostMapping("/CreateContratActionMarketing")
    @ApiOperation(value = "créer un Contrat d'Action Marketing", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object CreateActionMarketing(HttpServletRequest request, @RequestBody @Valid ActionMarketingDTO actionMarketingDTO){

        return contratActionService.CreateActionContract(actionMarketingDTO);
    }
    @GetMapping("/findAllContratActionMarketing")
    @ApiOperation(value = "Afficher la list des Contrat Actions Marketing ", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllActionMarketing(HttpServletRequest request){
        return  contratActionService.findAllContract();
    }


    @GetMapping("/findAllContratActionMarketingByPartenaireId/{idPartenaire}")
    @ApiOperation(value = "Afficher la list des Contrat Actions Marketing ", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllContratActionMarketingByPartenaireId(HttpServletRequest request, @PathVariable("idPartenaire") String idPartenaire){
        return  contratActionService.findAllContratByIdPartenaire(idPartenaire);
    }

    @PostMapping("/UpdateContratActionMarketing")
    @ApiOperation(value = "modifier un Contrat d'Action Marketing", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object UpdateContratActionMarketing(HttpServletRequest request, @RequestBody @Valid Contrat contrat){

        return contratActionService.UpdateActionContract(contrat);
    }
}



