package com.bprice.bpapipos.EndPoint;

import com.bprice.bpapipos.service.ICanalDiffusionService;
import com.bprice.persistance.model.CanalDiffusion;
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
public class CanalDiffusionEndPoint {

    @Autowired
    ICanalDiffusionService iCanalDiffusionService;

    @PostMapping("/createCanal")
    @ApiOperation(value = "créer une Canal", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object createCanal(HttpServletRequest request, @RequestBody @Valid CanalDiffusion canal){
        return iCanalDiffusionService.createCanal(canal);
    }

    @DeleteMapping("/deleteCanal/{idCanal}")
    @ApiOperation(value = "Supprimer une Canal", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object deleteCanal(HttpServletRequest request,@PathVariable("idCanal") String idCanal){
        return iCanalDiffusionService.deleteCanal(idCanal);
    }

    @PutMapping("/updateCanal")
    @ApiOperation(value = "Modifier une Canal", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object updateCanal(HttpServletRequest request,@RequestBody @Valid CanalDiffusion canal){
        return iCanalDiffusionService.updateCanal(canal);
    }


    @GetMapping("/findAllCanal")
    @ApiOperation(value = "Afficher la list des Canal ", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllCanal(HttpServletRequest request){
        return  iCanalDiffusionService.findAllCanal();
    }

    @GetMapping("/findAllActiveCanal")
    @ApiOperation(value = "Afficher la list des Canal active ", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllActiveCanal(HttpServletRequest request){
        return  iCanalDiffusionService.findAllActiveCanal();
    }
}
