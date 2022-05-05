package com.bprice.bpapipos.EndPoint;

import com.bprice.bpapipos.service.IStorageService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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
    public Object upload(@RequestParam("file") MultipartFile multipartFile) {
        System.out.print(multipartFile);
        return storageService.CreateStorageItem(multipartFile);
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

    @DeleteMapping("/DeletePublicicteImage/{idPubliciteImage}")
    @ApiOperation(value = "Supprimer une Action Marketing", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object DeleteActionMarketing(HttpServletRequest request,@PathVariable("idPubliciteImage") String idPubliciteImage) throws IOException {
        return storageService.DeletePublicicteImage(idPubliciteImage);
    }

    @GetMapping("/findAllStorage")
    @ApiOperation(value = "Afficher la list des Publicite ", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllPublicite(HttpServletRequest request){
        return  storageService.findAll();
    }

}
