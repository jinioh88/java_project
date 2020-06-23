package com.example.java_project;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
@EqualsAndHashCode
public class BankTransaction {
    private final LocalDate date;
    private final double amount;
    private final String description;
}
