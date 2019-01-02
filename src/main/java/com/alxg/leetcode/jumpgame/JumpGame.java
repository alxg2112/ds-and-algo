package com.alxg.leetcode.jumpgame;

public class JumpGame {

  public boolean canJump(int[] nums) {

    int currentPosition = 0;

    while (true) {
      // Reached end
      if (currentPosition == nums.length - 1) {
        return true;
      }
      // Cannot jump anymore
      if (nums[currentPosition] == 0) {
        return false;
      }

      int oneJumpMaxDistance = nums[currentPosition];
      int oneJumpMaxPosition = currentPosition + oneJumpMaxDistance;

      // Can reach end from current position
      if (oneJumpMaxPosition >= nums.length - 1) {
        return true;
      }

      // Greedily find max position reachable via two jumps
      int twoJumpsMaxDistance = nums[currentPosition];
      int maxPositionAfterTwoJumps = oneJumpMaxPosition;
      for (int firstJump = 1; firstJump <= oneJumpMaxDistance; firstJump++) {
        int twoJumpsMaxDistanceForGivenFirstJump = firstJump + nums[currentPosition + firstJump];
        if (twoJumpsMaxDistanceForGivenFirstJump > twoJumpsMaxDistance) {
          twoJumpsMaxDistance = twoJumpsMaxDistanceForGivenFirstJump;
          maxPositionAfterTwoJumps = currentPosition + firstJump;
        }
      }
      currentPosition = maxPositionAfterTwoJumps;
    }
  }
}
