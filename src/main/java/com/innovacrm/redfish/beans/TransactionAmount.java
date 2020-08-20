package com.innovacrm.redfish.beans;

import com.innovacrm.redfish.enums.Currency;

public class TransactionAmount {

    private Double amount;

    private Currency currency;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
