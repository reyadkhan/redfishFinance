package com.innovacrm.redfish.services;

import com.innovacrm.redfish.beans.TransactionInfo;

public interface TransactionServices {

    public TransactionInfo getTransactions(String accountId);
}
