package com.alxg.leetcode.jumpgame;

import static org.assertj.core.api.Assertions.assertThat;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class JumpGameTest {

  private JumpGame sut;

  @Before
  public void setUp() {
    sut = new JumpGame();
  }

  @Test
  @UseDataProvider("testData")
  public void shouldReturnMaxArea(int[] nums, boolean expectedResult) {
    assertThat(sut.canJump(nums)).isEqualTo(expectedResult);
  }

  @DataProvider
  public static Object[][] testData() {
    return new Object[][]{
        {new int[]{2, 3, 1, 1, 4}, true},
        {new int[]{3, 2, 1, 0, 4}, false},
        {new int[]{1, 1, 2, 2, 0, 1, 1}, true},
        {new int[]{5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6,
            9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5}, true}
    };
  }
}