package com.payload.request;

public class AuthenticationRequest {

    private String clientName;
    private String clientEmail;

    public AuthenticationRequest() {

    }

    public AuthenticationRequest(String clientName, String clientEmail) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    @Override
    public String toString() {
        return "AuthenticationRequest{" +
                "clientName=" + clientName +
                ", clientEmail=" + clientEmail +
                "}";
    }
}