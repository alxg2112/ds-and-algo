package com.alxg.algos.binarysearch;

public class BinarySearch {

  public static int binarySearch(int[] nums, int numToSearch) {
    return binarySearch(nums, numToSearch, 0, nums.length);
  }

  private static int binarySearch(int[] nums, int numToSearch, int start, int end) {
    if (end - start <= 1) {
      return -1;
    }
    int mid = (end + start) / 2;
    if (nums[mid] > numToSearch) {
      return binarySearch(nums, numToSearch, start, mid);
    } else if (nums[mid] < numToSearch) {
      return binarySearch(nums, numToSearch, mid, end);
    } else {
      return mid;
    }
  }

  public static void main(String[] args) {
    System.out.println(BinarySearch.binarySearch(new int[] {1, 2, 3, 4, 5, 7, 9, 11, 22, 33, 44}, 33));
  }
}
