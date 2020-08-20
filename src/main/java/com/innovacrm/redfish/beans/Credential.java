package com.innovacrm.redfish.beans;

import java.util.Map;

public class Credential {

    private String access_token;

    private Long expire_in;

    private Map<String, String> scope;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Long getExpire_in() {
        return expire_in;
    }

    public void setExpire_in(Long expire_in) {
        this.expire_in = expire_in;
    }

    public Map<String, String> getScope() {
        return scope;
    }

    public void setScope(Map<String, String> scope) {
        this.scope = scope;
    }
}
