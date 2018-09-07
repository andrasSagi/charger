package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class User {

    private BigDecimal balance;
    private List<Transaction> transactionHistory = new ArrayList<>();

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    BigDecimal getBalance() {
        return balance;
    }

    User(BigDecimal account) {
        balance = account;
    }

    void deposit(BigDecimal amount) {
        balance = balance.add(amount.abs());
        Transaction transaction = new Transaction(TransactionType.DEPOSIT, amount, balance);
        transactionHistory.add(transaction);
    }

    void withdraw(BigDecimal amount) {
        balance = balance.subtract(amount.abs());
        Transaction transaction = new Transaction(TransactionType.WITHDRAW, new BigDecimal(0).subtract(amount.abs()), balance);
        transactionHistory.add(transaction);
    }

    void transferTo(User receiver, BigDecimal amount) {
        balance = balance.subtract(amount.abs());
        receiver.receiveTransfer(amount);
        Transaction transaction = new Transaction(TransactionType.TRANSFER,  new BigDecimal(0).subtract(amount.abs()), balance);
        transactionHistory.add(transaction);
    }

    private void receiveTransfer(BigDecimal amount) {
        balance = balance.add(amount.abs());
        Transaction transaction = new Transaction(TransactionType.TRANSFER, amount, balance);
        transactionHistory.add(transaction);
    }

    public void printTransactionHistory() {
        for (Transaction transaction: transactionHistory) {
            System.out.println(transaction.toString());
        }
    }

    public List<Transaction> filterByTransactionsByType(TransactionType type) {
        List<Transaction> filteredHistory = new ArrayList<>();
        for (Transaction transaction: transactionHistory) {
            if (transaction.getType().equals(type)) {
                filteredHistory.add(transaction);
            }
        }
        return filteredHistory;
    }

    public List<Transaction> filterTransactionsByDate(int day, int month, int year) {
        List<Transaction> filteredHistory = new ArrayList<>();
        for (Transaction transaction: transactionHistory) {
            if (transaction.getYear() == year &&
                    transaction.getMonth() == month &&
                    transaction.getDay() == day) {
                filteredHistory.add(transaction);
            }
        }
        return filteredHistory;
    }
}
