package com.example.demo.util;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class HaversineTest {

    @Test
    public void testDistance0ForSameLocation() {
       double distance = Haversine.distance(53.2987696, -6.313377, 53.2987696,-6.313377);
        assertEquals(distance, 0.0, 0.0);
    }

    @Test
    public void testDistanceValueForSpecificLocation() {
        double distance = Haversine.distance(53.298745, -6.311834, 53.332376,-6.246116);
        assertEquals(distance, 5.75, 0.05);
    }
}
