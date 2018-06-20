package com.sedgwick.algorithms.model;

import lombok.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Transaction implements Comparable<Transaction> {

    private String who;
    private Date when;
    private double amount;

    public Transaction(String transaction) {
        String[] splittedValues = transaction.split(" ");
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        this.who = splittedValues[0];
        try {
            this.when = dateFormat.parse(splittedValues[1]);
        } catch (ParseException e) {
            throw new IllegalStateException(e);
        }
        this.amount = Double.parseDouble(splittedValues[2]);
    }

    @Override
    public int compareTo(Transaction o) {
        return Double.compare(this.amount, o.amount);
    }
}
