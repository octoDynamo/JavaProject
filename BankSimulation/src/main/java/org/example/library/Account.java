package org.example.library;

abstract class Account implements BankingOperations, TransactionLog {
    protected String accountHolder;
    protected double balance;

    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            recordTransaction("Deposited: " + amount);
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void recordTransaction(String message) {
        System.out.println("Transaction: " + message);
    }
}
