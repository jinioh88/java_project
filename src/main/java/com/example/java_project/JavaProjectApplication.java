package com.example.java_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

//@SpringBootApplication
public class JavaProjectApplication {

    public static void main(String[] args) throws IOException {
        final BankTransactionAnalyzer bankTransactionAnalyzer = new BankTransactionAnalyzer();

        final BankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankTransactionAnalyzer.analize("bank-data-simple.csv", bankStatementParser);
    }

}
