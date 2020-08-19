package com.innovacrm.redfish.restServices.ing.impl;

import com.innovacrm.redfish.exceptions.RestTemplateResponseException;
import com.innovacrm.redfish.properties.IngApiProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

public class RestServices {

    IngApiProperties apiProperties;

    RestTemplate client;

    @Autowired
    public void init(RestTemplateBuilder templateBuilder, IngApiProperties apiProperties) {
        client = templateBuilder.errorHandler(new RestTemplateResponseException()).build();
        this.apiProperties = apiProperties;
        final String url;
        final String baseUrl = apiProperties.getBaseUrl();
        final String version = apiProperties.getVersion();

        if(baseUrl.endsWith("/")) {
            url = baseUrl + version;
        } else {
            url = baseUrl + "/" + version;
        }
        client.setUriTemplateHandler(new DefaultUriBuilderFactory(url));
    }
}
