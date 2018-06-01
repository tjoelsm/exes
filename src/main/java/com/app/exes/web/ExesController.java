package com.app.exes.web;


import com.app.exes.entities.dao.SegPersonas;
import com.app.exes.service.services.SegPersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/exes")
public class ExesController {

    @Autowired
    SegPersonasService personasService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getName(@RequestParam(name="name") String name) {
        return new ResponseEntity<>(name,HttpStatus.OK);
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
