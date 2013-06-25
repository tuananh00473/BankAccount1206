package com.transaction;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 6/13/13
 * Time: 1:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Transaction {

    public static TransactionDAO transactionDAO;

    public static TransactionDTO createTransaction(String accountNumber, double amount, String description){
        TransactionDTO transactionDTO = new TransactionDTO(accountNumber, amount, description);
        transactionDAO.save(transactionDTO);
        return transactionDTO;
    }

    // Lay ra danh sach tat ca cac giao dich
    public static List<TransactionDTO> getTransactionOcurred(String accountNumber){
        return transactionDAO.getTransactionOcurred(accountNumber);
    }

    // Lay ra cac giao dich trong khoang thoi gian tu startDate den endDate
    public static List<TransactionDTO> getTransactionOcurred(String accountNumber , Date startDate, Date endDate){
        return transactionDAO.getTransactionOcurred(accountNumber, startDate, endDate);
    }

    // lay ra n giao dich gan nhat
    public static List<TransactionDTO> getTransactionOcurred(String accountNumber, int n){
        return transactionDAO.getTransactionOcurred(accountNumber, n);
    }

}
