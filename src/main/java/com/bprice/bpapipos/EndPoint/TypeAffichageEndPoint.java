package com.bprice.bpapipos.EndPoint;

import com.bprice.bpapipos.service.ITypeAffichageService;
import com.bprice.persistance.model.TypeAffichage;
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
public class TypeAffichageEndPoint {
    @Autowired
    ITypeAffichageService typeAffichageService;

    @PostMapping("/createTypeAffichage")
    @ApiOperation(value = "créer un Type d'Affichag", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object createformat(HttpServletRequest request, @RequestBody @Valid TypeAffichage typeAffichage){
        return typeAffichageService.createTypeAffichage(typeAffichage);
    }

    @DeleteMapping("/deleteTypeAffichage/{idTypeAffichage}")
    @ApiOperation(value = "Supprimer un Type d'Affichag", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object deleteformat(HttpServletRequest request,@PathVariable("idTypeAffichage") String idTypeAffichage){
        return typeAffichageService.deleteTypeAffichage(idTypeAffichage);
    }

    @PutMapping("/updateTypeAffichage")
    @ApiOperation(value = "Modifier un Type d'Affichag", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object updateformat(HttpServletRequest request,@RequestBody @Valid TypeAffichage typeAffichage){
        return typeAffichageService.updateTypeAffichage(typeAffichage);
    }

    @GetMapping("/findAllTypeAffichage")
    @ApiOperation(value = "Afficher la list des Types Affichage ", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllformat(HttpServletRequest request){
        return  typeAffichageService.findAllTypeAffichage();
    }

    @GetMapping("/findAllActiveTypeAffichage")
    @ApiOperation(value = "Afficher la list des Types Affichage active ", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllActiveformat(HttpServletRequest request){
        return  typeAffichageService.findAllActiveTypeAffichage();
    }
}
