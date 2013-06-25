package com.transaction;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 6/13/13
 * Time: 1:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionDTO
{
    private String accountNumber;
    private Date timestamp;
    private double amount;
    private String description;

    public TransactionDTO()
    {
    }

    public TransactionDTO(String accountNumber, double amount, String description)
    {
        this.accountNumber = accountNumber;
        this.timestamp = new Date();
        this.amount = amount;
        this.description = description;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }

    public Date getTimestamp()
    {
        return timestamp;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(long amount)
    {
        this.amount = amount;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
