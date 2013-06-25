package com.transaction;

import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 6/13/13
 * Time: 1:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionDAO {

    private List<TransactionDTO> listTransaction = new ArrayList<TransactionDTO>();

    // Tao ra mot doi tuong giao dich khi gui tien
    public TransactionDTO deposit(String accountNumber, double amount, String description) {
        return null;
    }

    // Tao ra mot doi tuong giao dich khi rut tien
    public TransactionDTO withdraw(String accountNumber, double amount, String description) {
        return null;
    }

    //Luu giao dich vao CSDL
    public TransactionDTO save(TransactionDTO transactionDTO) {
        this.listTransaction.add(transactionDTO);
        return null;
    }

    // Lay ra danh sach tat ca cac giao dich
    public List<TransactionDTO> getTransactionOcurred(String accountNumber){
        return null;
    }

    // Lay ra cac giao dich trong khoang thoi gian tu startDate den endDate
    public List<TransactionDTO> getTransactionOcurred(String accountNumber , Date startDate, Date endDate){
        return null;
    }

    // lay ra n giao dich gan nhat
    public List<TransactionDTO> getTransactionOcurred(String accountNumber, int n){
        return null;
    }

    public List<TransactionDTO> getListTransaction(){
        return this.listTransaction;
    }
}
