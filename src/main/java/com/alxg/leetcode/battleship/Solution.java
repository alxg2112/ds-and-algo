package com.alxg.leetcode.battleship;

public class Solution {

  public int countBattleships(char[][] board) {
    final char WATER = '.';
    final char SHIP = 'X';
    int shipCount = 0;
    for (int i = 0; i < board.length; i++) {
      char prev = WATER;
      char[] row = board[i];
      if (row.length == 0) {
        return 0;
      }
      for (int j = 0; j < row.length; j++) {
        char curr = row[j];
        if (curr == SHIP) {
          if (prev == WATER) {
            char upper = i > 0 ? board[i - 1][j] : WATER;
            if (upper == WATER) {
              shipCount++;
            }
          }
        }
        prev = curr;
      }
    }

    return shipCount;
  }

  public static void main(String[] args) {
//    System.out.println(new Solution().countBattleships(new char[][]{
//        {'X', '.', '.', 'X'},
//        {'.', 'X', '.', 'X'},
//        {'.', '.', '.', 'X'},
//        {'X', 'X', '.', 'X'}
//    }));
    System.out.println(new Solution().countBattleships(new char[][]{
        {'.'},
        {'.'},
        {'X'}
    }));
  }
}
