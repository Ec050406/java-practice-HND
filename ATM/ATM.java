public class ATM implements ATM_Machine {

    private HumanUser user;
    private BankBranch bankBranch;

    public ATM(HumanUser user, BankBranch bankBranch) {
        this.user = user;
        this.bankBranch = bankBranch;
    }

    @Override
    public void ReadBankCard() {
        System.out.println("Reading bank card...");
    }

    @Override
    public void PrintsReceipt() {
        System.out.println("Printing receipt...");
    }

    @Override
    public void DispenseCash() {
        System.out.println("Dispensing cash...");
    }

    @Override
    public void AccessBankCheck() {
        System.out.println("Accessing bank account...");
    }

    @Override
    public void CalculateFunds() {
        System.out.println("Calculating funds...");
        user.Balance();
    }

    public void login(int pin) {
        if (user.getPinNumber() == pin) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Incorrect PIN.");
        }
    }

    public void logout() {
        System.out.println("Logged out.");
    }
}
