public interface ATM_Machine {

    int Bank_Account = 0;
    int Log_In = 0;
    int Log_Out = 0;
    int Bank_Branch = 0;

    void ReadBankCard();

    void PrintsReceipt();

    void DispenseCash();

    void AccessBankCheck();

    void CalculateFunds();
}
