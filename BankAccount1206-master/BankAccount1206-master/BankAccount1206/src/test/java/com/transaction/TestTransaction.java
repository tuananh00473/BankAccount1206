package com.transaction;

import com.qsoft.BankAccount;
import com.qsoft.BankAccountDAO;
import com.qsoft.BankAccountDTO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 6/13/13
 * Time: 2:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestTransaction
{
    static String accountNumber = "0123456789";
    static double amount = 10000.0001;
    static Date date = new Date();
    static Long time = date.getTime();
    static Long timeLastMonth = time - 60*60*60*24*30;
    static Long timeNextMonth = time + 60*60*60*24*30;

    BankAccountDAO mocBankAccountDAO = mock(BankAccountDAO.class);
    TransactionDAO mocTransactionDAO = mock(TransactionDAO.class);

    @Before
    public void setUp()
    {
        reset(mocTransactionDAO);
        reset(mocBankAccountDAO);
        Transaction.transactionDAO = mocTransactionDAO;
        BankAccount.bankAccountDAO = mocBankAccountDAO;
    }

    @Test
    public void testDeposit()
    {
        BankAccountDTO account = BankAccount.openAccount(accountNumber);
        account.setBalance(10000000.0001);

        double oldBalance = account.getBalance();

        when(mocBankAccountDAO.getAccount(accountNumber)).thenReturn(account);

        TransactionDTO transactionDTO = new TransactionDTO(accountNumber, amount, "deposite");
        when(mocTransactionDAO.deposit(accountNumber, amount, "deposite")).thenReturn(transactionDTO);
        account.setBalance(account.getBalance() + amount);

        assertEquals(mocBankAccountDAO.getAccount(accountNumber).getBalance(), oldBalance + mocTransactionDAO.deposit(accountNumber, amount, "deposite").getAmount(), 0.00001);
    }

    @Test
    public void testWithdraw()
    {
        BankAccountDTO account = BankAccount.openAccount(accountNumber);
        account.setBalance(10000000.0001);

        double oldBalance = account.getBalance();

        when(mocBankAccountDAO.getAccount(accountNumber)).thenReturn(account);

        TransactionDTO transactionDTO = new TransactionDTO(accountNumber, amount, "withdraw");
        when(mocTransactionDAO.withdraw(accountNumber, amount, "withdraw")).thenReturn(transactionDTO);
        account.setBalance(account.getBalance() - amount);

        assertEquals(mocBankAccountDAO.getAccount(accountNumber).getBalance(), oldBalance - mocTransactionDAO.withdraw(accountNumber, amount, "withdraw").getAmount(), 0.00001);
    }

    @Test
    public void testSaveWhenDepositOrWithDraw()
    {
        BankAccountDTO account = BankAccount.openAccount(accountNumber);
        account.setBalance(10000000.0001);

        TransactionDTO transactionDeposit = Transaction.createTransaction(account.getAccountNumber(), amount, "deposit");
        when(mocTransactionDAO.deposit(accountNumber, amount, "deposit")).thenReturn(transactionDeposit);

        TransactionDTO transactionWithdraw = Transaction.createTransaction(account.getAccountNumber(), amount, "withdraw");
        when(mocTransactionDAO.withdraw(accountNumber, amount, "withdraw")).thenReturn(transactionWithdraw);

        ArgumentCaptor<TransactionDTO> argumentCaptor = ArgumentCaptor.forClass(TransactionDTO.class);
        verify(mocTransactionDAO, times(2)).save(argumentCaptor.capture());

        List<TransactionDTO> listTransaction = argumentCaptor.getAllValues();

        assertEquals(accountNumber, listTransaction.get(0).getAccountNumber());
        assertEquals(amount, listTransaction.get(0).getAmount(), 0.00001);
        assertEquals("deposit", listTransaction.get(0).getDescription());

        assertEquals(accountNumber, listTransaction.get(1).getAccountNumber());
        assertEquals(amount, listTransaction.get(1).getAmount(), 0.00001);
        assertEquals("withdraw", listTransaction.get(1).getDescription());
    }

    @Test
    public void testGetListAllTransactionsOccurred()
    {
        BankAccountDTO account = BankAccount.openAccount(accountNumber);
        account.setBalance(10000000.0001);

        List<TransactionDTO> listTransaction = new ArrayList<TransactionDTO>();

        new BankAccount().deposite(account.getAccountNumber(), amount, "deposite");
        TransactionDTO transactionDTO1 = new TransactionDTO(account.getAccountNumber(), amount, "deposite");

        new BankAccount().withdraw(account.getAccountNumber(), amount, "withdraw");
        TransactionDTO transactionDTO2 = new TransactionDTO(account.getAccountNumber(), amount, "withdraw");

        new BankAccount().withdraw(account.getAccountNumber(), amount, "withdraw");
        TransactionDTO transactionDTO3 = new TransactionDTO(account.getAccountNumber(), amount, "withdraw");

        new BankAccount().deposite(account.getAccountNumber(), amount, "deposite");
        TransactionDTO transactionDTO4 = new TransactionDTO(account.getAccountNumber(), amount, "deposite");

        new BankAccount().withdraw(account.getAccountNumber(), amount, "withdraw");
        TransactionDTO transactionDTO5 = new TransactionDTO(account.getAccountNumber(), amount, "withdraw");

        new BankAccount().deposite(account.getAccountNumber(), amount, "deposite");
        TransactionDTO transactionDTO6 = new TransactionDTO(account.getAccountNumber(), amount, "deposite");

        listTransaction.add(transactionDTO1);
        listTransaction.add(transactionDTO2);
        listTransaction.add(transactionDTO3);
        listTransaction.add(transactionDTO4);
        listTransaction.add(transactionDTO5);
        listTransaction.add(transactionDTO6);

        when(mocTransactionDAO.getTransactionOcurred(accountNumber)).thenReturn(listTransaction);

        List<TransactionDTO> listTransactionGet = Transaction.getTransactionOcurred(account.getAccountNumber(), 4);
        for (int i = 0; i < listTransactionGet.size(); i++)
        {
            System.out.println(listTransactionGet.get(i).getDescription());

        }
    }

    @Test
    public void testGetListTransactionsOccurredBetweenTwoDate()
    {
        BankAccountDTO account = BankAccount.openAccount(accountNumber);
        account.setBalance(10000000.0001);

        List<TransactionDTO> listTransaction = new ArrayList<TransactionDTO>();

        new BankAccount().deposite(account.getAccountNumber(), amount, "deposite");
        TransactionDTO transactionDTO1 = new TransactionDTO(account.getAccountNumber(), amount, "deposite");
        transactionDTO1.setTimestamp(new Date(timeLastMonth));

        new BankAccount().withdraw(account.getAccountNumber(), amount, "withdraw");
        TransactionDTO transactionDTO2 = new TransactionDTO(account.getAccountNumber(), amount, "withdraw");
        transactionDTO2.setTimestamp(new Date(timeNextMonth));

        new BankAccount().withdraw(account.getAccountNumber(), amount, "withdraw");
        TransactionDTO transactionDTO3 = new TransactionDTO(account.getAccountNumber(), amount, "withdraw");
        transactionDTO3.setTimestamp(new Date(time - 10000000));

        new BankAccount().deposite(account.getAccountNumber(), amount, "deposite");
        TransactionDTO transactionDTO4 = new TransactionDTO(account.getAccountNumber(), amount, "deposite");
        transactionDTO4.setTimestamp(new Date(time + 10000000));

        new BankAccount().withdraw(account.getAccountNumber(), amount, "withdraw");
        TransactionDTO transactionDTO5 = new TransactionDTO(account.getAccountNumber(), amount, "withdraw");
        transactionDTO5.setTimestamp(new Date(time + 500000));

        listTransaction.add(transactionDTO3);
        listTransaction.add(transactionDTO4);
        listTransaction.add(transactionDTO5);

        when(mocTransactionDAO.getTransactionOcurred(accountNumber, new Date(time - 20000000), new Date(time + 20000000))).thenReturn(listTransaction);

        List<TransactionDTO> listTransactionGet = Transaction.getTransactionOcurred(account.getAccountNumber(), new Date(time - 20000000), new Date(time + 20000000));
        for (int i = 0; i < listTransactionGet.size(); i++)
        {
            System.out.println(listTransactionGet.get(0).getDescription());
            assertEquals(listTransaction.get(i), listTransactionGet.get(i));
        }
    }

    @Test
    public void testGetListManyTransactionsOccurred()
    {
        BankAccountDTO account = BankAccount.openAccount(accountNumber);
        account.setBalance(10000000.0001);

        List<TransactionDTO> listTransaction = new ArrayList<TransactionDTO>();

        new BankAccount().deposite(account.getAccountNumber(), amount, "deposite");
        TransactionDTO transactionDTO1 = new TransactionDTO(account.getAccountNumber(), amount, "deposite");

        new BankAccount().withdraw(account.getAccountNumber(), amount, "withdraw");
        TransactionDTO transactionDTO2 = new TransactionDTO(account.getAccountNumber(), amount, "withdraw");

        new BankAccount().withdraw(account.getAccountNumber(), amount, "withdraw");
        TransactionDTO transactionDTO3 = new TransactionDTO(account.getAccountNumber(), amount, "withdraw");

        new BankAccount().deposite(account.getAccountNumber(), amount, "deposite");
        TransactionDTO transactionDTO4 = new TransactionDTO(account.getAccountNumber(), amount, "deposite");

        new BankAccount().withdraw(account.getAccountNumber(), amount, "withdraw");
        TransactionDTO transactionDTO5 = new TransactionDTO(account.getAccountNumber(), amount, "withdraw");

        new BankAccount().deposite(account.getAccountNumber(), amount, "deposite");
        TransactionDTO transactionDTO6 = new TransactionDTO(account.getAccountNumber(), amount, "deposite");

        listTransaction.add(transactionDTO1);
        listTransaction.add(transactionDTO2);
        listTransaction.add(transactionDTO3);
        listTransaction.add(transactionDTO4);

        when(mocTransactionDAO.getTransactionOcurred(accountNumber)).thenReturn(listTransaction);

        List<TransactionDTO> listTransactionGet = Transaction.getTransactionOcurred(account.getAccountNumber(), 4);
        for (int i = 0; i < listTransactionGet.size(); i++)
        {
            System.out.println(listTransactionGet.get(i).getDescription());

        }
    }
}
