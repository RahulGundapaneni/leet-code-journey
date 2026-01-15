// 1st Sort the list

// Then start with 1st element and start doing tow sum left and right pointer as they are sorted
// Then move to next element and do the same
//If prev and Curr element are sma e continuye as we are going position wise

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length; 
        for(int i=0; i<n; i++){
            if(i != 0 && nums[i] == nums[i-1]) continue;

            int l = i+1;
            int r = nums.length-1;
            int target = -nums[i];
            while(l < r) {
                if(nums[l] + nums[r] == target ) {
                    List<Integer> currArr = new ArrayList<>();
                    currArr.add(nums[i]);
                    currArr.add(nums[l]);
                    currArr.add(nums[r]);
                    result.add(currArr);
                    l++;
                    r--;

                    // skip duplicates
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                }
                else if(nums[l] + nums[r] > target ){
                    r--;
                }
                else {
                    l++;
                }
            }
        }
        return result;
    }
}
