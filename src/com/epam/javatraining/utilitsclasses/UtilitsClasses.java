package com.epam.javatraining.utilitsclasses;

import com.epam.javatraining.utilitsclasses.intutilits.IntUtils;

public class UtilitsClasses {

    public static void main(String[] args) {
        int[] myArray = new int[]{1, 2, 15, 32, 0, 1, 3, 4};
        int[] myArray2 = new int[]{1, 0, 4, 1, 2, 3, 32, 15};
        int [] newArray = IntUtils.mixArray(myArray);
        IntUtils.printArray(newArray);
        int [] newArray2 = IntUtils.changeSizeArray(myArray, 25);
        IntUtils.printArray(newArray2);
        System.out.println(IntUtils.equalArrays(myArray, myArray2));
        int[] result = IntUtils.changeSizeArray(new int[]{1, 2}, 0);
        IntUtils.printArray(result);
    }
    
}
