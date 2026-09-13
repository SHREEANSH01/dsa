class Solution {
    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        // Skip spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        // Store digits
        StringBuilder sb = new StringBuilder();

        while (i < n && Character.isDigit(s.charAt(i))) {
            sb.append(s.charAt(i));
            i++;
        }

        // Reverse if you intentionally built it backwards
        // sb.reverse();

        // Convert
        long num = 0;

        for (int j = 0; j < sb.length(); j++) {
            num = num * 10 + (sb.charAt(j) - '0');

            if (sign == 1 && num > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if (sign == -1 && -num < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return (int)(num * sign);
    }
}