package com.innovacrm.redfish.controllers;

import com.innovacrm.redfish.beans.Credential;
import com.innovacrm.redfish.dto.AuthCredential;
import com.innovacrm.redfish.services.AuthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@RestApiController
public class AuthController {

    @Autowired
    AuthServices services;

    @PostMapping(value = "/auth/token")
    public Credential getToken(@Valid @RequestBody AuthCredential authCredential) {
        return services.getToken(authCredential.getEmail(), authCredential.getPassword());
    }
}
