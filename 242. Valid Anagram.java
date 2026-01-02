// 242. Valid Anagram

// Convert the 2 strings to Arrays and compare after sorting
// If Equals return true else false
// Time Complexity : O(n log n) due to sorting
// Space Complexity : O(n) 
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        char[] tArray = t.toCharArray();
        Arrays.sort(tArray);
        
        if(Arrays.equals(sArray, tArray)){
            return true;
        }
        return false;
    }
}


// Solution 2 using 2 HashMaps:

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        int n = s.length();
        int p = t.length();
        if(n != p) return false;

        for(int i = 0; i < n; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        }

        for(int i = 0; i < n; i++){
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0)+1);
        }

        int mapSize = map.size();
        int mapSize2 = map2.size();

        if(mapSize != mapSize2) return false;
        for(char a : map.keySet()){
            if (!map.get(a).equals(map2.get(a))) return false;
        }
        return true;
    }
}


// Solution 3 using single Array
class Solution {
    public boolean isAnagram(String s, String t) {

        int n = s.length();
        int p = t.length();
        if(n != p) return false;

        int[] a = new int[26];

        for(int i = 0; i < n; i++) {
            a[s.charAt(i)-'a'] = a[s.charAt(i)-'a'] + 1;
            a[t.charAt(i)-'a'] = a[t.charAt(i)-'a'] - 1;
        }

        for(int i: a){
            if(i != 0) {
                return false;
            }
        }
        return true;
    }
}
