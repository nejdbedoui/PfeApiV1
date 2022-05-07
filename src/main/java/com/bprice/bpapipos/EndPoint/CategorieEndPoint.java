package com.bprice.bpapipos.EndPoint;

import com.bprice.bpapipos.service.IActionMarketingService;
import com.bprice.bpapipos.service.ICategorieService;
import com.bprice.persistance.model.ActionMarketing;
import com.bprice.persistance.model.Categorie;
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
public class CategorieEndPoint {

    @Autowired
    ICategorieService categorieService;

    @PostMapping("/CreateCategorie")
    @ApiOperation(value = "créer une Categorie", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object CreateCategorie(HttpServletRequest request, @RequestBody @Valid Categorie categorie){
        return categorieService.CreateCategorie(categorie);
    }

    @DeleteMapping("/DeleteCategorie/{idCategorie}")
    @ApiOperation(value = "Supprimer une Action Marketing", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object DeleteCategorie(HttpServletRequest request,@PathVariable("idCategorie") String idCategorie){
        return categorieService.DeleteCategorie(idCategorie);
    }

    @PutMapping("/UpdateCategorie")
    @ApiOperation(value = "Modifier une Action Marketing", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object UpdateCategorie(HttpServletRequest request,@RequestBody @Valid Categorie categorie){
        return categorieService.UpdateCategorie(categorie);
    }




    @GetMapping("/findByIdCategorie/{idCategorie}")
    @ApiOperation(value = "Afficher les Categories selon l'idCategorie envoyer", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findByIdCategorie(HttpServletRequest request,@PathVariable("idCategorie") String idCategorie){
        return  categorieService.findByIdCategorie(idCategorie);
    }




    @GetMapping("/findAllCategorieExept/{idCategorie}")
    @ApiOperation(value = "Afficher la list des Categories ", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllCategorieExept(HttpServletRequest request,@PathVariable("idCategorie") String idCategorie){
        return  categorieService.findAllByIdCategorieNot(idCategorie);
    }
}
