class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (nums[mid] < target) {
                lo = mid + 1;   // answer is somewhere to the right of mid
            } else {
                hi = mid;       // mid could be the answer, so keep it in range
            }
        }
        
        return lo;
    }
}