package com.innovacrm.redfish.restServices.ing.impl;

import com.innovacrm.redfish.beans.Credential;
import com.innovacrm.redfish.exceptions.RestTemplateResponseException;
import com.innovacrm.redfish.properties.IngApiProperties;
import com.innovacrm.redfish.restServices.ing.CredentialRestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.io.File;
import java.util.Collections;

@Component
public class CredentialRestServicesImpl extends RestServices implements CredentialRestServices {

    final String requestPath = "oauth2/token";

    @Autowired
    @Override
    public void init(RestTemplateBuilder templateBuilder, IngApiProperties apiProperties) {
        client = templateBuilder.errorHandler(new RestTemplateResponseException()).build();
        this.apiProperties = apiProperties;
        final String baseUrl = apiProperties.getBaseUrl();
        client.setUriTemplateHandler(new DefaultUriBuilderFactory(baseUrl));
    }

    @Override
    public Credential fetchCredential(String userEmail, String userPass) {
        return client.postForObject(requestPath, getEntity(userEmail, userPass), Credential.class);
    }

    /**
     * Http entity
     *
     * @param userEmail
     * @param userPass
     * @return HttpEntity
     */
    private HttpEntity<String> getEntity(String userEmail, String userPass) {
        final String payload = "grant_type=" + userEmail;
        final String digest = "SHA-256=" + payload +
                "| openssl dgst -binary -sha256 | openssl base64";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Digest", digest);

        long reqDate = headers.getDate();
        final String signingString = "(request-target):POST " + requestPath + "\n"
                + "date: " + reqDate + "\n"
                + "digest: " + digest;
        final String certDirectory = apiProperties.getCertsDir();
        final String certName = apiProperties.getCertName();
        final String certificate = certDirectory + File.separator + certName + ".cer";
        final String key = certDirectory + File.separator + certName + ".key";
        final String signature = signingString + " | openssl dgst -sha256 -sign "
                + certificate + " -passin pass:" + userPass + " | openssl base64";
        final String authString = "Signature keyId=" + apiProperties.getClientId()
                + ",algorithm=rsa-sha256,headers=(request-target) date digest,signature=" + signature;

        headers.setBasicAuth(authString);
        headers.add("--cert", certificate);
        headers.add("--key", key);

       return new HttpEntity<>(payload, headers);
    }
}
