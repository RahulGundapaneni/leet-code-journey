// Create a HashSet and store the elements in array
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> dup = new HashSet<>();

        for(int i : nums) {
            if(dup.contains(i)) {
                return true;
            }
            dup.add(i);
        }
        return false;
    }
}