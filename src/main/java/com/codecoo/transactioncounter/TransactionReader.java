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

        final List<Transaction> csvTransactionsList = new ArrayList<>();

        //file 1
        final Path csvTransactions = Paths.get("src/main/resources/transactions1.csv");
        addItemsCSVToList(csvTransactions, csvTransactionsList);
        //file 2
        final Path csvTransactions2 = Paths.get("src/main/resources/transactions2.csv");
        addItemsCSVToList(csvTransactions2, csvTransactionsList);
        //file 3
        final Path jsonTransactions = Paths.get("src/main/resources/transactions3.json");
        addItemJsonToList(jsonTransactions,csvTransactionsList);

        return csvTransactionsList;
    }


    private void addItemsCSVToList (Path csvTransactions, List<Transaction> csvTransactionsList ) throws IOException {
        final List<String> csvTransactionsStrings = Files.readAllLines(csvTransactions);
        for (String str : csvTransactionsStrings) {
            final String[] split = str.split(",");
            csvTransactionsList.add(new Transaction(split[0], Integer.parseInt(split[1])));
        }

    }

    private void addItemJsonToList(Path jsonTransactions, List<Transaction> csvTransactionsList) throws IOException {
        final String jsonTransactionsString = Files.readString(jsonTransactions);
        Type listType = new TypeToken<List<Transaction>>() {}.getType();
        final List<Transaction> jsonTransactions3 = new Gson().fromJson(jsonTransactionsString, listType);
        csvTransactionsList.addAll(jsonTransactions3);
    }


}
