package com.codecoo.transactioncounter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TransactionReader {

    public List<Transaction> readTransactions() throws IOException {
        final Path csvTransactions = Paths.get("src/main/resources/transactions1.csv");
        final List<String> csvTransactionsStrings = Files.readAllLines(csvTransactions);
        final List<Transaction> csvTransactionsList = new ArrayList<>();
        for (String str : csvTransactionsStrings) {
            final String[] split = str.split(",");
            csvTransactionsList.add(new Transaction(split[0], Integer.parseInt(split[1])));
        }

        final Path csvTransactions2 = Paths.get("src/main/resources/transactions2.csv");
        final List<String> csvTransactions2Strings = Files.readAllLines(csvTransactions2);
        final List<Transaction> csvTransactions2List = new ArrayList<>();
        for (String str : csvTransactions2Strings) {
            final String[] split = str.split(",");
            csvTransactions2List.add(new Transaction(split[0], Integer.parseInt(split[1])));
        }

        final Path jsonTransactions = Paths.get("src/main/resources/transactions3.json");
        final String jsonTransactionsString = Files.readString(jsonTransactions);
        Type listType = new TypeToken<List<Transaction>>() {}.getType();
        final List<Transaction> jsonTransactions3 = new Gson().fromJson(jsonTransactionsString, listType);

        final List<Transaction> transactions = new ArrayList<>();
        transactions.addAll(csvTransactionsList);
        transactions.addAll(csvTransactions2List);
        transactions.addAll(jsonTransactions3);
        return transactions;
    }
}
