package model;

import java.math.BigDecimal;
import java.util.Calendar;

class Transaction {

    private TransactionType type;
    private BigDecimal amount;
    private BigDecimal balance;
    private int year;
    private int month;
    private int day;

    TransactionType getType() {
        return type;
    }

    int getYear() {
        return year;
    }

    int getMonth() {
        return month;
    }

    int getDay() {
        return day;
    }

    Transaction(TransactionType type, BigDecimal amount, BigDecimal balance) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public String toString() {
        return day + "." + month + "." + year + "." +
             "\n    " + type + "\n    Changes to balance: " + amount +
             "\n    " + "Balance after exchange: " + balance;
    }
}
