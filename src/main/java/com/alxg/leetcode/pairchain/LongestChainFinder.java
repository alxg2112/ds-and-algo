package com.alxg.leetcode.pairchain;

import java.util.Arrays;
import java.util.Comparator;

public class LongestChainFinder {

  private static final int SEGMENT_START = 0;
  private static final int SEGMENT_END = 1;

  public int findLongestChain(int[][] pairs) {
    Arrays.sort(pairs, Comparator.comparingInt(pair -> pair[SEGMENT_START]));
    int N = pairs.length;
    int[] dp = new int[N];
    Arrays.fill(dp, 1);

    for (int j = 1; j < N; ++j) {
      for (int i = 0; i < j; ++i) {
        if (pairs[i][SEGMENT_END] < pairs[j][SEGMENT_START]) {
          dp[j] = Math.max(dp[j], dp[i] + 1);
        }
      }
    }

    int ans = 0;
    for (int x : dp) {
      if (x > ans) {
        ans = x;
      }
    }
    return ans;
  }
}