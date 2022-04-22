package com.bprice.bpapipos.EndPoint;

import com.bprice.bpapipos.service.IModeReglementService;
import com.bprice.persistance.model.ModeReglement;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by ahmed on 06/02/2020.
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/v1")
public class ModeReglementEndPoint {
    @Autowired
    private IModeReglementService ModeReglementService;

    @PostMapping("/CreateModeReglement")
    @ApiOperation(value = "créer un ModeReglement", notes = "Retourner le ModeReglement créé.\n"
            + "\n<b>result = 1 :</b> objet créé avec succes</b> \n"
            + "\n<b>result = 0 :</b>ModeReglement est vide\n"
            + "\n<b>result = -1 :</b>PointVente n'exist pas\n"
            + "\n<b>result = -2 :</b>id PointVente est null\n"
            + "\n<b>result = -3 :</b> Query failed\n"
            + "\n<b>result = 401 :</b> TOKEN NOT AUTHORIZED\n"
            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object CreateModeReglement(HttpServletRequest request, @RequestBody @Valid ModeReglement modeReglement){
        return ModeReglementService.CreateModeReglement(modeReglement);
    }

    @DeleteMapping("/DeleteModeReglement/{idModeReglement}")
    @ApiOperation(value = "Supprimer un ModeReglement", notes = "Retourner une valeur boolean qui indique si le ModeReglement a été supprimé ou non.\n"
            + "\n<b>result = 1 :</b> objet supprimé avec succes</b> \n"
            + "\n<b>result = 0 :</b> Id est vide</b> \n"
            + "\n<b>result = -3 :</b> Query failed\n"
            + "\n<b>result = -4 :</b>ModeReglement n'exist pas\n"
            + "\n<b>result = 401 :</b> TOKEN NOT AUTHORIZED\n"
            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object DeleteModeReglement(HttpServletRequest request,@PathVariable("idModeReglement") String idModeReglement){
        return ModeReglementService.DeleteModeReglement(idModeReglement);
    }

    @PutMapping("/UpdateModeReglement")
    @ApiOperation(value = "Modifier un ModeReglement", notes = "Retourner le ModeReglement modifié.\n"
            + "\n<b>result = 1 :</b> objet modifié avec succes</b> \n"
            + "\n<b>result = 0 :</b>ModeReglement est vide\n"
            + "\n<b>result = -1 :</b>PointVente n'exist pas\n"
            + "\n<b>result = -2 :</b>id PointVente est null\n"
            + "\n<b>result = -3 :</b> Query failed\n"
            + "\n<b>result = -4 :</b> ModeReglement n'exist pas\n"
            + "\n<b>result = 401 :</b> TOKEN NOT AUTHORIZED\n"
            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object UpdateModeReglement(HttpServletRequest request,@RequestBody @Valid ModeReglement ModeReglement){
        return ModeReglementService.UpdateModeReglement(ModeReglement);
    }

    @GetMapping("/findByIdModeReglement/{idModeReglement}")
    @ApiOperation(value = "Afficher le ModeReglement selon l'idModeReglement envoyer", notes = "Retourner le ModeReglement selon l'idModeReglement envoyer\n"
            + "\n<b>result = 1 :</b> ModeReglement exist</b> \n"
            + "\n<b>result = 0 :</b>Id est vide\n"
            + "\n<b>result = -3 :</b> Query failed\n"
            + "\n<b>result = -4 :</b>ModeReglement n'exist pas\n"
            + "\n<b>result = 401 :</b> TOKEN NOT AUTHORIZED\n"
            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findByIdModeReglement(HttpServletRequest request,@PathVariable("idModeReglement") String idModeReglement){
        return  ModeReglementService.findByIdModeReglement(idModeReglement);
    }


    @GetMapping("/findAllModeReglementByIdPointVente")
    @ApiOperation(value = "Afficher le ModeReglement selon l'idPointVente envoyer", notes = "Retourner le ModeReglement selon l'idModeReglement envoyer\n"
            + "\n<b>result = 1 :</b> ModeReglement exist</b> \n"
            + "\n<b>result = 0 :</b>Id est vide\n"
            + "\n<b>result = -3 :</b> Query failed\n"
            + "\n<b>result = -4 :</b>ModeReglement n'exist pas\n"
            + "\n<b>result = 401 :</b> TOKEN NOT AUTHORIZED\n"
            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllByIdPointVente(HttpServletRequest request,@RequestParam(required = false) String idPointVente){
        return  ModeReglementService.findAllByIdPointVente(idPointVente);
    }


    @GetMapping("/findAllModeReglement")
    @ApiOperation(value = "Afficher la list des ModeReglements ", notes = "Retourner la list des ModeReglements \n"
            + "\n<b>result = 1 :</b> List ModeReglement n'est pas vide</b> \n"
            + "\n<b>result = 0 :</b>List ModeReglement est vide\n"
            + "\n<b>result = -2 :</b>un ou plusieurs parametres envoyer sont null\n"
            + "\n<b>result = -3 :</b> Query failed\n"
            + "\n<b>result = 401 :</b> TOKEN NOT AUTHORIZED\n"
            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllModeReglement(HttpServletRequest request){
        return  ModeReglementService.findAll();
    }
}
