class Solution {
    public int divide(int dividend, int divisor) {
        // Special case: overflow when dividing INT_MIN by -1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign of result
        boolean negative = (dividend < 0) != (divisor < 0);

        // Work with absolute values using long to avoid overflow
        // (especially important since |Integer.MIN_VALUE| > Integer.MAX_VALUE)
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        long result = 0;

        while (dvd >= dvs) {
            long temp = dvs;
            long multiple = 1;

            // Double temp (and multiple) as long as it still fits into dvd
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            // Subtract the largest found multiple, add to result
            dvd -= temp;
            result += multiple;
        }

        result = negative ? -result : result;

        // Clamp to 32-bit signed integer range
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) result;
    }
}