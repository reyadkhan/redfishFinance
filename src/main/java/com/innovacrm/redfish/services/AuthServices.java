package com.innovacrm.redfish.services;

import com.innovacrm.redfish.beans.Credential;

public interface AuthServices {

    public Credential getToken(String userCredential, String userPass);
}
