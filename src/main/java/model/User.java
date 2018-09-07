package model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private double account;
    private List<Transaction> transactions = new ArrayList<>();

    public User(double account) {
        this.account = account;
    }

}
