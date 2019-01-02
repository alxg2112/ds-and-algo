package com.alxg.leetcode.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {

  public List<List<Integer>> permute(int[] numbers) {
    return generatePermutations(toList(numbers));
  }

  private List<List<Integer>> generatePermutations(List<Integer> numbers) {
    List<List<Integer>> permutations = new ArrayList<>();
    generatePermutations(permutations, Collections.emptyList(), numbers);
    return permutations;
  }

  private void generatePermutations(
      List<List<Integer>> permutations,
      List<Integer> head,
      List<Integer> numbers) {
    if (numbers.isEmpty()) {
      permutations.add(head);
    }

    for (int number : numbers) {
      List<Integer> newHead = copyAppendedWith(head, number);
      List<Integer> remainingNumbers = copyWithoutOne(numbers, number);
      generatePermutations(permutations, newHead, remainingNumbers);
    }
  }

  private List<Integer> toList(int[] numbers) {
    List<Integer> list = new ArrayList<>();
    for (int number : numbers) {
      list.add(number);
    }
    return list;
  }

  private <T> List<T> copyAppendedWith(List<T> list, T tail) {
    List<T> newList = new ArrayList<>(list);
    newList.add(tail);
    return newList;
  }

  private <T> List<T> copyWithoutOne(List<T> list, T toRemove) {
    List<T> newList = new ArrayList<>(list.size());
    for (T item : list) {
      if (!item.equals(toRemove)) {
        newList.add(item);
      }
    }
    return newList;
  }

  public static void main(String[] args) {
    System.out.println(new Permutation().permute(new int[]{1, 2, 3, 4}));
  }
}
