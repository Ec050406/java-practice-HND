public class HumanUser {

    private int name;
    private int bankCard;
    private int pinNumber;
    private int checkingAccount;
    private int savingAccount;

    private BankBranch bankBranch;

    public HumanUser(
            int name,
            int bankCard,
            int pinNumber,
            int checkingAccount,
            int savingAccount,
            BankBranch bankBranch) {

        this.name = name;
        this.bankCard = bankCard;
        this.pinNumber = pinNumber;
        this.checkingAccount = checkingAccount;
        this.savingAccount = savingAccount;
        this.bankBranch = bankBranch;
    }

    public void Balance() {
        System.out.println("Checking Account: " + checkingAccount);
        System.out.println("Saving Account: " + savingAccount);
    }

    public void WithdrawFunds(int amount) {
        if (amount <= checkingAccount) {
            checkingAccount -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Remaining balance: " + checkingAccount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void DepositFunds(int amount) {
        checkingAccount += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("New balance: " + checkingAccount);
    }

    public void TransferFunds(int amount) {
        if (amount <= checkingAccount) {
            checkingAccount -= amount;
            savingAccount += amount;

            System.out.println("Transferred: " + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public int getName() {
        return name;
    }

    public int getBankCard() {
        return bankCard;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public int getCheckingAccount() {
        return checkingAccount;
    }

    public int getSavingAccount() {
        return savingAccount;
    }
}
