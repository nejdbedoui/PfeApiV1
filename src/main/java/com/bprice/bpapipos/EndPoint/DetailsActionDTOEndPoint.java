package com.bprice.bpapipos.EndPoint;

import com.bprice.bpapipos.dto.DetailsActionDTO;
import com.bprice.bpapipos.service.IDetailsActionDTOService;
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
public class DetailsActionDTOEndPoint {
    @Autowired
    IDetailsActionDTOService iDetailsActionDTOService;


    @PostMapping("/findDetailsByAction")
    @ApiOperation(value = "créer une Categorie", authorizations = {
            @Authorization(value = "Bearer") }, response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    public Object findDetailsByAction(HttpServletRequest request, @RequestBody @Valid ActionMarketing actionMarketing){
        return iDetailsActionDTOService.findDetailsByAction(actionMarketing);
    }
}
