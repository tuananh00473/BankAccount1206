package com.qsoft;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 6/12/13
 * Time: 9:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountDTO {
    private String accountNumber;
    private double balance;
    private Date openTimestamp;

    public BankAccountDTO() {
    }

    public BankAccountDTO(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.openTimestamp = new Date();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }

    public Date getOpenTimestamp() {
        return openTimestamp;
    }

        @Override
        public boolean equals(Object o){
            if(o instanceof BankAccountDTO){
                BankAccountDTO bankAccountDTO = (BankAccountDTO) o;
                if(bankAccountDTO.getAccountNumber().equals(accountNumber) &&  bankAccountDTO.getBalance() < balance + 0.000001)
                    return true;
                return false;
            }
            return false;
        }
}
