package com.example.java_project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

        final String fileName = args[0];
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLineFromCSV(lines);

        System.out.println("The total for all transactions is = " + calculateTotalAmount(bankTransactions));
        System.out.println("Transaction is January " + selectInMonth(bankTransactions, Month.JANUARY));
    }

    public static double calculateTotalAmount(List<BankTransaction> bankTransactions) {
        double total = 0L;

        for(BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }

        return total;
    }

    private static List<BankTransaction> selectInMonth(List<BankTransaction> bankTransactions, Month month) {
        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();

        for(final BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getDate().getMonth() == month) {
                bankTransactionsInMonth.add(bankTransaction);
            }
        }

        return bankTransactionsInMonth;
    }
}
