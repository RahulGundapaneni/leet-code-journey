// Todo: Review and revisite again

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        List<List<String>> result = new ArrayList<>();

        for (String key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;

    }
}


// Method 2 using Integer contant array, So sorting not required

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            int[] count = new int[26];
            for(int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            String key2 = Arrays.toString(count);
            if (!map.containsKey(key2)) {
                map.put(key2, new ArrayList<>());
            }
            map.get(key2).add(s);
        }

        List<List<String>> result = new ArrayList<>();

        for (String key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;

    }
}


// Methon 3: Using Prime NUmbers and Hashing
import java.math.BigInteger;
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<BigInteger, List<String>> map = new HashMap<>();

        BigInteger hash;
        for (String s : strs) {
            hash = getHash(s);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<>());
            }
            map.get(hash).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for (BigInteger key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }

    public BigInteger getHash(String s) {
        BigInteger hash = BigInteger.ONE;
        BigInteger[] a = new BigInteger[26];
        a[0] = BigInteger.valueOf(2);
        int freq = 1;
        int n = 3;

        while (freq < 26) {
            boolean isPrime = true;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                a[freq] = BigInteger.valueOf(n);
                freq++;
            }
            n++;
        }

        for (char c : s.toCharArray()) {
            hash = hash.multiply(a[c - 'a']);
        }
        return hash;
    }
}
