class Solution {
    public int characterReplacement(String s, int k) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;

        // Initialize a character set to gothrough all characters in string
        for(char c: s.toCharArray()) {
            if(!set.contains(c)) {
                set.add(c);
            }
        }

        // Iterate through the characters
        for(char c: set) {
            // Initialize left pointer and current count
            int left = 0, count = 0;
            // Iterate through string
            for(int i = 0; i < s.length(); i++) {
                // If character == String value, then increase count
                if(s.charAt(i) == c) {
                    count++;
                }
                // If i - left +1 - count > k value then check if left == cthen decrease count and increase left
                while((i - left + 1) - count > k) {
                    if(s.charAt(left) == c) {
                        count--;
                    }
                    left++;
                }
                max = Math.max(i - left + 1, max);
            }
        }
        return max;
    }
}
