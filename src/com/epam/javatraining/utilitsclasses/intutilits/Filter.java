package com.epam.javatraining.utilitsclasses.intutilits;

public class Filter {

    public static int[] filter(int[] elements, Predicate condition) {
        int sizeResult = countSizeResult(elements, condition);
        int[] result = new int[sizeResult];
        int index = 0;
        for (int i = 0; i < elements.length; i++) {
            if (condition.predicate(elements[i])) {
                result[index] = elements[i];
                index++;
            }
        }
        return result;
    }

    private static int countSizeResult(int[] elements, Predicate condition) {
        int numberOfElements = 0;
        for (int i = 0; i < elements.length; i++) {
            if (condition.predicate(elements[i])) {
                numberOfElements++;
            }
        }
        return numberOfElements;
    }

}
