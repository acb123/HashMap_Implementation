package com.acb.map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import org.junit.Test;

public class ValidateMap {
    @Test
    public void testCustomMap() {
        CustomMap<String, String> customMap = new CustomMap<>(3);
        customMap.put("USA", "Washington DC");
        customMap.put("Nepal", "Kathmandu");
        customMap.put("Australia", "Sydney");

        CustomMap<Double, Double> customMap1 = new CustomMap<>(3);
        customMap1.put(8.2, 16.4);

        assertNotNull(customMap1);
        assertEquals(1, customMap1.size());
        assertEquals(16.4,customMap1.get(8.2));
    }
}
