package pulku.vending;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pınar on 23.02.2016.
 */
public class AlphaNumericChooserTest {

    private AlphaNumericChooser choser;

    @Before
    public void setUp() throws Exception {
        choser = new AlphaNumericChooser(26, 10);
    }

    @Test
    public void validInputReturnsProperLocation() throws Exception {
        AlphaNumericChooser.Location loc = choser.locationFromInput("B4");

        assertEquals("proper row", 1, loc.getRow());
        assertEquals("proper column", 3, loc.getColumn());

    }

    @Test(expected = InvalidLocationException.class)
    public void choosingWrongInputNotAllowed() throws Exception {
        choser.locationFromInput("WRONG");

    }

    @Test(expected = InvalidLocationException.class)
    public void choosingLargerThanMaxIsNotAllowed() throws Exception {
        choser.locationFromInput("B52");
    }

    @Test
    public void constructingLargerThanAlphabetNotAllowed() throws Exception {
        new AlphaNumericChooser(26, 10);
    }
}