// TC L1 * L2

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int l1 = s1.length();
        int l2 = s2.length();
        if(l2 < l1) return false;
        // Run through string 1 and put in hashMap with count;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < l1; i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int j = 0; j <= (l2 - l1); j++) {
            HashMap<Character, Integer> currMap = new HashMap<>(map);
            for(int i = 0; i < l1; i++ ) {
                char curr = s2.charAt(j+i);
                if(currMap.containsKey(curr)) {
                    currMap.put(curr, currMap.get(curr)-1);
                    if(currMap.get(curr) == 0) {
                        currMap.remove(curr);
                    }
                    if(currMap.isEmpty()) return true;
                }
                else {
                    break;
                }
            }
        }
        return false;

    }
}


// Better way to write but recheck solution later
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 > l2) return false;

        int[] count = new int[26];

        // Count characters of s1
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < l2; right++) {
            char c = s2.charAt(right);
            count[c - 'a']--;

            // If count goes negative, shrink window
            while (count[c - 'a'] < 0) {
                count[s2.charAt(left) - 'a']++;
                left++;
            }
x
            // Window size matches s1
            if (right - left + 1 == l1) return true;
        }

        return false;
    }
}
