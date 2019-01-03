package com.alxg.leetcode.jumpgame;

public class JumpGameTwo {

  public int jump(int[] nums) {

    int currentPosition = 0;
    int jumpsCount = 0;

    while (true) {
      // Reached end
      if (currentPosition >= nums.length - 1) {
        return jumpsCount;
      }

      int oneJumpMaxDistance = nums[currentPosition];
      int oneJumpMaxPosition = currentPosition + oneJumpMaxDistance;

      // Can reach end from current position
      if (oneJumpMaxPosition >= nums.length - 1) {
        return ++jumpsCount;
      }

      // Greedily find max position reachable via two jumps
      int twoJumpsMaxDistance = nums[currentPosition];
      int optimalNextPosition = -1;
      for (int firstJump = 1; firstJump <= oneJumpMaxDistance; firstJump++) {
        int twoJumpsMaxDistanceForGivenFirstJump = firstJump + nums[currentPosition + firstJump];
        if (twoJumpsMaxDistanceForGivenFirstJump > twoJumpsMaxDistance) {
          twoJumpsMaxDistance = twoJumpsMaxDistanceForGivenFirstJump;
          optimalNextPosition = currentPosition + firstJump;
        }
      }
      currentPosition = optimalNextPosition;
      jumpsCount++;
    }
  }
}
