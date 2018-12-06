package com.alxg.leetcode.regex;

public class Solution {

  public static final class Matcher {

  }

  // TODO: implement
  public boolean isMatch(String s, String p) {
    char[] stringArray = s.toCharArray();
    char[] patternArray = p.toCharArray();

    int stringPointer = 0;
    int patternPointer = 0;

    while (true) {

      if (patternPointer == patternArray.length - 1) {
        if (stringPointer == stringArray.length - 1) {
          break;
        } else {
          return false;
        }
      }

      char patternCurrentSymbol = patternArray[patternPointer];

      if (patternCurrentSymbol != '.'
          && patternCurrentSymbol != '*') {

        // ..a*..
        if (patternPointer + 1 <= patternArray.length - 1
            && patternArray[patternPointer + 1] == '*') {
          stringPointer += numberOfOccurences(stringArray, stringPointer, patternCurrentSymbol);
          patternPointer += 2;
        }

        // ..a..
        if (stringArray[stringPointer] == patternCurrentSymbol) {
          stringPointer++;
          patternPointer++;
        } else {
          return false;
        }
      } else if (patternCurrentSymbol == '.') {
        stringPointer++;
        patternPointer++;
      }
    }

    return true;
  }

  private int numberOfOccurences(char[] input, int offset, char c) {
    int occurences = 0;
    for (int i = offset; i < input.length; i++) {
      if (input[i] == c) {
        occurences++;
      }
    }
    return occurences;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().isMatch("aa", "a"));
    System.out.println(new Solution().isMatch("aa", "a*"));
    System.out.println(new Solution().isMatch("ab", ".*"));
    System.out.println(new Solution().isMatch("aa", "a"));
    System.out.println(new Solution().isMatch("aa", "a"));
  }
}
