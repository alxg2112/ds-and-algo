package com.alxg.leetcode.movezeroes;

import java.util.Arrays;

public class ArrayZeroesMover {

  public void moveZeroes(int[] nums) {
    for (int cur = 0, lastNonZeroFoundAt = 0; cur < nums.length; cur++) {
      if (nums[cur] != 0) {
        swap(nums, lastNonZeroFoundAt++, cur);
      }
    }
  }

  private static void swap(int[] nums, int firstPos, int secondPos) {
    int tmp = nums[firstPos];
    nums[firstPos] = nums[secondPos];
    nums[secondPos] = tmp;
  }

  public static void main(String[] args) {
    int[] nums = {0, 1, 0, 0, 11, 31, 0, 32};
    new ArrayZeroesMover().moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
  }
}
