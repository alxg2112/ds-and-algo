package com.alxg.leetcode.jumpgame;

public class JumpGame {

  public boolean canJump(int[] nums) {

    int pos = 0;

    while (true) {
      if (pos == nums.length - 1) {
        return true;
      }
      if (nums[pos] == 0) {
        return false;
      }
      int maxJumpDistance = nums[pos];
      int maxTourDistance = nums[pos];
      int optNextPos = pos + maxJumpDistance;

      if (optNextPos >= nums.length - 1) {
        return true;
      }

      for (int jumpDistance = 1; jumpDistance < maxJumpDistance; jumpDistance++) {
        int temp = jumpDistance + nums[pos + jumpDistance];
        if (temp > maxTourDistance) {
          maxTourDistance = temp;
          optNextPos = pos + jumpDistance;
        }
      }
      pos = optNextPos;
    }
  }
}
