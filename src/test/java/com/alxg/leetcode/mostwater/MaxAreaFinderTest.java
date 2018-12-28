package com.alxg.leetcode.mostwater;

import static org.assertj.core.api.Assertions.assertThat;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class MaxAreaFinderTest {

  private MaxAreaFinder sut;

  @Before
  public void setUp() {
    sut = new MaxAreaFinder();
  }

  @Test
  @UseDataProvider("testData")
  public void shouldReturnMaxArea(int[] height, int expectedResult) {
    assertThat(sut.maxArea(height)).isEqualTo(expectedResult);
  }

  @DataProvider
  public static Object[][] testData() {
    return new Object[][]{
        {new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49},
        {new int[]{1}, 0},
        {new int[]{1, 3, 4, 2, 1, 1, 2, 1}, 10},
        {new int[]{1, 1}, 1}
    };
  }

}