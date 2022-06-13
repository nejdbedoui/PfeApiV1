package com.bprice.bpapipos.EndPoint;

import com.bprice.bpapipos.repository.IPartenaireBpriceRepository;
import com.bprice.bpapipos.service.IPartenaireBpriceService;
import com.bprice.persistance.model.PartenaireBprice;
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
public class PartenaireBpriceEndPoint {

    @Autowired
    private IPartenaireBpriceService partenaireBpriceService;
    private IPartenaireBpriceRepository partenaireBpriceRepository;
    @PostMapping("/CreatePartenaireBprice")
    @ApiOperation(value = "créer un PartenaireBprice", notes = "Retourner le PartenaireBprice créé.\n"
            + "\n<b>result = 1 :</b> objet créé avec succes</b> \n"
            + "\n<b>result = 0 :</b>PartenaireBprice est vide\n"
            + "\n<b>result = -2 :</b>matricule deja utiliser\n"
            + "\n<b>result = -3 :</b> Query failed\n"
            + "\n<b>result = -4 :</b> matricule est vide\n"
            + "\n<b>result = -5 :</b> ville n'exist pas\n"
            + "\n<b>result = -5 :</b> chart n'exist pas\n"
            + "\n<b>result = 401 :</b> TOKEN NOT AUTHORIZED\n"
            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object CreatePartenaireBprice(HttpServletRequest request, @RequestBody @Valid PartenaireBprice partenaireBprice){
        return partenaireBpriceService.CreatePartenaireBprice(partenaireBprice);
    }

    @PostMapping("/CreateManyPartenaireBprice")
    @ApiOperation(value = "créer plusieurs PartenaireBprices", notes = "Retourner la liste des PartenaireBprices créés.\n"
            + "\n<b>result = 1 :</b> objet créé avec succes</b> \n"
            + "\n<b>result = 0 :</b>List PartenaireBprice est vide\n"
            + "\n<b>result = -3 :</b> Query failed\n"
            + "\n<b>result = 401 :</b> TOKEN NOT AUTHORIZED\n"
            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object CreateManyPartenaireBprice(HttpServletRequest request,@RequestBody @Valid List<PartenaireBprice> partenaireBprice){
        return partenaireBpriceService.CreateManyPartenaireBprice(partenaireBprice);
    }

    @DeleteMapping("/DeletePartenaireBprice/{idPartenaireBprice}")
    @ApiOperation(value = "Supprimer un PartenaireBprice", notes = "Retourner une valeur boolean qui indique si le PartenaireBprice a été supprimé ou non.\n"
            + "\n<b>result = 1 :</b> objet supprimé avec succes</b> \n"
            + "\n<b>result = -1 :</b>PartenaireBprice n'exist pas\n"
            + "\n<b>result = -3 :</b> Query failed\n"
            + "\n<b>result = 401 :</b> TOKEN NOT AUTHORIZED\n"
            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object DeleteUtilistaeur(HttpServletRequest request,@PathVariable("idPartenaireBprice") String idPartenaireBprice){
        return partenaireBpriceService.DeletePartenaireBprice(idPartenaireBprice);
    }


    @GetMapping("/findByIdPartenaire/{idPartenaire}")
    @ApiOperation(value = "Afficher l'PointVente selon le PartenaireBprice envoyer", notes = "Retourner le PointVente selon l'idPartenaireBprice envoyer\n"
            + "\n<b>result = 1 :</b> List PartenaireBprice n'est pas vide</b> \n"
            + "\n<b>result = 0 :</b>Id est vide\n"
            + "\n<b>result = -1 :</b>PartenaireBprice n'exist pas\n"
            + "\n<b>result = -3 :</b> Query failed\n"
            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findByIdPartenaire(HttpServletRequest request,@PathVariable("idPartenaire") String idPartenaire){
        return partenaireBpriceService.findByIdPartenaire(idPartenaire);
    }
    @GetMapping("/findAllPartenaireBpriceByFActif/{factif}")
    @ApiOperation(value = "Afficher la liste de tous les PartenaireBprices par FActif", notes = "Retourner la liste de tous les PartenaireBprices par FActif.\n"
            + "\n<b>result = 1 :</b> List PartenaireBprice n'est pas vide</b> \n"
            + "\n<b>result = 0 :</b>List PartenaireBprice est vide\n"
            + "\n<b>result = -2 :</b>le parametre envoyer est null\n"
            + "\n<b>result = -3 :</b> Query failed\n"
            + "\n<b>result = 401 :</b> TOKEN NOT AUTHORIZED\n"
            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllByFActif(HttpServletRequest request,@PathVariable("factif") Short factif){
        return partenaireBpriceService.findAllByFActif(factif);
    }



    @GetMapping("/findAllPartenaireBpriceByFActif")
    @ApiOperation(value = "Afficher la liste de tous les PartenaireBprices par FActif", notes = "Retourner la liste de tous les PartenaireBprices par FActif.\n"
            + "\n<b>result = 1 :</b> List PartenaireBprice n'est pas vide</b> \n"
            + "\n<b>result = 0 :</b>List PartenaireBprice est vide\n"
            + "\n<b>result = -2 :</b>le parametre envoyer est null\n"
            + "\n<b>result = -3 :</b> Query failed\n"
            + "\n<b>result = 401 :</b> TOKEN NOT AUTHORIZED\n"
            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllByFActif2(HttpServletRequest request){
        return partenaireBpriceService.findAllByFActif((short) 1);
    }

//    @GetMapping("/findAllByIdSector/{idSector}")
//    @ApiOperation(value = "Afficher la liste de tous les PartenaireBprices par IdSector", notes = "Retourner la liste de tous les PartenaireBprices par IdSector.\n"
//            + "\n<b>result = 1 :</b> List PartenaireBprice n'est pas vide</b> \n"
//            + "\n<b>result = 0 :</b>List PartenaireBprice est vide\n"
//            + "\n<b>result = -2 :</b>le parametre envoyer est null\n"
//            + "\n<b>result = -3 :</b> Query failed\n"
//            + "\n<b>result = 401 :</b> TOKEN NOT AUTHORIZED\n"
//            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
//            @Authorization(value = "Bearer") }, response = Object.class)
//    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
//            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
//            @ApiResponse(code = 404, message = "not found") })
//    public Object findAllByIdSector(HttpServletRequest request,@PathVariable("idSector") String idSector){
//        return partenaireBpriceService.findAllByIdSector(idSector);
//    }

    @GetMapping("/findAllByIdVille/{idVille}")
    @ApiOperation(value = "Afficher la liste de tous les PartenaireBprices par IdVille", notes = "Retourner la liste de tous les PartenaireBprices par IdVille.\n"
            + "\n<b>result = 1 :</b> List PartenaireBprice n'est pas vide</b> \n"
            + "\n<b>result = 0 :</b>List PartenaireBprice est vide\n"
            + "\n<b>result = -2 :</b>le parametre envoyer est null\n"
            + "\n<b>result = -3 :</b> Query failed\n"
            + "\n<b>result = 401 :</b> TOKEN NOT AUTHORIZED\n"
            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllByIdVille(HttpServletRequest request,@PathVariable("idVille")String idVille){
        return partenaireBpriceService.findAllByIdVille(idVille);
    }

//    @GetMapping("/findAllByIdSectorAndFActif/{idSector}/{factif}")
//    @ApiOperation(value = "Afficher la liste de tous les PartenaireBprices par IdSector et FActif", notes = "Retourner la liste de tous les PartenaireBprices par IdSector et FActif.\n"
//            + "\n<b>result = 1 :</b> List PartenaireBprice n'est pas vide</b> \n"
//            + "\n<b>result = 0 :</b>List PartenaireBprice est vide\n"
//            + "\n<b>result = -2 :</b>le parametre envoyer est null\n"
//            + "\n<b>result = -3 :</b> Query failed\n"
//            + "\n<b>result = 401 :</b> TOKEN NOT AUTHORIZED\n"
//            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
//            @Authorization(value = "Bearer") }, response = Object.class)
//    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
//            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
//            @ApiResponse(code = 404, message = "not found") })
//    public Object findAllByIdSectorAndFActif(HttpServletRequest request,@PathVariable("idSector") String idSector,@PathVariable("factif")Short factif){
//        return partenaireBpriceService.findAllByIdSectorAndFActif(idSector,factif);
//    }

    @GetMapping("/findAllByIdVilleAndFActif/{idVille}/{factif}")
    @ApiOperation(value = "Afficher la liste de tous les PartenaireBprices par idVille et factif ", notes = "Retourner la liste de tous les PartenaireBprices par idVille et factif.\n"
            + "\n<b>result = 1 :</b> List PartenaireBprice n'est pas vide</b> \n"
            + "\n<b>result = 0 :</b>List PartenaireBprice est vide\n"
            + "\n<b>result = -2 :</b>le parametre envoyer est null\n"
            + "\n<b>result = -3 :</b> Query failed\n"
            + "\n<b>result = 401 :</b> TOKEN NOT AUTHORIZED\n"
            + "\n<b>result = 402 :</b> TOKEN MISSING.", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllByIdVilleAndFActif(HttpServletRequest request,@PathVariable("idVille") String idVille,@PathVariable("factif")Short factif){
        return partenaireBpriceService.findAllByIdVilleAndFActif(idVille, factif);
    }

    @GetMapping("/findAllWithPointVentesByFActifDTO/{idActionMarketing}")
    @ApiOperation(value = "Afficher l' Action Marketing DTO selon l'idPartenaire et le date range envoyer", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findAllWithPointVentesByFActifDTO(HttpServletRequest request,@PathVariable("idActionMarketing") String idActionMarketing){
        return  partenaireBpriceService.entityToDto(idActionMarketing,(short)1);
    }
}
