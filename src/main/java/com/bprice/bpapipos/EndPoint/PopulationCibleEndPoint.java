package com.bprice.bpapipos.EndPoint;

import com.bprice.bpapipos.service.IPopulationCibleService;
import com.bprice.persistance.model.PopulationCible;
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
public class PopulationCibleEndPoint {

    @Autowired
    IPopulationCibleService populationCibleService;

    @PostMapping("/CreatePopulationCible")
    @ApiOperation(value = "créer une Population Cible", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object CreatePopulationCible(HttpServletRequest request, @RequestBody @Valid PopulationCible PopulationCible){
        return populationCibleService.CreatePopulationCible(PopulationCible);
    }

    @DeleteMapping("/DeletePopulationCible/{idPopulationCible}")
    @ApiOperation(value = "Supprimer une Population Cible", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object DeletePopulationCible(HttpServletRequest request,@PathVariable("idPopulationCible") String idPopulationCible){
        return populationCibleService.DeletePopulationCible(idPopulationCible);
    }

    @PutMapping("/UpdatePopulationCible")
    @ApiOperation(value = "Modifier une Population Cible", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object UpdatePopulationCible(HttpServletRequest request,@RequestBody @Valid PopulationCible PopulationCible){
        return populationCibleService.UpdatePopulationCible(PopulationCible);
    }

    @GetMapping("/findByAll")
    @ApiOperation(value = "Afficher les PopulationCibles selon l'idActionMarketing envoyer", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAll(HttpServletRequest request){
        return  populationCibleService.findAllByIdActionMarketing();
    }

    @GetMapping("/findByIdPopulationCible/{idPopulationCible}")
    @ApiOperation(value = "Afficher les Population Cibles selon l'idPopulationCible envoyer", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findByIdPopulationCible(HttpServletRequest request,@PathVariable("idPopulationCible") String idPopulationCible){
        return  populationCibleService.findByIdPopulationCible(idPopulationCible);
    }




    @GetMapping("/findAllPopulationCible")
    @ApiOperation(value = "Afficher la list des Population Cibles ", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllPopulationCible(HttpServletRequest request){
        return  populationCibleService.findAll();
    }
}
