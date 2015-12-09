package com.epam.javatraining.utilitsclasses.intutilits;

import java.util.Arrays;

public class IntArrayUtils {

    public static int[] resize(int[] array, int newSize) {
        if (array == null || newSize == 0) {
            return null;
        }
        int[] newSizeArray = new int[newSize];
        System.arraycopy(array, 0, newSizeArray, 0, Math.min(array.length, newSize));
        return newSizeArray;
    }

    public static boolean equal(int[] firstArr, int[] secondArr) {
        if (firstArr.length != secondArr.length) {
            return false;
        }
        Arrays.sort(firstArr);
        Arrays.sort(secondArr);
        for (int indexElement = 0; indexElement < firstArr.length; indexElement++) {
            if (firstArr[indexElement] != secondArr[indexElement]) {
                return false;
            }
        }
        return true;
    }

    public static int[] shuffle(int[] array) {
        if (array == null) {
            return null;
        }
        if (array.length == 0) {
            return new int[0];
        }
        int[] resultArray = new int[array.length];
        int counter = 0;
        System.arraycopy(array, 0, resultArray, 0, array.length);
        while (counter < array.length * 2) {
            int randomFirstIndex = ((int) (Math.random() * array.length));
            int randomSecondIndex = ((int) (Math.random() * array.length));
            int tempValue = resultArray[randomFirstIndex];
            resultArray[randomFirstIndex] = resultArray[randomSecondIndex];
            resultArray[randomSecondIndex] = tempValue;
            counter++;
        }
        return resultArray;
    }

    public static void print(int[] array) {
        if (array == null) {
            System.out.println("Our array is non-existent!");
        } else {
            if (array.length == 0) {
                System.out.println("Our array is empty");
            } else {
                System.out.println("Our array: ");
                for (int indexElement = 0; indexElement < array.length - 1; indexElement++) {
                    System.out.print(array[indexElement] + "; ");
                }
                System.out.print(array[array.length - 1] + ".\n");
            }
        }
    }

}
