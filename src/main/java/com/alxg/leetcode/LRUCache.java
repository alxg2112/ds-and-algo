package com.alxg.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

  static final int NOT_FOUND_VALUE = -1;

  private int capacity;
  private Map<Integer, Integer> cache;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.cache = new LinkedHashMap<>(capacity);
  }

  public int get(int key) {
    int value = cache.getOrDefault(key, NOT_FOUND_VALUE);
    if (value != NOT_FOUND_VALUE) {
      refresh(key, value);
    }
    return value;
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      refresh(key, value);
    } else {
      if (cache.size() == capacity) {
        removeLruMapping();
      }
      cache.put(key, value);
    }
  }

  private void refresh(int key, int value) {
    cache.remove(key);
    cache.put(key, value);
  }

  private void removeLruMapping() {
    Integer lruKey = cache.keySet().iterator().next();
    cache.remove(lruKey);
  }
}
