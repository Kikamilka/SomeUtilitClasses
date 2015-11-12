package epamtraining.utilitsclasses.intutilits;

import java.util.Arrays;

public class IntUtils {

    public static int[] changeSizeArray(int[] array, int newSize) {
        int[] retutnArray = new int[newSize];
        System.arraycopy(array, 0, retutnArray, 0, Math.min(array.length, newSize));
        return retutnArray;
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

    static void printArray(int[] array) {
        System.out.println("Our array: " + '\n');
        for (int indexElement = 0; indexElement < array.length - 1; indexElement++) {
            System.out.println(array[indexElement] + "; ");
        }
        System.out.println(array[array.length - 1] + ".\n");
    }

}
