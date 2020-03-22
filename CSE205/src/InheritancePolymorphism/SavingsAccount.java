// CSE 205: 11333 | Tue/Thu 4:30 PM
// Assignment: One Inheritance & Polymorphism
// Author: Joseph H Cottingham | 1216723703
// Description: Class used to
// create savings account object.

package InheritancePolymorphism;

public class SavingsAccount extends BankAccount {
    public SavingsAccount() {
        super();
    }
    @Override
    public boolean debit(int amount) {
        if (amount > super.balance){
            return false;
        }
        super.balance -= amount;
        return true;
    }
    @Override
    public void applyInterest() {
        super.balance += (int)(super.balance * super.interestRate);
    }
    @Override
    public String getAccountInfo() {
        return (String.format("Account type  : Savings\nAccount #     : %s\nBalance       : $%.2f\nInterest rate : %.2f%%",super.accountNumber, (super.balance/100.00), (super.interestRate*100.00)));
    }
}