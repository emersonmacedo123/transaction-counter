package com.codecoo.transactioncounter;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        final TransactionReader reader = new TransactionReader();
        final TransactionDisplayer displayer = new TransactionDisplayer();
        displayer.displayTransactions(reader.readTransactions());
    }
}
