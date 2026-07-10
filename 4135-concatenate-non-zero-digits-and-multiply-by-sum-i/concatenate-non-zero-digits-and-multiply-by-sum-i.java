class Solution {
    public long sumAndMultiply(int n) {
        String s = Integer.toString(n);
        
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c != '0') {
                sb.append(c);
            }
        }
        
        if (sb.length() == 0) return 0;
        
        long x = Long.parseLong(sb.toString());
        
        long sum = 0;
        for (char c : sb.toString().toCharArray()) {
            sum += c - '0';
        }
        
        return x * sum;
    }
}