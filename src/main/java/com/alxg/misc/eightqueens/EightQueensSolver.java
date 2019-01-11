package com.alxg.misc.eightqueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EightQueensSolver {

  private static final char FREE_CELL = '.';
  private static final char ATTACKED_CELL = 'X';
  private static final char QUEEN = 'Q';

  private static final int CHESSBOARD_SIZE = 8;
  private static final int NUMBER_OF_QUEENS = 8;

  public void solveEightQueensPuzzle() {
    char[][] chessboard = new char[CHESSBOARD_SIZE][CHESSBOARD_SIZE];
    for (char[] column : chessboard) {
      Arrays.fill(column, FREE_CELL);
    }
    System.out.println(solveEightQueensPuzzle(chessboard, 0));
  }

  private boolean solveEightQueensPuzzle(char[][] chessboard, int currentNumberOfQueens) {
    if (currentNumberOfQueens == NUMBER_OF_QUEENS) {
      System.out.println("===================================");
      Arrays.stream(chessboard).forEach(row -> System.out.println(Arrays.toString(row) + '\n'));
      System.out.println("===================================");
      return true;
    }

    for (int columnIndex = currentNumberOfQueens; columnIndex < CHESSBOARD_SIZE; columnIndex++) {
      List<Integer> freeRowIndices = getFreeRowIndices(chessboard, columnIndex);
      if (freeRowIndices.isEmpty()) {
        return false;
      }
      for (int freeRowIndex : freeRowIndices) {
        char[][] boardSnapshot = createSnapshot(chessboard);
        placeQueen(chessboard, freeRowIndex, columnIndex);
        if (solveEightQueensPuzzle(chessboard, currentNumberOfQueens + 1)) {
          return true;
        } else {
          chessboard = boardSnapshot;
        }
      }
    }

    return false;
  }

  private char[][] createSnapshot(char[][] chessboard) {
    char[][] snapshot = new char[CHESSBOARD_SIZE][CHESSBOARD_SIZE];
    for (int rowIndex = 0; rowIndex < CHESSBOARD_SIZE; rowIndex++) {
      System.arraycopy(chessboard[rowIndex], 0, snapshot[rowIndex], 0, CHESSBOARD_SIZE);
    }
    return snapshot;
  }

  private List<Integer> getFreeRowIndices(char[][] chessboard, int columnIndex) {
    List<Integer> freeRowIndices = new ArrayList<>();
    for (int iRow = 0; iRow < CHESSBOARD_SIZE; iRow++) {
      if (chessboard[iRow][columnIndex] == FREE_CELL) {
        freeRowIndices.add(iRow);
      }
    }
    return freeRowIndices;
  }

  private void placeQueen(char[][] chessboard, int rowIndex, int columnIndex) {
    attackColumn(chessboard, columnIndex);
    attackRow(chessboard, rowIndex);
    attackDiagonals(chessboard, rowIndex, columnIndex);
    chessboard[rowIndex][columnIndex] = QUEEN;
  }

  private void attackRow(char[][] chessboard, int rowIndex) {
    for (int columnIndex = 0; columnIndex < CHESSBOARD_SIZE; columnIndex++) {
      chessboard[rowIndex][columnIndex] = ATTACKED_CELL;
    }
  }

  private void attackColumn(char[][] chessboard, int columnIndex) {
    for (int rowIndex = 0; rowIndex < CHESSBOARD_SIZE; rowIndex++) {
      chessboard[rowIndex][columnIndex] = ATTACKED_CELL;
    }
  }

  private void attackDiagonals(char[][] chessboard, int rowIndex, int columnIndex) {
    int firstDiagonalStartRowIndex = rowIndex - Math.min(rowIndex, columnIndex);
    int firstDiagonalStartColumnIndex = columnIndex - Math.min(rowIndex, columnIndex);
    for (int iCol = firstDiagonalStartColumnIndex, iRow = firstDiagonalStartRowIndex;
        iCol < CHESSBOARD_SIZE && iRow < CHESSBOARD_SIZE;
        iCol++, iRow++) {
      chessboard[iRow][iCol] = ATTACKED_CELL;
    }

    int secondDiagonalStartRowIndex =
        rowIndex + Math.min(CHESSBOARD_SIZE - 1 - rowIndex, columnIndex);
    int secondDiagonalStartColumnIndex =
        columnIndex - Math.min(CHESSBOARD_SIZE - 1 - rowIndex, columnIndex);
    for (int iCol = secondDiagonalStartColumnIndex, iRow = secondDiagonalStartRowIndex;
        iCol < CHESSBOARD_SIZE && iRow > 0;
        iCol++, iRow--) {
      chessboard[iRow][iCol] = ATTACKED_CELL;
    }
  }

  public static void main(String[] args) {
    new EightQueensSolver().solveEightQueensPuzzle();
  }
}
