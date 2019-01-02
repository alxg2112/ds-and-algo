package com.alxg.leetcode.jumpgame;

import java.util.Arrays;

public class JumpGameTwo {

  public int jump(int[] nums) {
    int[] minHopsToEnd = new int[nums.length];
    Arrays.fill(minHopsToEnd, Integer.MAX_VALUE);
    int end = nums.length - 1;

    for (int pos = end, distFromEnd = 0; pos >= 0; pos--, distFromEnd++) {
      int maxJump = nums[pos];
      if (maxJump >= distFromEnd) {
        minHopsToEnd[pos] = 1;
      } else {
        int minHopsForGivenPos = Integer.MAX_VALUE;
        for (int jump = 1; jump <= maxJump; jump++) {
          if (minHopsToEnd[pos + jump] < minHopsForGivenPos) {
            minHopsForGivenPos = minHopsToEnd[pos + jump];
          }
        }
        minHopsToEnd[pos] = minHopsForGivenPos == Integer.MAX_VALUE
            ? Integer.MAX_VALUE
            : ++minHopsForGivenPos;
      }
    }

    return minHopsToEnd[0];
  }


  public static void main(String[] args) {
    System.out
        .println(new JumpGameTwo().jump(
            new int[]{5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6,
                9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5})
//            new int[]{2, 3, 1, 1, 4})
        );
  }
}
