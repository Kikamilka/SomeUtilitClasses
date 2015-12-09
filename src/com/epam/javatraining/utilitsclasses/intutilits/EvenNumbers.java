package com.epam.javatraining.utilitsclasses.intutilits;

public class EvenNumbers implements Predicate {

    @Override
    public boolean predicate(int element) {
        if (element % 2 != 0) {
            return false;
        }
        return true;
    }
}
