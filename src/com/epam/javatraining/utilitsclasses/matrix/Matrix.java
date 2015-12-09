package com.epam.javatraining.utilitsclasses.matrix;

import com.epam.javatraining.utilitsclasses.matrix.utilites.Size;

public class Matrix {

    private final double[][] data;

    public Matrix(Size size) {
        checkPositiveValue(size.getWidth(), size.getHeight());
        data = new double[size.getHeight()][size.getWidth()];
    }

    public Matrix(double[][] data) {
        int numberOfRows = data.length;
        int numberOfColumns = data[0].length;
        this.data = new double[numberOfRows][numberOfColumns];
        for (int indexRow = 0; indexRow < numberOfRows; indexRow++) {
            System.arraycopy(data[indexRow], 0, this.data[indexRow], 0, numberOfColumns);
        }
    }

    public Size getSize() {
        return new Size(data[0].length, data.length);
    }

    public int numberRows() {
        return this.getSize().getHeight();
    }

    public int numberColumns() {
        return this.getSize().getWidth();
    }

    public double getElement(int row, int column) {
        checkPositiveValue(row, column);
        if (row < numberRows() && column < numberColumns()) {
            return this.data[row][column];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setElement(double element, int row, int column) {
        checkPositiveValue(row, column);
        if (row < numberRows() && column < numberColumns()) {
            this.data[row][column] = element;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Matrix add(Matrix secondMatrix) {
        compareDimensionMatrixes(secondMatrix);
        Matrix resultMatrix = new Matrix(getSize());
        for (int row = 0; row < numberRows(); row++) {
            for (int column = 0; column < numberColumns(); column++) {
                double firstElement = getElement(row, column);
                double secondElement = secondMatrix.getElement(row, column);
                resultMatrix.setElement(firstElement + secondElement, row, column);
            }
        }
        return resultMatrix;
    }

    private void compareDimensionMatrixes(Matrix secondMatrix) throws IllegalArgumentException {
        if (this.getSize().equals(secondMatrix.getSize()) == false) {
            throw new IllegalArgumentException("Illegal matrix dimensions.");
        }
    }

    public Matrix multiplication(Matrix rightMatrix) {
        int widthLeftMatrix = numberColumns();
        int heightRightMatrix = rightMatrix.numberRows();
        if (widthLeftMatrix != heightRightMatrix) {
            throw new IllegalArgumentException("Illegal matrix dimensions.");
        }
        double sum = 0;
        Size sizeResult = new Size(rightMatrix.numberColumns(), numberRows());
        Matrix resultMatrix = new Matrix(sizeResult);
        for (int indexRow = 0; indexRow < numberRows(); indexRow++) {
            for (int indexColumn = 0; indexColumn < rightMatrix.numberColumns(); indexColumn++) {
                for (int indexBothMatrixes = 0; indexBothMatrixes < widthLeftMatrix; indexBothMatrixes++) {
                    sum += this.getElement(indexRow, indexBothMatrixes) * rightMatrix.getElement(indexBothMatrixes, indexColumn);
                }
                resultMatrix.setElement(sum, indexRow, indexColumn);
                sum = 0;
            }
        }
        return resultMatrix;
    }

    public double calculateDeterminant() {
        if (numberRows() != numberColumns()) {
            throw new IllegalArgumentException("Illegal matrix dimensions.");
        }
        double calcResult = 0.0;
        if (numberRows() == 2) {
            calcResult = getElement(0, 0) * getElement(1, 1) - getElement(1, 0) * getElement(0, 1);
        } else {
            for (int indexColumn = 0; indexColumn < numberColumns(); indexColumn++) {
                int koeff = calculateCoefficient(indexColumn);
                Matrix minor = this.selectionMinor(0, indexColumn);
                calcResult += koeff * getElement(0, indexColumn) * minor.calculateDeterminant();
            }
        }
        return calcResult;
    }

    private int calculateCoefficient(int indexColumn) {
        if (indexColumn % 2 == 1) {
            return -1;
        } else {
            return 1;
        }
    }

    private Matrix selectionMinor(int rowForDelete, int columnForDelete) {
        Size sizeMinor = new Size(numberColumns() - 1, numberRows() - 1);
        Matrix minor = new Matrix(sizeMinor);
        int rowIdentifier = 0;
        int columnIdentifier;
        for (int indexRow = 0; indexRow <= sizeMinor.getHeight(); indexRow++) {
            columnIdentifier = 0;
            for (int indexColumn = 0; indexColumn <= sizeMinor.getWidth(); indexColumn++) {
                if (indexRow == rowForDelete) {
                    rowIdentifier = 1;
                } else {
                    if (indexColumn == columnForDelete) {
                        columnIdentifier = 1;
                    } else {
                        int numberRowInMinor = indexRow - rowIdentifier;
                        int numberColumnInMinor = indexColumn - columnIdentifier;
                        minor.setElement(this.getElement(indexRow, indexColumn), numberRowInMinor, numberColumnInMinor);
                    }
                }
            }
        }
        return minor;
    }
    
    private void checkPositiveValue(int row, int column) throws IllegalArgumentException {
        if (row < 0 || column < 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Matrix cloneMatrix;
        Size newSize = this.getSize();        
        cloneMatrix = new Matrix(newSize);
        for (int row = 0; row < newSize.getHeight(); row++) {
            System.arraycopy(this.data[row], 0, cloneMatrix.data[row], 0, newSize.getWidth());
        }
        return cloneMatrix;
    }
    
    
}
