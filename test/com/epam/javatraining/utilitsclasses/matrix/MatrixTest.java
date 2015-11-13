package com.epam.javatraining.utilitsclasses.matrix;

import com.epam.javatraining.utilitsclasses.matrix.utilites.Size;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixTest {

    public MatrixTest() {
    }

    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Matrix matrix = null;
        try {
            Size sizeMatrix = matrix.getSize();
            fail("NullPointerException was expected");
        } catch (NullPointerException ex) {
        }

        matrix = new Matrix(new double[][]{
            {1, 2, 3}, 
            {0, 1, 2}
        });
        Size expResult = new Size(3, 2);
        Size sizeMatrix = matrix.getSize();
        assertEquals(expResult, sizeMatrix);
    }

    @Test
    public void testGetElement() {
        System.out.println("getElement");
        try {
            Matrix matrix = null;
            double result = matrix.getElement(0, 0);
            fail("NullPointerException was expected");
        } catch (NullPointerException ex) {
        }

        Matrix instance = new Matrix(new double[][]{
            {1, 2, 3}, 
            {0, 1, 2}
        });
        double expResult = 1.0;
        double result = instance.getElement(0, 0);
        assertEquals(expResult, result, 0.0);

        try {
            Matrix matrix = new Matrix(new double[][]{
                {1, 2}, 
                {0, 1}
            });
            result = matrix.getElement(0, 3);
            fail("IllegalArgumentException was expected");
        } catch (IllegalArgumentException ex) {
        }
    }

    @Test
    public void testSetElement() {
        System.out.println("setElement");
        double element = 0.0;
        int row = 0;
        int column = 0;
        Matrix instance = new Matrix(new double[][]{
            {1, 2}, 
            {0, 1}
        });
        instance.setElement(element, row, column);
        assertEquals(element, instance.getElement(row, column), 0.0);

        try {
            instance.setElement(0.0, 3, 3);
            fail("IllegalArgumentException was expected");
        } catch (IllegalArgumentException ex) {
        }
    }

    @Test
    public void testAdd() {
        System.out.println("add");
        try {
            Matrix firstMatrix = new Matrix(new double[][]{
                {1, 2}, 
                {0, 1}
            });
            Matrix secondMatrix = new Matrix(new double[][]{
                {1, 2, 5}, 
                {0, 1, 2}
            });
            firstMatrix.add(secondMatrix);
            fail("IllegalArgumentException was expected");
        } catch (IllegalArgumentException ex) {
        }

        Matrix leftMatrix = new Matrix(new double[][]{
            {1, 2},
            {0, 1}
        });
        Matrix rightMatrix = new Matrix(new double[][]{
            {0, 2},
            {5, 6}
        });
        Matrix expResult = new Matrix(new double[][]{
            {1, 4},
            {5, 7}
        });
        Matrix result = leftMatrix.add(rightMatrix);
        for (int indexRow = 0; indexRow < result.numberRows(); indexRow++) {
            for (int indexColumn = 0; indexColumn < result.numberColumns(); indexColumn++) {
                assertEquals(expResult.getElement(indexRow, indexColumn), result.getElement(indexRow, indexColumn), 0.0);
            }
        }
    }

    @Test
    public void testMultiplication() {
        System.out.println("multiplication");
        try {
            Matrix leftMatrix = new Matrix(new double[][]{
                {1, 2, 10}, 
                {0, 1, 8}
            });
            Matrix rightMatrix = new Matrix(new double[][]{
                {1, 2, 5}, 
                {0, 1, 2}
            });
            leftMatrix.multiplication(rightMatrix);
            fail("IllegalArgumentException was expected");
        } catch (IllegalArgumentException ex) {
        }
        
        
        Matrix leftMatrix = new Matrix(new double[][]{
            {1, 2},
            {0, 1}
        });
        Matrix rightMatrix = new Matrix(new double[][]{
            {0, 2},
            {5, 6}
        });
        Matrix expResult = new Matrix(new double[][]{
            {10, 14},
            {5, 6}
        });
        Matrix result = leftMatrix.multiplication(rightMatrix);
        for (int indexRow = 0; indexRow < result.numberRows(); indexRow++) {
            for (int indexColumn = 0; indexColumn < result.numberColumns(); indexColumn++) {
                assertEquals(expResult.getElement(indexRow, indexColumn), result.getElement(indexRow, indexColumn), 0.0);
            }
        }        
    }

    @Test
    public void testCalculateDeterminant() {
        System.out.println("calculateDeterminant");
        try {
            Matrix myMatrix = new Matrix(new double[][]{
                {1, 2, 10}, 
                {0, 1, 8}
            });            
            myMatrix.calculateDeterminant();
            fail("IllegalArgumentException was expected");
        } catch (IllegalArgumentException ex) {
        }
        
        Matrix myMatrix = new Matrix(new double[][]{
                {1, 2}, 
                {3, 8}
        }); 
        double result = myMatrix.calculateDeterminant();
        assertEquals(2, result, 0.0);
        
        myMatrix = new Matrix(new double[][]{
                {1, 2, 3}, 
                {3, 8, -1},
                {0, 2, 4}
        }); 
        result = myMatrix.calculateDeterminant();
        assertEquals(28, result, 0.0);
    }

}
