package com.innovacrm.redfish.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("ing.api")
public class IngApiProperties {

    private String baseUrl;

    private String version;

    private String certsDir;

    private String certName;

    private String clientId;

    public String getBaseUrl() {
        return baseUrl.trim();
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getVersion() {
        return version.trim();
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCertsDir() {
        return certsDir.trim();
    }

    public void setCertsDir(String certsDir) {
        this.certsDir = certsDir;
    }

    public String getCertName() {
        return certName.trim();
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
