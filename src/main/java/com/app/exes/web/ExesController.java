package com.app.exes.web;


import com.app.exes.entities.dao.GastosMensuales;
import com.app.exes.entities.dao.IngresoMesuales;
import com.app.exes.entities.dao.Meses;
import com.app.exes.entities.dao.SegPersonas;
import com.app.exes.service.services.GastosMensualesService;
import com.app.exes.service.services.IngresoMesualesService;
import com.app.exes.service.services.MesService;
import com.app.exes.service.services.SegPersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/exes")
public class ExesController {

    @Autowired
    SegPersonasService personasService;

    @Autowired
    GastosMensualesService gastosMensualesService;

    @Autowired
    IngresoMesualesService ingresoMesualesService;

    @Autowired
    MesService mesService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getNamePersonByEmail(@NotNull @RequestParam(name="email") String email) {
        SegPersonas result = personasService.findPersonByEmail(email);
        if(result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, value = "addUser")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> newUser(@RequestBody @Valid SegPersonas dataPerson, BindingResult error) {
        if (!error.hasErrors()) {
            int result = personasService.addNewUser(dataPerson);
            switch (result) {
                case 201:
                    return new ResponseEntity<>(HttpStatus.CREATED);
                case 404:
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                case 409:
                    return new ResponseEntity<>(HttpStatus.CONFLICT);
                default:
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(getErrors(error), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, value = "newBill")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> newBill(@RequestBody @Valid GastosMensuales bill, BindingResult error) {
        if (!error.hasErrors()) {
            int result = gastosMensualesService.addNewBill(bill);
            switch (result) {
                case 201:
                    return new ResponseEntity<>(HttpStatus.CREATED);
                case 404:
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                case 409:
                    return new ResponseEntity<>(HttpStatus.CONFLICT);
                default:
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(getErrors(error), HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, value = "newDeposit")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> newDeposit(@RequestBody @Valid IngresoMesuales deposit, BindingResult error) {
        if (!error.hasErrors()) {
            int result = ingresoMesualesService.addNewDeposit(deposit);
            switch (result) {
                case 201:
                    return new ResponseEntity<>(HttpStatus.CREATED);
                case 404:
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                case 409:
                    return new ResponseEntity<>(HttpStatus.CONFLICT);
                default:
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(getErrors(error), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "getMonths")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getMonths(@RequestParam(name="month") String mes) {
        Iterable<Meses> resultList = null;
        Meses result = null;
       if(mes!=null) {
           result = mesService.getMonthByName(mes);
       } else
       {
           resultList = mesService.getAllMonths();
       }
        if(result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else if (resultList != null) {
            return new ResponseEntity<>(resultList, HttpStatus.OK);
       } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private Map<String,String> getErrors(final BindingResult result) {
        return new HashMap<String,String>() {
            {
                for (FieldError error : result.getFieldErrors()) {
                    put(error.getField(), error.getDefaultMessage());
                }
            }
        };
    }

}
