package com.alxg.leetcode.mostwater;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MaxAreaFinder {

  public int maxArea(int[] lineHeights) {
    int[] lineHeightsSorted = copyAndSort(lineHeights);
    int size = lineHeights.length;

    int maxArea = 0;

    for (int curr = size - 2 /* second largest*/; curr >= 0; curr--) {
      int waterHeight = lineHeightsSorted[curr];

      int leftBound = indexOfFirstGreaterOrEqual(lineHeights, waterHeight);
      if (leftBound == -1) {
        continue;
      }

      int rightBound = indexOfLastGreaterOrEqual(lineHeights, waterHeight);
      if (rightBound == -1 || leftBound == rightBound) {
        continue;
      }

      int currentArea = area(lineHeights, leftBound, rightBound);
      maxArea = currentArea > maxArea
          ? currentArea
          : maxArea;
    }

    return maxArea;
  }

  private int area(int[] lineHeights, int firstLineIndex, int secondLineIndex) {
    return Math.abs(firstLineIndex - secondLineIndex) *
        Math.min(lineHeights[firstLineIndex], lineHeights[secondLineIndex]);
  }

  private int indexOfFirstGreaterOrEqual(int[] arr, int n) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] >= n) {
        return i;
      }
    }
    return -1;
  }

  private int indexOfLastGreaterOrEqual(int[] arr, int n) {
    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr[i] >= n) {
        return i;
      }
    }
    return -1;
  }

  private int[] copyAndSort(int[] arr) {
    int[] copy = Arrays.copyOf(arr, arr.length);
    Arrays.sort(copy);
    return copy;
  }
}
