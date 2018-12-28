package com.alxg.leetcode.validparentheses;

public class LongestValidParenthesesFinder {

  // TODO: implement
  public int longestValidParentheses(String s) {
    return 0;
  }

  public boolean isValidParentheses(String s) {
    char[] chars = s.toCharArray();

    int numberOfOpenParentheses = 0;

    for (char c : chars) {
      if (c == '(') {
        ++numberOfOpenParentheses;
      } else if (c == ')') {
        if (--numberOfOpenParentheses == -1) {
          return false;
        }
      } else {
        throw new IllegalArgumentException("Illegal character '" + c + "' is found in input");
      }
    }

    return numberOfOpenParentheses == 0;
  }
}
