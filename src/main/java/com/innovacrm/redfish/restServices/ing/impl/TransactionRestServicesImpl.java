package com.innovacrm.redfish.restServices.ing.impl;

import com.innovacrm.redfish.beans.TransactionInfo;
import com.innovacrm.redfish.restServices.ing.TransactionRestServices;
import org.springframework.stereotype.Component;

@Component
public class TransactionRestServicesImpl extends RestServices implements TransactionRestServices {

    @Override
    public TransactionInfo fetchAllTransactions(String accountId) {
        return client.getForObject("/accounts/" + accountId + "/transactions", TransactionInfo.class);
    }
}
