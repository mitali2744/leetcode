class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        
        // if start is out of bounds or value there isn't target, not found
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        
        int end = lowerBound(nums, target + 1) - 1;
        
        return new int[]{start, end};
    }
    
    // finds first index where nums[index] >= target
    private int lowerBound(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}