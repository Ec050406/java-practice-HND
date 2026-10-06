public class BankBranch {

    private int branchName;
    private int checkingAccount;
    private int savingAccount;

    public BankBranch(int branchName, int checkingAccount, int savingAccount) {
        this.branchName = branchName;
        this.checkingAccount = checkingAccount;
        this.savingAccount = savingAccount;
    }

    public void MaintenanceAccount() {
        System.out.println("Maintaining bank account...");
    }

    public int getBranchName() {
        return branchName;
    }

    public int getCheckingAccount() {
        return checkingAccount;
    }

    public int getSavingAccount() {
        return savingAccount;
    }
}
