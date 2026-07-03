class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();

        String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();

        backtrack(digits, phone, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, String[] phone, int index, StringBuilder current, List<String> result) {
        // if current combination is complete (same length as digits)
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // get letters for current digit
        String letters = phone[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            current.append(c);                        // add letter
            backtrack(digits, phone, index + 1, current, result);  // move to next digit
            current.deleteCharAt(current.length() - 1);  // remove letter (backtrack)
        }
    }
}