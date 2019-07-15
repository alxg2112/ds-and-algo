package com.alxg.leetcode.phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

  private static final Map<Character, List<String>> LETTERS_BY_DIGITS;

  static {
    LETTERS_BY_DIGITS = new HashMap<>();

    LETTERS_BY_DIGITS.put('2', Arrays.asList("a", "b", "c"));
    LETTERS_BY_DIGITS.put('3', Arrays.asList("d", "e", "f"));
    LETTERS_BY_DIGITS.put('4', Arrays.asList("g", "h", "i"));
    LETTERS_BY_DIGITS.put('5', Arrays.asList("j", "k", "l"));
    LETTERS_BY_DIGITS.put('6', Arrays.asList("m", "n", "o"));
    LETTERS_BY_DIGITS.put('7', Arrays.asList("p", "q", "r", "s"));
    LETTERS_BY_DIGITS.put('8', Arrays.asList("t", "u", "v"));
    LETTERS_BY_DIGITS.put('9', Arrays.asList("w", "x", "y", "z"));
  }

  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0) {
      return Collections.emptyList();
    } else if (digits.length() == 1) {
      return LETTERS_BY_DIGITS.get(digits.charAt(0));
    }

    List<String> combinations = new ArrayList<>();

    char firstDigit = digits.charAt(0);
    List<String> letters = LETTERS_BY_DIGITS.get(firstDigit);

    for (String letter : letters) {
      String tailDigits = digits.substring(1);
      List<String> tailCombinations = letterCombinations(tailDigits);
      for (String tailCombination : tailCombinations) {
        String combination = letter + tailCombination;
        combinations.add(combination);
      }
    }

    return combinations;
  }

  private List<Character> toCharList(String text) {
    List<Character> charsList = new ArrayList<>();
    for (char digit : text.toCharArray()) {
      charsList.add(digit);
    }
    return charsList;
  }

  private <T> List<List<T>> permute(List<T> head, List<T> tailElements) {
    if (tailElements.isEmpty()) {
      return Collections.singletonList(head);
    }

    List<List<T>> permutations = new ArrayList<>();

    for (T tailChar : tailElements) {
      List<T> newHead = new ArrayList<>(head);
      newHead.add(tailChar);
      List<T> newTailElements = new ArrayList<>(tailElements);
      newTailElements.remove(tailChar);
      permutations.addAll(permute(newHead, newTailElements));
    }

    return permutations;
  }

  public static void main(String[] args) {
//    System.out.println(
//        new LetterCombinations().permute(Collections.emptyList(), Arrays.asList('a', 'b', 'c')));
    System.out.println(new LetterCombinations().letterCombinations("23"));
  }
}
