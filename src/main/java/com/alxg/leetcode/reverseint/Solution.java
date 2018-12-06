package com.alxg.leetcode.reverseint;

public class Solution {

  public int reverse(int x) {

    int numbersCount = 0;
    for (int tmp = x; Math.abs(tmp) > 0; tmp/=10) {
      numbersCount++;
    }

    int result = 0;
    int tmp = x;
    boolean positive = x > 0;
    for (int i = 0; i < numbersCount; i++) {
      int reminder = tmp % 10;
      int exp = numbersCount - i - 1;
      int multiplier = (int) Math.pow(10, exp);
      int adder = multiplier * reminder;

      // Overflow checks
      if (adder % multiplier != 0) return 0;
      if (positive && Integer.MAX_VALUE - result - adder < 0) return 0;
      if (!positive && Integer.MIN_VALUE - result - adder > 0) return 0;

      result += adder;
      tmp -= reminder;
      tmp /= 10;
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().reverse(-123));
  }
}
