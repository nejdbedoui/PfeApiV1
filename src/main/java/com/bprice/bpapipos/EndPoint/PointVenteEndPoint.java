package com.bprice.bpapipos.EndPoint;

import com.bprice.bpapipos.service.IPointVenteService;
import com.bprice.persistance.model.PointVente;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by ahmed on 18/01/2020.
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/v1")
public class PointVenteEndPoint {

    @Autowired
    private IPointVenteService pointVenteService;

    @PostMapping("/CreatePointVente")
    @ApiOperation(value = "créer un PointVente", notes = "Retourner le PointVente créé.\n"
            + "\n<b>result = 1 :</b> objet créé avec succes</b> \n"
            + "\n<b>result = 0 :</b>PointVente est vide\n"
            + "\n<b>result = -3 :</b> Query failed\n"
            + "\n<b>result = 401 :</b> TOKEN NOT AUTHORIZED\n"
            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object CreatePointVente(HttpServletRequest request, @RequestBody @Valid PointVente pointVente){
        return pointVenteService.CreatePointVente(pointVente);
    }

    @PostMapping("/CreateManyPointVente")
    @ApiOperation(value = "créer plusieurs PointVentes", notes = "Retourner la liste des PointVentes créés.\n"
            + "\n<b>result = 1 :</b> objet créé avec succes</b> \n"
            + "\n<b>result = 0 :</b>List PointVente est vide\n"
            + "\n<b>result = -3 :</b> Query failed\n"
            + "\n<b>result = 401 :</b> TOKEN NOT AUTHORIZED\n"
            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object CreateManyPointVente(HttpServletRequest request,@RequestBody @Valid List<PointVente> pointVentes){
        return pointVenteService.CreateManyPointVente(pointVentes);
    }

    @DeleteMapping("/DeletePointVente/{idPointVente}")
    @ApiOperation(value = "Supprimer un PointVente", notes = "Retourner une valeur boolean qui indique si le PointVente a été supprimé ou non.\n"
            + "\n<b>result = 1 :</b> objet supprimé avec succes</b> \n"
            + "\n<b>result = -1 :</b>PointVente n'exist pas\n"
            + "\n<b>result = -3 :</b> Query failed\n"
            + "\n<b>result = 401 :</b> TOKEN NOT AUTHORIZED\n"
            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object DeleteUtilistaeur(HttpServletRequest request,@PathVariable("idPointVente") String idPointVente){
        return pointVenteService.DeletePointVente(idPointVente);
    }

    @PutMapping("/UpdatePointVente")
    @ApiOperation(value = "Modifier un PointVente", notes = "Retourner le PointVente modifié.\n"
            + "\n<b>result = 1 :</b> objet modifié avec succes</b> \n"
            + "\n<b>result = 0 :</b>PointVente est vide\n"
            + "\n<b>result = -1 :</b>PointVente n'exist pas\n"
            + "\n<b>result = -3 :</b> Query failed\n"
            + "\n<b>result = 401 :</b> TOKEN NOT AUTHORIZED\n"
            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object UpdatePointVente(HttpServletRequest request,@RequestBody @Valid PointVente pointVente){
        return pointVenteService.UpdatePointVente(pointVente);
    }

    @GetMapping("/findPointVenteByIdPointVente/{idPointVente}")
    @ApiOperation(value = "Afficher l'PointVente selon l'idPointVente envoyer", notes = "Retourner le PointVente selon l'idPointVente envoyer\n"
            + "\n<b>result = 1 :</b> List Utilisateur n'est pas vide</b> \n"
            + "\n<b>result = 0 :</b>Id est vide\n"
            + "\n<b>result = -1 :</b>Utilisateur n'exist pas\n"
            + "\n<b>result = -3 :</b> Query failed\n"
            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findByIdPointVente(HttpServletRequest request,@PathVariable("idPointVente") String idPointVente){
        return pointVenteService.findByIdPointVente(idPointVente);
    }
    
    
    @GetMapping("/changeStatusPv/{idPointVente}/{status}")
    @ApiOperation(value = "changer statut pv", notes = "changer statut pv\n"
            + "\n<b>result = 1 :</b> statut changé</b> \n"
            + "\n<b>result = 0 :</b>Id est vide\n"
            + "\n<b>result = -1 :</b>PV n'exist pas\n"
            + "\n<b>result = -3 :</b> Query failed\n"
            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object changeStatusPv(HttpServletRequest request,@PathVariable("idPointVente") String idPointVente,@PathVariable("status")Short status){
        return pointVenteService.changeStatusPv(idPointVente,status);
    }

    @GetMapping("/findAllPointVenteByFActif/{factif}")
    @ApiOperation(value = "Afficher la liste de tous les PointVentes par FActif", notes = "Retourner la liste de tous les PointVentes par FActif.\n"
            + "\n<b>result = 1 :</b> List Utilisateur n'est pas vide</b> \n"
            + "\n<b>result = 0 :</b>List Utilisateur est vide\n"
            + "\n<b>result = -2 :</b>le parametre envoyer est null\n"
            + "\n<b>result = -3 :</b> Query failed\n"
            + "\n<b>result = 401 :</b> TOKEN NOT AUTHORIZED\n"
            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllByFActif(HttpServletRequest request,@PathVariable("factif") Short factif){
        return pointVenteService.findAllByFActif(factif);
    }

    @GetMapping("/findAllByIdPartenaireBprice/{IdPartenaireBprice}")
    @ApiOperation(value = "Afficher la liste de tous les PointVentes par IdPartenaireBprice", notes = "Retourner la liste de tous les PointVentes par IdPartenaireBprice.\n"
            + "\n<b>result = 1 :</b> List PointVentes n'est pas vide</b> \n"
            + "\n<b>result = 0 :</b>List PointVentes est vide\n"
            + "\n<b>result = -2 :</b>le parametre envoyer est null\n"
            + "\n<b>result = -3 :</b> Query failed\n"
            + "\n<b>result = 401 :</b> TOKEN NOT AUTHORIZED\n"
            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllByIdPartenaireBprice(HttpServletRequest request,@PathVariable("IdPartenaireBprice") String IdPartenaireBprice){
        return pointVenteService.findAllByIdPartenaire(IdPartenaireBprice);
    }

    @GetMapping("/findAllByIdPartenaireBpriceAndFActif/{idPartenaireBprice}/{fActif}")
    @ApiOperation(value = "Afficher la liste de tous les PointVentes par IdPartenaireBprice et FActif", notes = "Retourner la liste de tous les PointVentes par IdPartenaireBprice et FActif.\n"
            + "\n<b>result = 1 :</b> List PointVentes n'est pas vide</b> \n"
            + "\n<b>result = 0 :</b>List PointVentes est vide\n"
            + "\n<b>result = -2 :</b>le parametre envoyer est null\n"
            + "\n<b>result = -3 :</b> Query failed\n"
            + "\n<b>result = 401 :</b> TOKEN NOT AUTHORIZED\n"
            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllByIdPartenaireBpriceAndFActif(HttpServletRequest request,@PathVariable("idPartenaireBprice") String idPartenaireBprice,@PathVariable("fActif")  Short fActif){
        return pointVenteService.findAllByIdPartenaireAndFActif(idPartenaireBprice,fActif);
    }

}
