package org.timmc;

import java.io.IOException;

import org.junit.Test;
import org.junit.Assert;

public class UncheckedTest extends Assert{
    private String sneaky() {
        return Unchecked.chuck(new IOException("sneaky!"));
    }

    @Test(expected=IOException.class)
    public void testNoDeclare() {
        sneaky();
        fail("Should not have reached this point.");
    }

    @Test
    public void testCatch() {
        boolean reachedSneaky = false;
        boolean threw = false;
        try {
            Unchecked.chucks(IOException.class);
            reachedSneaky = true;
            sneaky();
            fail("Should not have reached this point.");
        } catch (IOException ioe) {
            threw = true;
        }
        assertTrue(reachedSneaky);
        assertTrue(threw);
    }
}
