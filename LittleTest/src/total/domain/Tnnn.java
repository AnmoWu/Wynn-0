package total.domain;

class BalanceNotEnoughException  extends Exception{
    public BalanceNotEnoughException () {
        super();
    }
    public BalanceNotEnoughException (String message) {
        super(message);
    }
}

class BankCount {
    private double account;
    public void setAccount(int account) {
        this.account=account;
    }
    public double getAccount() {
        return this.account;
    }
    public void show(int x) throws BalanceNotEnoughException {
        if(account>=x) {
            account-=x;
            System.out.println("取款成功！取出"+x+"元，账户余额为"+account+"元");
        }else {
            throw new BalanceNotEnoughException ("您的余额不足，取款失败！");
        }
    }
}
