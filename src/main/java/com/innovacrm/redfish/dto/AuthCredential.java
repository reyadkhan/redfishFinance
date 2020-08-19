package com.innovacrm.redfish.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AuthCredential {

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 4, max = 50)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthCredential{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
