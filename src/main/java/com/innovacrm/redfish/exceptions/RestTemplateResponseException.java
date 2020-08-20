package com.innovacrm.redfish.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.URI;

@Component
public class RestTemplateResponseException implements ResponseErrorHandler {

    private final Logger logger = LoggerFactory.getLogger(RestTemplateResponseException.class);

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {

        return response.getStatusCode().series().equals(HttpStatus.Series.SERVER_ERROR)
                || response.getStatusCode().series().equals(HttpStatus.Series.CLIENT_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        throw new ResponseStatusException(response.getStatusCode(), response.getStatusText());
    }

    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {
        if(response.getStatusCode().series().equals(HttpStatus.Series.SERVER_ERROR)) {

            logger.error("Server error occurred during rest template response. Request url: {}, method: {}, status code: {}, status text: {}. Response body: {}", url, method, response.getStatusCode(), response.getStatusText(), response.getBody());

        } else {
            logger.error("Client error occurred during rest template response. Request url: {}, method: {}, status code: {}, status text: {}. Response body: {}.", url, method, response.getStatusCode(), response.getStatusText(), response.getBody());
        }
        handleError(response);
    }
}
