package com.example.java_project;

import java.util.List;

public interface BankStatementParser {
    BankTransaction parseFrom(String line);
    List<BankTransaction> parseLineFrom(List<String> lines);
}
