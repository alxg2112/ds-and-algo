package com.alxg.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LFUCache {

  static final int NOT_FOUND_VALUE = -1;

  private int capacity;
  private Map<Integer, Integer> cache;
  private Map<Integer, Integer> frequenciesByKeys;

  public LFUCache(int capacity) {
    this.capacity = capacity;
    this.cache = new LinkedHashMap<>(capacity);
    this.frequenciesByKeys = new HashMap<>(capacity);
  }

  public int get(int key) {
    int value = cache.getOrDefault(key, NOT_FOUND_VALUE);
    if (value != NOT_FOUND_VALUE) {
      frequenciesByKeys.merge(key, 1, Math::addExact);
    }
    return value;
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      frequenciesByKeys.merge(key, 1, Math::addExact);
    } else {
      if (cache.size() == capacity) {
        
      }
    }
  }
}
