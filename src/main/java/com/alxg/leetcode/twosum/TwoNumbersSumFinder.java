package com.alxg.leetcode.twosum;

import java.util.Arrays;

public class TwoNumbersSumFinder {

  public int[] twoSum(int[] nums, int target) {

    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      int toFind = target - num;
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] == toFind) {
          return new int[]{i, j};
        }
      }
    }

    return null;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new TwoNumbersSumFinder().twoSum(new int[]{2, 7, 11, 15}, 9)));
  }
}
