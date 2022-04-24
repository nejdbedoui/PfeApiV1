package com.bprice.bpapipos.EndPoint;

import com.bprice.bpapipos.service.IActionMarketingService;
import com.bprice.persistance.model.ActionMarketing;
import com.bprice.persistance.model.ModeReglement;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1")
public class ActionMarketingEndPoint {

@Autowired
IActionMarketingService actionMarketingService;

    @PostMapping("/CreateActionMarketing")
    @ApiOperation(value = "créer une Action Marketing", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object CreateActionMarketing(HttpServletRequest request, @RequestBody @Valid ActionMarketing actionMarketing){
        return actionMarketingService.CreateActionMarketing(actionMarketing);
    }

    @DeleteMapping("/DeleteActionMarketing/{idActionMarketing}")
    @ApiOperation(value = "Supprimer une Action Marketing", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object DeleteActionMarketing(HttpServletRequest request,@PathVariable("idActionMarketing") String idActionMarketing){
        return actionMarketingService.DeleteActionMarketing(idActionMarketing);
    }

    @PutMapping("/UpdateActionMarketing")
    @ApiOperation(value = "Modifier une Action Marketing", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object UpdateActionMarketing(HttpServletRequest request,@RequestBody @Valid ActionMarketing actionMarketing){
        return actionMarketingService.UpdateActionMarketing(actionMarketing);
    }

    @GetMapping("/findByIdActionMarketing/{idActionMarketing}")
    @ApiOperation(value = "Afficher l' Action Marketing selon l'idActionMarketing envoyer", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findByIdActionMarketing(HttpServletRequest request,@PathVariable("idActionMarketing") String idActionMarketing){
        return  actionMarketingService.findByIdActionMarketing(idActionMarketing);
    }


    @GetMapping("/findAllByIdPartenaire/{IdPartenaire}")
    @ApiOperation(value = "Afficher les Actions Marketing selon l'idPartenaire envoyer", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllByIdPartenaire(HttpServletRequest request,@PathVariable("IdPartenaire") String IdPartenaire){
        return  actionMarketingService.findAllByIdPartenaire(IdPartenaire);
    }

    @GetMapping("/findAllActionMarketing")
    @ApiOperation(value = "Afficher la list des Actions Marketing ", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllActionMarketing(HttpServletRequest request){
        return  actionMarketingService.findAll();
    }
}
