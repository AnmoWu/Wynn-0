package total.domain;

public class LoanException extends Exception {
    Account acc;
    LoanException(Account acc){
        acc.setBalance()>0;
    }
    public String Loan(){
        return "������Ϊ��ֵ";
    }
}
