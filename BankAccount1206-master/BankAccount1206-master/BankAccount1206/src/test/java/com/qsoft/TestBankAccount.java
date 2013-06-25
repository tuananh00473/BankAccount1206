package com.qsoft;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 6/12/13
 * Time: 9:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestBankAccount {

     String accountNumber = "1234567890";
     BankAccountDAO mockAccountDAO=mock(BankAccountDAO.class);

    @Before
    public void setUp(){
      //  MockitoAnnotations.initMocks(this);
        reset(mockAccountDAO);
        BankAccount.bankAccountDAO = mockAccountDAO;
    }

    @Test
    public void testOpenAccount(){
        BankAccountDTO bankAccountDTO = new BankAccountDTO(accountNumber);
        BankAccount.openAccount(bankAccountDTO.getAccountNumber());

        // test xem 1 ham co duoc invoke den qua argument cua no hay ko
        ArgumentCaptor<BankAccountDTO> argumentCaptor = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockAccountDAO, times(1)).save(argumentCaptor.capture());

        assertEquals("1234567890", argumentCaptor.getValue().getAccountNumber());
        assertEquals(0, argumentCaptor.getValue().getBalance(), 0.00001);
    }

    @Test
    public void testGetAccount(){

        BankAccountDTO bankAccountDTO = new BankAccountDTO(accountNumber);
        when(mockAccountDAO.getAccount(accountNumber)).thenReturn(bankAccountDTO);
        BankAccountDTO bankAccountDTO1 = BankAccount.getAccount(accountNumber);

        verify(mockAccountDAO).getAccount(accountNumber);
        assertEquals(accountNumber, bankAccountDTO1.getAccountNumber());
        assertEquals(0, bankAccountDTO1.getBalance(),0.001);
    }
}
