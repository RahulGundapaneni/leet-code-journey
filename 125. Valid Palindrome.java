// Define a StringBuilder to store alphanumeric characters in uppercase

// Iterate through each character in the input string
// Find if its palinfrome by 2 pointer approach

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char a: s.toCharArray()) {
            if(Character.isLetterOrDigit(a)) {
                sb.append(Character.toUpperCase(a));
            }
        }
        System.out.println(sb.toString());
        boolean result = isPalin(sb.toString());
        return result;
    }

    public boolean isPalin(String s) {
        int l=0;
        int r = s.length()-1;
        while(l<=r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
