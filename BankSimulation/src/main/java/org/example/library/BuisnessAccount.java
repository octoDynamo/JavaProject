package org.example.library;

class BusinessAccount extends Account {
    private static final double TRANSACTION_FEE = 5.0;

    public BusinessAccount(String accountHolder, double initialBalance) {
        super(accountHolder, initialBalance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        double totalAmount = amount + TRANSACTION_FEE;
        if (totalAmount <= balance) {
            balance -= totalAmount;
            recordTransaction("Withdrew from Business with fee: " + amount + " + Fee: " + TRANSACTION_FEE);
        } else {
            throw new InsufficientFundsException("Insufficient funds in Business Account for withdrawal and fee.");
        }
    }
}
