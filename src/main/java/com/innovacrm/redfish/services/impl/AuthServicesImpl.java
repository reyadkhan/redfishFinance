package com.innovacrm.redfish.services.impl;

import com.innovacrm.redfish.beans.Credential;
import com.innovacrm.redfish.restServices.ing.CredentialRestServices;
import com.innovacrm.redfish.services.AuthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServicesImpl implements AuthServices {

    @Autowired
    private CredentialRestServices restServices;

    @Override
    public Credential getToken(String userEmail, String userPass) {
        return restServices.fetchCredential(userEmail, userPass);
    }
}
