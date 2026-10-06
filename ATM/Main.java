public class Main {

    public static void main(String[] args) {

        BankBranch branch = new BankBranch(
                1,
                1000,
                500
        );

        HumanUser user = new HumanUser(
                123,       // Name
                456789,    // Bank Card
                1234,      // PIN
                1000,      // Checking Account
                500,       // Saving Account
                branch
        );

        ATM atm = new ATM(user, branch);

        atm.ReadBankCard();

        atm.login(1234);

        atm.CalculateFunds();

        user.DepositFunds(200);

        user.WithdrawFunds(300);

        user.TransferFunds(100);

        atm.PrintsReceipt();

        atm.DispenseCash();

        atm.logout();
    }
}
