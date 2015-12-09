package com.epam.javatraining.utilitsclasses.intutilits;

import org.junit.Test;
import static org.junit.Assert.*;

public class IntUtilsTest {

    public IntUtilsTest() {
    }

    @Test
    public void testChangeSizeArray() {
        System.out.println("changeSizeArray are testing");
        int[] result = IntArrayUtils.resize(null, 0);
        int[] expResult = null;
        assertArrayEquals(expResult, result);

        result = IntArrayUtils.resize(new int[]{1, 2, 3, 4, 5}, 3);
        expResult = new int[]{1, 2, 3};
        assertArrayEquals(expResult, result);

        result = IntArrayUtils.resize(new int[]{1, 2, 3}, 5);
        expResult = new int[]{1, 2, 3, 0, 0};
        assertArrayEquals(expResult, result);

        result = IntArrayUtils.resize(new int[]{1, 2, 3}, 0);
        expResult = null;
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testEqualArrays() {
        System.out.println("equalArrays are tecting");
        try {
            IntArrayUtils.equal(null, null);
            fail("NullPointerException was expected");
        } catch (NullPointerException ex) {
        }

        try {
            IntArrayUtils.equal(null, new int[]{1, 2, 3});
            fail("NullPointerException was expected");
        } catch (NullPointerException ex) {
        }

        int[] firstArr = new int[]{1, 2, 3};
        int[] secondArr = new int[]{1, 2, 3};
        boolean result = IntArrayUtils.equal(firstArr, secondArr);
        assertEquals(true, result);

        firstArr = new int[]{1, 2, 3, 4};
        secondArr = new int[]{1, 2, 3};
        result = IntArrayUtils.equal(firstArr, secondArr);
        assertEquals(false, result);

        firstArr = new int[]{1, 2, 15, 32, 0, 1};
        secondArr = new int[]{1, 0, 1, 2, 32, 15};
        result = IntArrayUtils.equal(firstArr, secondArr);
        assertEquals(true, result);
    }

    @Test
    public void testMixArray() {
        System.out.println("mixArray");        
        int[] mixArray = IntArrayUtils.shuffle(null);
        assertArrayEquals(null, mixArray);
        
        int[] array = new int[0];
        mixArray = IntArrayUtils.shuffle(array);
        int[] expResult = new int[0];
        assertArrayEquals(expResult, mixArray); 
        
        array = new int[]{1, 2, 15, 32, 0, 1, 3, 4};
        mixArray = IntArrayUtils.shuffle(array);
        assertEquals(true, IntArrayUtils.equal(array, mixArray));
    }

}
