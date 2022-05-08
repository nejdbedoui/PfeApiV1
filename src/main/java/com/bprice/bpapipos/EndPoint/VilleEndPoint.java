package com.bprice.bpapipos.EndPoint;

import com.bprice.bpapipos.service.IVilleService;
import com.bprice.persistance.model.Ville;
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
public class VilleEndPoint {
    @Autowired
    IVilleService iVilleService;

    @PostMapping("/createVille")
    @ApiOperation(value = "créer une Canal", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object createVille(HttpServletRequest request, @RequestBody @Valid Ville ville){
        return iVilleService.createVille(ville);
    }

    @DeleteMapping("/deleteVille/{idCanal}")
    @ApiOperation(value = "Supprimer une Canal", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object deleteVille(HttpServletRequest request,@PathVariable("idCanal") String idville){
        return iVilleService.deleteVille(idville);
    }

    @PutMapping("/updateVille")
    @ApiOperation(value = "Modifier une Canal", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object updateVille(HttpServletRequest request,@RequestBody @Valid Ville ville){
        return iVilleService.updateVille(ville);
    }


    @GetMapping("/findAllVille")
    @ApiOperation(value = "Afficher la list des Canal ", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllVille(HttpServletRequest request){
        return  iVilleService.findAllVille();
    }

    @GetMapping("/findAllActiveVille")
    @ApiOperation(value = "Afficher la list des Canal active ", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllActiveVille(HttpServletRequest request){
        return  iVilleService.findAllActiveVille();
    }
}
