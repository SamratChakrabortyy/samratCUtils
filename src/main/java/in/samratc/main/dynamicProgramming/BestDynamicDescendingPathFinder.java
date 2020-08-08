package in.samratc.main.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BestDynamicDescendingPathFinder {
    public static int[][] example = new int[][]{{4, 8, 7, 3}, {2, 5, 9, 3}, {6, 3, 2, 5}, {4, 4, 1, 6}};

    public static void main(String[] args) {
        BestDynamicDescendingPathFinder finder = new BestDynamicDescendingPathFinder(example);
        System.out.println("Best overall: " + Arrays.toString(finder.find()));
        System.out.println("Best starting from some other cell: " + Arrays.toString(finder.unfoldBestPathFromCell(3, 3)));
    }

    private int[][] matrix;
    private PathInformation[][] informationForBestPathFromCellMemory;

    public BestDynamicDescendingPathFinder(int[][] aMatrix) {
        informationForBestPathFromCellMemory = new PathInformation[aMatrix.length][];
        matrix = new int[aMatrix.length][];

        for (int i = 0; i < aMatrix.length; i++) {
            informationForBestPathFromCellMemory[i] = new PathInformation[aMatrix[i].length];
            matrix[i] = new int[aMatrix[i].length];

            for (int j = 0; j < aMatrix[i].length; j++) {
                matrix[i][j] = aMatrix[i][j];
            }
        }
    }

    // find the best path by getting the best starting cell and unfolding the information for it
    public int[] find() {
        int currentBestStartingCellColumn = 0;
        int currentBestStartingCellRow = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (getInformationForBestPathFromCell(i, j).compareTo(getInformationForBestPathFromCell(currentBestStartingCellColumn, currentBestStartingCellRow)) == 1) {
                    currentBestStartingCellColumn = i;
                    currentBestStartingCellRow = j;
                }
            }
        }

        return unfoldBestPathFromCell(currentBestStartingCellColumn, currentBestStartingCellRow);
    }

    // unfold the best path (starting) from a cell by walking the PathInformation structures in memory
    private int[] unfoldBestPathFromCell(int colNum, int rowNum) {
        PathInformation currentCellInformation = getInformationForBestPathFromCell(colNum, rowNum);
        int[] path = new int[currentCellInformation.length];
        path[0] = matrix[colNum][rowNum];
        int idx = 1;

        while (currentCellInformation.length > 1) {
            path[idx] = matrix[currentCellInformation.nextCellColumn][currentCellInformation.nextCellRow];
            idx++;
            currentCellInformation = getInformationForBestPathFromCell(currentCellInformation.nextCellColumn, currentCellInformation.nextCellRow);
        }

        return path;
    }

    // get the information for the best path (starting) from a cell: from memory if available or calculate otherwise
    private PathInformation getInformationForBestPathFromCell(int colNum, int rowNum) {
        if (informationForBestPathFromCellMemory[colNum][rowNum] == null) {
            informationForBestPathFromCellMemory[colNum][rowNum] = calculateInformationForBestPathFromCell(colNum, rowNum);
        }
        return informationForBestPathFromCellMemory[colNum][rowNum];
    }

    // calculate the information for the best path (starting) from a cell by using the information for best paths from neighboring cells
    private PathInformation calculateInformationForBestPathFromCell(int colNum, int rowNum) {
        List<PathInformation> possiblePathsFromCell = new ArrayList<PathInformation>();
        if (colNum != 0 && matrix[colNum - 1][rowNum] < matrix[colNum][rowNum]) {
            PathInformation p = getInformationForBestPathFromCell(colNum - 1, rowNum);
            possiblePathsFromCell.add(new PathInformation(p.length + 1, matrix[colNum][rowNum], p.endValue, colNum - 1, rowNum));
        }

        if (colNum != matrix.length - 1 && matrix[colNum + 1][rowNum] < matrix[colNum][rowNum]) {
            PathInformation p = getInformationForBestPathFromCell(colNum + 1, rowNum);
            possiblePathsFromCell.add(new PathInformation(p.length + 1, matrix[colNum][rowNum], p.endValue, colNum + 1, rowNum));
        }

        if (rowNum != 0 && matrix[colNum][rowNum - 1] < matrix[colNum][rowNum]) {
            PathInformation p = getInformationForBestPathFromCell(colNum, rowNum - 1);
            possiblePathsFromCell.add(new PathInformation(p.length + 1, matrix[colNum][rowNum], p.endValue, colNum, rowNum - 1));
        }

        if (rowNum != matrix[colNum].length - 1 && matrix[colNum][rowNum + 1] < matrix[colNum][rowNum]) {
            PathInformation p = getInformationForBestPathFromCell(colNum, rowNum + 1);
            possiblePathsFromCell.add(new PathInformation(p.length + 1, matrix[colNum][rowNum], p.endValue, colNum, rowNum + 1));
        }

        if (possiblePathsFromCell.isEmpty()) {
            return new PathInformation(1, matrix[colNum][rowNum], matrix[colNum][rowNum], -1, -1);
        }

        return Collections.max(possiblePathsFromCell);
    }
}

class PathInformation implements Comparable<PathInformation> {
    int length;
    int startValue;
    int endValue;
    int nextCellColumn;
    int nextCellRow;

    public PathInformation(int length, int startValue, int endValue, int nextCellColumn, int nextCellRow) {
        this.length = length;
        this.startValue = startValue;
        this.endValue = endValue;
        this.nextCellColumn = nextCellColumn;
        this.nextCellRow = nextCellRow;
    }

    @Override
    public int compareTo(PathInformation other) {
        if (this.length < other.length || (this.length == other.length && this.startValue - this.endValue < other.startValue - other.endValue)) {
            return -1;
        }
        if (this.length > other.length || (this.length == other.length && this.startValue - this.endValue > other.startValue - other.endValue)) {
            return 1;
        }
        return 0;
    }
}
