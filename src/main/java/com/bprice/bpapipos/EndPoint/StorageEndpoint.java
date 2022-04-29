package com.bprice.bpapipos.EndPoint;

import com.bprice.bpapipos.service.IStorageService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1")
public class StorageEndpoint {

    @Autowired
    IStorageService storageService;

    @PostMapping("/Addtostorage")
    @ApiOperation(value = "créer une Population Cible", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object Addtostorage(HttpServletRequest request, @RequestBody @Valid MultipartFile file){

        return storageService.AddtoStorage(file);
    }


    @GetMapping("/finditembyid/{idfile}")
    @ApiOperation(value = "Afficher les Population Cibles selon l'idPopulationCible envoyer", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object finditembyid(HttpServletRequest request,@PathVariable("idfile") String idfile){
        return  storageService.finditembyid(idfile);
    }

}
