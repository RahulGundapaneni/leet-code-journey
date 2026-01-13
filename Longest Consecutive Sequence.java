class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        int max = 0;
        // int curr = 1;
        for(int i: set) {
            if(!set.contains(i-1)) {
                int curr = 1;
                while(set.contains(i+1)) {
                    i = i+1;
                    curr++;
                } 
                max = Math.max(curr, max);
            }
        }
        return max;
    }
}
