// CSE 205: 11333 | Tue/Thu 4:30 PM
// Assignment: One Inheritance & Polymorphism
// Author: Joseph H Cottingham | 1216723703
// Description: Abstract class used to
// create any type of account.

package InheritancePolymorphism;

public abstract class BankAccount {
    protected String accountNumber = "0000-0000-0000-0000";
    protected double interestRate = 0;
    protected int balance = 0;

    public boolean credit(int amount) {
        balance += amount;
        return true;
        //TODO What is the point of this return?
    }

    public abstract boolean debit(int amount);

    public int getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public abstract void applyInterest();

    public abstract String getAccountInfo();

}