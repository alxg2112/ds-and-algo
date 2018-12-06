package com.alxg.leetcode.twonumbers;

public class Solution {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }

    @Override
    public String toString() {
      return String.valueOf(val)
          + (next == null
          ? ""
          : " -> " + next.toString());
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode listOneCurrent = l1;
    ListNode listTwoCurrent = l2;
    ListNode resultList = null;
    ListNode interimList = null;
    int increment = 0;

    for (int i = 0; ; i++) {
      if (listOneCurrent == null && listTwoCurrent == null) {
        if (increment == 1) {
          interimList.next = new ListNode(1);
        }
        break;
      }
      int listOneCurrentValue = listOneCurrent == null
          ? 0
          : listOneCurrent.val;
      int listTwoCurrentValue = listTwoCurrent == null
          ? 0
          : listTwoCurrent.val;

      int sum = listOneCurrentValue + listTwoCurrentValue + increment;
      int resultListCurrentValue = sum % 10;
      increment = sum >= 10 ? 1 : 0;

      if (resultList == null) {
        resultList = new ListNode(resultListCurrentValue);
        interimList = resultList;
      } else {
        interimList.next = new ListNode(resultListCurrentValue);
        interimList = interimList.next;
      }

      listOneCurrent = listOneCurrent == null
          ? null
          : listOneCurrent.next;
      listTwoCurrent = listTwoCurrent == null
          ? null
          : listTwoCurrent.next;
    }

    return resultList;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);

    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);

    System.out.println(new Solution().addTwoNumbers(l1, l2));
  }
}