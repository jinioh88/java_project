package com.example.java_project;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer) {
        double result = 0;

        for(final BankTransaction bankTransaction : bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }

        return result;
    }

    public double calculateTotalAmount() {
        double total = 0L;

        for(BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }

        return total;
    }

    public double calculateTotalInMonth(final Month month) {
        return summarizeTransactions((acc, bankTransaction) ->
                bankTransaction.getDate().getMonth() == month ? acc + bankTransaction.getAmount() : acc);
    }

    public double calculateTotalForCategory(final String category) {
        double total = 0;

        for(final BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }

        return total;
    }

    public List<BankTransaction> findTransactionsGreaterHanEqual(final int amount) {
        return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
    }

    public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
        final List<BankTransaction> result = new ArrayList<>();

        for(final BankTransaction bankTransaction : bankTransactions) {
            if(bankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }

        return result;
    }

}
