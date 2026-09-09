import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // sort first so duplicates sit next to each other,
        // and so we can break early once numbers get too big
        Arrays.sort(candidates);
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        backtrack(candidates, target, 0, path, result);
        
        return result;
    }
    
    private void backtrack(int[] candidates, int remaining, int start,
                            List<Integer> path, List<List<Integer>> result) {
        // base case: this combination sums exactly to target
        if (remaining == 0) {
            result.add(new ArrayList<>(path));  // copy path, since it keeps changing
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            // skip duplicates at the same recursion depth
            // (prevents duplicate combinations like picking "first 1" vs "second 1")
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            // sorted array: if this number already overshoots remaining,
            // every number after it (bigger) will too, so stop this branch entirely
            if (candidates[i] > remaining) {
                break;
            }
            
            path.add(candidates[i]);
            // i + 1 (not i): each array position can only be used once
            backtrack(candidates, remaining - candidates[i], i + 1, path, result);
            path.remove(path.size() - 1);  // undo the choice, try the next option
        }
    }
}