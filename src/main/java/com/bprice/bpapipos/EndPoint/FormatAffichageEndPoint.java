package com.bprice.bpapipos.EndPoint;

import com.bprice.bpapipos.service.IFormatAffichageService;
import com.bprice.persistance.model.CanalDiffusion;
import com.bprice.persistance.model.FormatAffichage;
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
public class FormatAffichageEndPoint {
    @Autowired
    IFormatAffichageService iFormatAffichageService;

    @PostMapping("/createformat")
    @ApiOperation(value = "créer un format d'affichage", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object createformat(HttpServletRequest request, @RequestBody @Valid FormatAffichage Format){
        return iFormatAffichageService.createformat(Format);
    }

    @DeleteMapping("/deleteformat/{idCanal}")
    @ApiOperation(value = "Supprimer un format d'affichage", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object deleteformat(HttpServletRequest request,@PathVariable("idCanal") String idFormat){
        return iFormatAffichageService.deleteformat(idFormat);
    }

    @PutMapping("/updateformat")
    @ApiOperation(value = "Modifier un format d'affichage", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object updateformat(HttpServletRequest request,@RequestBody @Valid FormatAffichage Format){
        return iFormatAffichageService.updateformat(Format);
    }

    @GetMapping("/findAllformat")
    @ApiOperation(value = "Afficher la list des formats ", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllformat(HttpServletRequest request){
        return  iFormatAffichageService.findAllformat();
    }

    @GetMapping("/findAllActiveformat")
    @ApiOperation(value = "Afficher la list des formats active ", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllActiveformat(HttpServletRequest request){
        return  iFormatAffichageService.findAllActiveformat();
    }

}
