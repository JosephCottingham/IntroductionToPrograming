// CSE 205: 11333 | Tue/Thu 4:30 PM
// Assignment: One Inheritance & Polymorphism
// Author: Joseph H Cottingham | 1216723703
// Description: Class used to
// create checking account object.

package InheritancePolymorphism;

public class CheckingAccount extends BankAccount{
    private int overdraftFee;
    public CheckingAccount() {
        super();
    }
    @Override
    public boolean debit(int amount){
        super.balance -= amount;
        if (super.balance < 0){
            super.balance -= this.overdraftFee;
        }
        return true;
    }

    public int getOverdraftFee(){
        return this.overdraftFee;
    }

    public void setOverdraftFee(int overdraftFee){
        this.overdraftFee = overdraftFee;
    }
    @Override
    public void applyInterest(){
        if (super.balance > 0) super.balance += (int)(super.balance * interestRate);
    }

    @Override
    public String getAccountInfo(){
        return (String.format("Account type  : Checking\nAccount #     : %s\nBalance       : $%.2f\nInterest rate : %.2f%%\nOverdraft fee : $%.2f",super.accountNumber, (super.balance/100.00), (super.interestRate*100.00),(overdraftFee/100.00)));
    }

}
