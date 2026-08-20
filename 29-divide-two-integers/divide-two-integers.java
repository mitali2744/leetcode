class Solution {
    public int divide(int dividend, int divisor) {
        // Handle the one case that can overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Figure out if answer should be negative
        boolean negative = (dividend < 0) != (divisor < 0);

        // Convert both to positive longs (long avoids overflow headaches)
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int result = 0;

        // Keep subtracting divisor, but double it each time it still fits
        while (dvd >= dvs) {
            long sum = dvs;      // current chunk we're subtracting
            int multiple = 1;    // how many "divisor"s that chunk represents

            while (sum + sum <= dvd) {
                sum += sum;        // double the chunk
                multiple += multiple; // double the count too
            }

            dvd -= sum;
            result += multiple;
        }

        return negative ? -result : result;
    }
}