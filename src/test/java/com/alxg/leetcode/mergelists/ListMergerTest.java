package com.alxg.leetcode.mergelists;

import static org.assertj.core.api.Assertions.assertThat;

import com.alxg.leetcode.mergelists.ListMerger.ListNode;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class ListMergerTest {

  private ListMerger sut;

  @Before
  public void setUp() {
    sut = new ListMerger();
  }

  @Test
  @UseDataProvider("testData")
  public void shouldMergeTwoSortedLists(ListNode firstList, ListNode secondList,
      int[] expectedResult) {
    assertListNodeContains(sut.mergeTwoLists(firstList, secondList), expectedResult);
  }

  @DataProvider
  public static Object[][] testData() {
    return new Object[][]{
        {null, null, new int[] {}},
        {null, createListNode(1), new int[]{1}},
        {createListNode(1), createListNode(1), new int[]{1, 1}},
        {createListNode(1, 2, 3), createListNode(4, 5, 6), new int[]{1, 2, 3, 4, 5, 6}},
        {createListNode(1, 2, 2, 3, 5, 8), createListNode(2, 3, 7, 10),
            new int[]{1, 2, 2, 2, 3, 3, 5, 7, 8, 10}}
    };
  }

  private static ListNode createListNode(int first, int... elements) {
    ListNode head = new ListNode(first);
    ListNode tail = head;
    for (int element : elements) {
      tail.next = new ListNode(element);
      tail = tail.next;
    }
    return head;
  }

  private static void assertListNodeContains(ListNode listNode, int... elements) {
    ListNode tail = listNode;
    for (int element : elements) {
      assertThat(tail.val).isEqualTo(element);
      tail = tail.next;
    }
  }
}