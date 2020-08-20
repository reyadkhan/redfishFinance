package com.innovacrm.redfish.restServices.ing;

import com.innovacrm.redfish.beans.TransactionInfo;

public interface TransactionRestServices {

    public TransactionInfo fetchAllTransactions(String accountId);
}
