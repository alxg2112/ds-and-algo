package com.alxg.leetcode.longestsubstr;

public class Solution {

  public int lengthOfLongestSubstring(String s) {
    char[] chars = s.toCharArray();
    if (chars.length == 0) {
      return 0;
    }
    int offset = 0;
    int result = 1;

    for (int i = 1; i < chars.length; i++) {
      int tempRes = 1;
      char curr = chars[i];
      for (int j = i - 1; j >= offset; j--) {
        if (chars[j] == curr) {
          offset = j + 1;
          break;
        }
        tempRes++;
      }
      result = tempRes > result ? tempRes : result;
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().lengthOfLongestSubstring("dvdf"));
  }
}
