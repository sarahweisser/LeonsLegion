package com.leonslegion.casino;

import java.util.ArrayList;

/**
 * Created by sarahweisser on 5/9/17.
 */
public class AccountManager {

    private ArrayList<Account> accounts = new ArrayList<Account>();

    public String showBalance(Account account) {
        return account.toString();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public double getBalance(Account account) {
        return account.getAccountBalance();
    }



}
