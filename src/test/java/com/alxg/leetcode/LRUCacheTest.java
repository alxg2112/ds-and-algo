package com.alxg.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LRUCacheTest {

  private LRUCache sut;

  @Test
  public void shouldEvictLRUValue() {
    LRUCache cache = new LRUCache(2);

    cache.put(1, 1);
    cache.put(2, 2);
    assertThat(cache.get(1)).isEqualTo(1);       // returns 1
    cache.put(3, 3);    // evicts key 2
    assertThat(cache.get(2)).isEqualTo(-1);       // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    assertThat(cache.get(1)).isEqualTo(-1);       // returns -1 (not found)
    assertThat(cache.get(3)).isEqualTo(3);       // returns 3
    assertThat(cache.get(4)).isEqualTo(4);       // returns 4
  }
}