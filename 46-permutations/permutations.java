class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
        // base case: if the current permutation uses all numbers, save it
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (current.contains(num)) continue; // skip numbers already used in this permutation

            current.add(num);                     // choose this number
            backtrack(nums, current, result);      // explore further with it
            current.remove(current.size() - 1);    // undo the choice, try a different number next
        }
    }
}