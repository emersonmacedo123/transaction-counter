package com.codecoo.transactioncounter;

import java.util.List;

// do not change this :)
public class TransactionDisplayer {
    public void displayTransactions(final List<Transaction> transactions) {
        for(Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
