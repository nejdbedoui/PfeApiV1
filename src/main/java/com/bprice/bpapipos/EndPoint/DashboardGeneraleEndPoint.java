package com.bprice.bpapipos.EndPoint;

import com.bprice.bpapipos.service.IDashboardGeneraleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1")
public class DashboardGeneraleEndPoint {
    @Autowired
    IDashboardGeneraleService dashboardGeneraleService;

    @GetMapping("/findAllActionEnCourDeDiffusionByIdPartenaire/{IdPartenaire}")
    @ApiOperation(value = "Afficher les Demandes selon l'idPartenaire envoyer", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllActionEnCourDeDiffusionByIdPartenaire(HttpServletRequest request, @PathVariable("IdPartenaire") String IdPartenaire){
        return  dashboardGeneraleService.findAllActionEnCourDeDiffusionByIdPartenaire(IdPartenaire);
    }

    @GetMapping("/findAllDemandeDiffusionDTOByIdPartenaire/{IdPartenaire}")
    @ApiOperation(value = "Afficher les Demandes selon l'idPartenaire envoyer", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllDemandeDiffusionDTOByIdPartenaire(HttpServletRequest request, @PathVariable("IdPartenaire") String IdPartenaire){
        return  dashboardGeneraleService.findAllDemandeDiffusionDTOByIdPartenaire(IdPartenaire);
    }

    @GetMapping("/findTotalRevenueAndNombreDemandeEnCour/{IdPartenaire}")
    @ApiOperation(value = "Afficher les Demandes selon l'idPartenaire envoyer", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findTotalRevenueAndNombreDemandeEnCour(HttpServletRequest request, @PathVariable("IdPartenaire") String IdPartenaire){
        return  dashboardGeneraleService.findTotalRevenueAndNombreDemandeEnCour(IdPartenaire);
    }
}
