package com.alxg.leetcode.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {

  public List<List<Integer>> permute(int[] numbers) {
    List<List<Integer>> permutations = new ArrayList<>();
    generatePermutations(permutations, Collections.emptyList(), toSet(numbers));
    return permutations;
  }

  private void generatePermutations(
      List<List<Integer>> permutations,
      List<Integer> head,
      Set<Integer> numbers) {
    if (numbers.isEmpty()) {
      permutations.add(head);
    }

    for (int number : numbers) {
      List<Integer> newHead = copyAppendedWith(head, number);
      Set<Integer> remainingNumbers = copyWithoutOne(numbers, number);
      generatePermutations(permutations, newHead, remainingNumbers);
    }
  }

  private Set<Integer> toSet(int[] numbers) {
    Set<Integer> set = new HashSet<>();
    for (int number : numbers) {
      set.add(number);
    }
    return set;
  }

  private <T> List<T> copyAppendedWith(List<T> list, T tail) {
    List<T> newList = new ArrayList<>(list);
    newList.add(tail);
    return newList;
  }

  private <T> Set<T> copyWithoutOne(Set<T> set, T toRemove) {
    Set<T> newSet = new HashSet<>(set);
    newSet.remove(toRemove);
    return newSet;
  }

  public static void main(String[] args) {
    System.out.println(new Permutation().permute(new int[]{1, 2, 3, 4}));
  }
}
