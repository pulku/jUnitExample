package pulku.vending;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pınar on 23.02.2016.
 */
public class CreditorTest {

    private Creditor creditor;

    @Before
    public void setUp() throws Exception {
        creditor = new Creditor();

    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
    public void addingFundsIncrementsAvailableFunds() throws Exception {

        creditor.addFunds(25); //Act
        creditor.addFunds(25);

        assertEquals(50, creditor.getAvailableFunds()); //Assert
    }

    @Test
    public void refundingReturnsAllAvailableFunds() throws Exception {
        
        creditor.addFunds(10);

        int refund = creditor.refund();

        assertEquals(10, refund);


    }

    @Test
    public void refundingResetsAvailableFundsToZero() throws Exception {

        creditor.addFunds(10);

        int refund = creditor.refund();

        assertEquals(0, creditor.getAvailableFunds());

    }
}