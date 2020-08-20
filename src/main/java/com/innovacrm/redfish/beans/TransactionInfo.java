package com.innovacrm.redfish.beans;

import java.util.Map;

public class TransactionInfo {

    private Transaction[] booked;

    private Transaction[] pending;

    private Transaction[] info;

    private Map<String, Link> links;

    public Transaction[] getBooked() {
        return booked;
    }

    public void setBooked(Transaction[] booked) {
        this.booked = booked;
    }

    public Transaction[] getPending() {
        return pending;
    }

    public void setPending(Transaction[] pending) {
        this.pending = pending;
    }

    public Transaction[] getInfo() {
        return info;
    }

    public void setInfo(Transaction[] info) {
        this.info = info;
    }

    public Map<String, Link> getLinks() {
        return links;
    }

    public void setLinks(Map<String, Link> links) {
        this.links = links;
    }
}
