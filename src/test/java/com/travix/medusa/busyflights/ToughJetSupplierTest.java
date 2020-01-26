package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.suppliers.ToughJetSupplier;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ToughJetSupplierTest {

    @Test
    public void testExpectedFare_returns(){
        ToughJetSupplier toughJetSupplier = new ToughJetSupplier();
        double actualFare = toughJetSupplier.evaluateFare( 100.0, 20, 15);
        double expectedFare = 102.0;
        assertEquals(expectedFare, actualFare, 0.0001);
    }
}
