package pulku.vending;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pınar on 23.02.2016.
 */
public class VendingMachineTest {
    private VendingMachine machine;

    public class NotifierSub implements Notifier{
        @Override
        public void onSale(Item item) {
            return;
        }
    }

    @Before
    public void setUp() throws Exception {
        Notifier notifier = new NotifierSub();
        machine = new VendingMachine(notifier, 10, 10, 10);
        machine.restock("A1", "Twinkies", 10, 30, 75);
    }

    @Test
    public void vendingWhenStokedReturnsItem() throws Exception {
        machine.addMoney(75);

        Item item = machine.vend("A1");

        assertEquals("Twinkies", item.getName());

    }
}