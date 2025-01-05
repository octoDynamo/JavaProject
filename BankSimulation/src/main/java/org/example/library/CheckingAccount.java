package org.example.library;

class CheckingAccount extends Account {
    public CheckingAccount(String accountHolder, double initialBalance) {
        super(accountHolder, initialBalance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= balance) {
            balance -= amount;
            recordTransaction("Withdrew from Checking: " + amount);
        } else {
            throw new InsufficientFundsException("Insufficient funds in Checking Account.");
        }
    }
}
