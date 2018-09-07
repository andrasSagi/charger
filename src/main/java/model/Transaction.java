package model;

import java.util.Calendar;

class Transaction {

    private TransactionType type;
    private double amount;
    private double balance;
    private int year;
    private int month;
    private int day;

    Transaction(TransactionType type, double amount, double balance) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
    }
}
