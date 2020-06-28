package com.example.java_project;

import lombok.*;

import java.time.LocalDate;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BankTransaction {
    private LocalDate date;
    private double amount;
    private String description;
}
