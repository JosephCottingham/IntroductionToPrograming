// CSE 205: 11333 | Tue/Thu 4:30 PM
// Assignment: One Inheritance & Polymorphism
// Author: Joseph H Cottingham | 1216723703
// Description: Class used to
// create credit card account object.

package InheritancePolymorphism;

public class CreditcardAccount extends BankAccount {
    private int creditLimit;

    public CreditcardAccount() {
        super();
    }

    @Override
    public boolean debit(int amount){
        if (amount > (super.balance + this.creditLimit)) return false;
        super.balance -= amount;
        return true;
    }

    public int getCreditLimit(){
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public void applyInterest(){
        if (super.balance < 0) super.balance += (int)(super.interestRate * super.balance);
    }

    @Override
    public String getAccountInfo() {
        return (String.format("Account type  : Creditcard\nAccount #     : %s\nBalance       : $%.2f\nInterest rate : %.2f%%\nCredit limit  : $%.2f",super.accountNumber, (super.balance/100.00), (super.interestRate*100.00),(creditLimit/100.00)));
    }
}
