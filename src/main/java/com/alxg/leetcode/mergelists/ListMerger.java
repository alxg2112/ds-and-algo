package com.alxg.leetcode.mergelists;

public class ListMerger {


  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int
        x) {
      val = x;
    }
  }

  public ListNode mergeTwoLists(ListNode firstList, ListNode secondList) {
    ListNode resultHead = null;
    ListNode resultTail = null;

    ListNode firstListPointer = firstList;
    ListNode secondListPointer = secondList;
    while (true) {
      ListNode resultNextNode;

      if (firstListPointer == null) {
        if (resultHead == null) {
          // Should do a copy here
          return secondListPointer;
        }

        if (resultTail == null) {
          resultTail = secondListPointer;
        } else {
          // Should do a copy here
          resultTail.next = secondListPointer;
        }
        break;
      } else if (secondListPointer == null) {
        if (resultHead == null) {
          // Should do a copy here
          return firstListPointer;
        }

        if (resultTail == null) {
          resultTail = firstListPointer;
        } else {
          // Should do a copy here
          resultTail.next = firstListPointer;
        }
        break;
      }

      if (firstListPointer.val < secondListPointer.val) {
        resultNextNode = new ListNode(firstListPointer.val);
        firstListPointer = firstListPointer.next;
      } else if (firstListPointer.val > secondListPointer.val) {
        resultNextNode = new ListNode(secondListPointer.val);
        secondListPointer = secondListPointer.next;
      } else {
        resultNextNode = new ListNode(firstListPointer.val);
        resultNextNode.next = new ListNode(secondListPointer.val);
        firstListPointer = firstListPointer.next;
        secondListPointer = secondListPointer.next;
      }

      // Append to result
      if (resultHead == null) {
        resultHead = resultNextNode;
        resultTail = getTail(resultNextNode);
      } else {
        resultTail.next = resultNextNode;
        resultTail = getTail(resultTail);
      }
    }

    return resultHead;
  }

  private ListNode getTail(ListNode listNode) {
    if (listNode == null) {
      return null;
    }
    ListNode pointer = listNode;
    while (pointer.next != null) {
      pointer = pointer.next;
    }
    return pointer;
  }
}
