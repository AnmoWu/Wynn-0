package total.domain;

public class BlanceNotEnoughException extends Exception{
    BlanceNotEnoughException(Account acc){
        acc.getBalance()>acc.calcTotalBalance()
    }
    public String Blance(){
        return "Óà¶î²»×ã";
    }
}

