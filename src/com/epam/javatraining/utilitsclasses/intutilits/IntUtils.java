package com.epam.javatraining.utilitsclasses.intutilits;

import java.util.Arrays;

public class IntUtils {

    public static int[] changeSizeArray(int[] array, int newSize) {
        if (array == null || newSize == 0) {
            return null;
        }
        int[] newSizeArray = new int[newSize];
        System.arraycopy(array, 0, newSizeArray, 0, Math.min(array.length, newSize));
        return newSizeArray;
    }

    public static boolean equalArrays(int[] firstArr, int[] secondArr) {
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

    public static int[] mixArray(int[] array) {
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
            int randomNumber1 = ((int) (Math.random() * array.length));
            int randomNumber2 = ((int) (Math.random() * array.length));
            int tempValue = resultArray[randomNumber1];
            resultArray[randomNumber1] = resultArray[randomNumber2];
            resultArray[randomNumber2] = tempValue;
            counter++;
        }
        return resultArray;
    }

    public static void printArray(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("Our array is non-existent!");
        } else {
            System.out.println("Our array: ");
            for (int indexElement = 0; indexElement < array.length - 1; indexElement++) {
                System.out.print(array[indexElement] + "; ");
            }
            System.out.print(array[array.length - 1] + ".\n");
        }
    }

}
