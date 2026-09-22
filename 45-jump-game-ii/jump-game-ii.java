class Solution {
    public int jump(int[] nums) {
        int jumps = 0;       // total number of jumps taken so far
        int currentEnd = 0;  // farthest index reachable using the jumps taken so far
        int farthest = 0;    // farthest index reachable if we take one more jump from anywhere in the current range

        // we stop at nums.length - 1 because once we can REACH the last index,
        // we don't need to jump FROM it
        for (int i = 0; i < nums.length - 1; i++) {

            // check: from index i, how far could we potentially reach?
            // keep track of the best (farthest) option seen so far in this range
            farthest = Math.max(farthest, i + nums[i]);

            // if we've reached the edge of what our current number of jumps allows,
            // we MUST jump again to keep moving forward
            if (i == currentEnd) {
                jumps++;              // take the jump
                currentEnd = farthest; // update our new reachable boundary
            }
        }

        return jumps;
    }
}