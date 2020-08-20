package com.innovacrm.redfish.services.impl;

import com.innovacrm.redfish.beans.TransactionInfo;
import com.innovacrm.redfish.restServices.ing.TransactionRestServices;
import com.innovacrm.redfish.services.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServicesImpl implements TransactionServices {

    @Autowired
    private TransactionRestServices restServices;

    @Override
    public TransactionInfo getTransactions(String accountId) {
        return restServices.fetchAllTransactions(accountId);
    }
}
