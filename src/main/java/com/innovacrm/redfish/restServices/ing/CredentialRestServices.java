package com.innovacrm.redfish.restServices.ing;

import com.innovacrm.redfish.beans.Credential;

public interface CredentialRestServices {

    public Credential fetchCredential(String userEmail, String userPass);
}
