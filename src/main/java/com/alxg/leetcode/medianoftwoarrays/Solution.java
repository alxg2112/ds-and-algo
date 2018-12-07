package com.alxg.leetcode.medianoftwoarrays;

import java.util.Arrays;

public class Solution {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] merged = new int[nums1.length + nums2.length];
    System.arraycopy(nums1, 0, merged, 0, nums1.length);
    System.arraycopy(nums2, 0, merged, nums1.length, nums2.length);
    Arrays.sort(merged);
    if (merged.length == 1) {
      return merged[0];
    }
    if (merged.length % 2 == 0) {
      int middleHighIndex = merged.length / 2;
      int middleLowIndex = middleHighIndex - 1;
      return (merged[middleHighIndex] + merged[middleLowIndex]) / 2.0D;
    } else {
      return merged[merged.length / 2];
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().findMedianSortedArrays(new int[]{}, new int[]{1, 2, 3, 4, 5}));
  }
}
