package com.alxg.misc.knight;

import java.util.Arrays;
import java.util.List;

public class KnightTourSimulator {

  private static final int CHESSBOARD_SIZE = 8;
  private static final List<int[]> KNIGHT_MOVES =
      Arrays.asList(
          new int[]{2, 1},
          new int[]{2, -1},
          new int[]{-2, 1},
          new int[]{-2, -1},
          new int[]{1, 2},
          new int[]{1, -2},
          new int[]{-1, 2},
          new int[]{-1, -2}
      );

  public void knightTour() {
    int[][] chessboard = new int[CHESSBOARD_SIZE][CHESSBOARD_SIZE];
    chessboard[0][0] = 1;
    knightTour(chessboard, 0, 0, 1);

    Arrays.stream(chessboard).forEach(row -> System.out.println(Arrays.toString(row) + '\n'));
  }

  private boolean knightTour(
      int[][] chessboard,
      int rowLocation,
      int columnLocation,
      int currentMoveIndex) {
    if (currentMoveIndex == CHESSBOARD_SIZE * CHESSBOARD_SIZE) {
      return true;
    }
    for (int[] move : KNIGHT_MOVES) {
      if (canDoMove(chessboard, rowLocation, columnLocation, move)) {
        int nextMoveIndex = ++currentMoveIndex;
        int[] newLocation = doMove(chessboard, rowLocation, columnLocation, move, nextMoveIndex);
        int newRowLocation = newLocation[0];
        int newColumnLocation = newLocation[1];
        if (knightTour(chessboard, newRowLocation, newColumnLocation, nextMoveIndex)) {
          return true;
        } else {
          undoMovesAfterIndex(chessboard, currentMoveIndex);
        }
      }
    }
    return false;
  }

  private boolean canDoMove(int[][] chessboard, int rowLocation, int columnLocation, int[] move) {
    int newRowLocation = rowLocation + move[0];
    int newColumnLocation = columnLocation + move[1];
    return newRowLocation >= 0
        && newRowLocation < CHESSBOARD_SIZE
        && newColumnLocation >= 0
        && newColumnLocation < CHESSBOARD_SIZE
        && chessboard[newRowLocation][newColumnLocation] == 0;
  }

  private int[] doMove(int[][] chessboard, int rowLocation, int columnLocation, int[] move,
      int moveIndex) {
    int newRowLocation = rowLocation + move[0];
    int newColumnLocation = columnLocation + move[1];
    chessboard[newRowLocation][newColumnLocation] = moveIndex;
    return new int[]{newRowLocation, newColumnLocation};
  }

  private void undoMovesAfterIndex(int[][] chessboard, int moveIndex) {
    for (int i = 0; i < CHESSBOARD_SIZE; i++) {
      for (int j = 0; j < CHESSBOARD_SIZE; j++) {
        if (chessboard[i][j] > moveIndex) {
          chessboard[i][j] = 0;
        }
      }
    }
  }

  public static void main(String[] args) {
    new KnightTourSimulator().knightTour();
  }
}
