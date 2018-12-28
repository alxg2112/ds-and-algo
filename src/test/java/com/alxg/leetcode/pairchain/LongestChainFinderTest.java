package com.alxg.leetcode.pairchain;

import static org.assertj.core.api.Assertions.assertThat;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class LongestChainFinderTest {

  private LongestChainFinder sut;

  @Before
  public void setUp() {
    sut = new LongestChainFinder();
  }

  @Test
  @UseDataProvider("testData")
  public void shouldReturnMaximumLength(int[][] pairs, int expectedResult) {
    assertThat(sut.findLongestChain(pairs)).isEqualTo(expectedResult);
  }

  @DataProvider
  public static Object[][] testData() {
    return new Object[][]{
        {new int[][]{{7, 9}, {4, 5}, {7, 9}, {-7, -1}, {0, 10}, {3, 10}, {3, 6}, {2, 3}}, 4}
    };
  }
}