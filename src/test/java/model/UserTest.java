package model;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {

    private User testUser;

    @Before
    public void initializer() {
        testUser = new User(new BigDecimal(1000));
    }

    @Test
    public void testIfWithdrawDraws200From1000_ShouldBe800() {
        testUser.withdraw(new BigDecimal(200));
        assertEquals(new BigDecimal(800), testUser.getBalance());
    }

    @Test
    public void testIfDepositAdds200To1000_ShouldBe1200() {
        testUser.deposit(new BigDecimal(200));
        assertEquals(new BigDecimal(1200), testUser.getBalance());
    }

    @Test
    public void testIfTransferArrivesAndSubtractsCorrectly() {
        User receiver = new User(new BigDecimal(1000));
        testUser.transferTo(receiver, new BigDecimal(500));
        assertEquals(new BigDecimal(500), testUser.getBalance());
        assertEquals(new BigDecimal(1500), receiver.getBalance());
    }

    @Test
    public void testFilterTransactionsByTypeByReturnSize() {
        List<Transaction> testTransactions = new ArrayList<>();
        Transaction testTransaction = new Transaction(TransactionType.WITHDRAW,
                new BigDecimal(-300), new BigDecimal(1400));
        testTransactions.add(testTransaction);
        testUser.deposit(new BigDecimal(200));
        testUser.deposit(new BigDecimal(500));
        testUser.withdraw(new BigDecimal(300));
        System.out.println(testUser.getTransactionHistory());
        assertEquals(testTransactions.size(), testUser.filterTransactionsByType(TransactionType.WITHDRAW).size());
    }
}