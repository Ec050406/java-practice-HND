public class account {
    private String accountName;
    private double accountNumber;
    private double accountBalance;

    public account(String accountName, double accountNumber, double accountBalance) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public void setAccountNumber(double accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
        }
        else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Name: " + accountName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Balance: " + accountBalance);
    }

   
}