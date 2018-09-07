package model;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

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
}