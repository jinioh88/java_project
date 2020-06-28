package com.example.java_project;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class BankTransaction {
    private LocalDate date;
    private double amount;
    private String description;
}
