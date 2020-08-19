package com.innovacrm.redfish.controllers;

import com.innovacrm.redfish.beans.TransactionInfo;
import com.innovacrm.redfish.services.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestApiController
public class TransactionsController {

    @Autowired
    private TransactionServices services;

    @GetMapping(value = "/transactions", params = "account")
    public TransactionInfo transactions(String account) {
        return services.getTransactions(account);
    }
}
