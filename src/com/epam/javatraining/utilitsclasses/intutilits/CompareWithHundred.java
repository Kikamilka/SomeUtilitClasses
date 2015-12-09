package com.epam.javatraining.utilitsclasses.intutilits;

public class CompareWithHundred implements Predicate {

    @Override
    public boolean predicate(int element) {
        if (element <= 100) {
            return false;
        }
        return true;
    }
}
