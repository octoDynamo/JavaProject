package org.example.library;

class SavingsAccount extends Account {
    public SavingsAccount(String accountHolder, double initialBalance) {
        super(accountHolder, initialBalance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= balance) {
            balance -= amount;
            recordTransaction("Withdrew from Savings: " + amount);
        } else {
            throw new InsufficientFundsException("Insufficient funds in Savings Account.");
        }
    }
}
