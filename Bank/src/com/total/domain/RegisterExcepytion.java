package com.total.domain;

public class RegisterExcepytion extends Exception{
    RegisterExcepytion(Account acc){
        acc.setPassword()==acc.getPassword();
    }
    public String NamePassword() {
        return "两次密码输入不一致";
    }
}
