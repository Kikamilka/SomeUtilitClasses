package com.epam.javatraining.utilitsclasses.intutilits;

import org.junit.Test;
import static org.junit.Assert.*;

public class FilterTest {

    public FilterTest() {
    }

    @Test
    public void testFilterEvenNumber() {
        System.out.println("filter Even Number");
        int[] elements = {1, 12, 101, 22, 54, 110, 200, 13};
        Predicate condition = new EvenNumbers();
        int[] expResult = {12, 22, 54, 110, 200};
        int[] result = Filter.filter(elements, condition);
        assertArrayEquals(expResult, result);
        
        elements = new int[]{1, 101, 21, 53, 13};
        expResult = new int[]{};
        result = Filter.filter(elements, condition);
        assertArrayEquals(expResult, result);        
    }

    @Test
    public void testFilterCompareHundred() {
        System.out.println("filter compare with hundred");
        int[] elements = {1, 12, 101, 22, 54, 110, 200, 13};
        Predicate condition = new CompareWithHundred();
        int[] expResult2 = {101, 110, 200};
        int[] result = Filter.filter(elements, condition);
        assertArrayEquals(expResult2, result);
    }

}
