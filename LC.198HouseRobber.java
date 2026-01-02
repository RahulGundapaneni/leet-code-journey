// House Robbler Solution 1

// Using Recursion

class Solution {
    int max;
    public int rob(int[] nums) {
        this.max = 0; 
        dp(nums, 0, 0);
        return max;
    }

    public void dp(int[] nums, int i, int totalRobbings) {
        if( i >= nums.length) {
            max = Math.max(max, totalRobbings);
            return;
        }
        // No Choose
        dp(nums, i+1, totalRobbings);
        // Choose
        dp(nums, i+2, totalRobbings + nums[i]);
    }
}


// DP with Tabulation

// Take. a 1 D array dp[] of size n+1
// EX: nums = [2,7,9,3,1]
// dp[1] = nums[0] = 2; // Only one house to
// [2] - []^2 ans 2
// [2,7] - choose and no choose 7 , Choose []^7 no choose [2](from previous)
// [2,7,9] - choose and no choose 9 , Choose [2] + 9 no choose [2,7](from previous)...

class Solution {
    public int rob(int[] nums) {
        int l = nums.length;
        int[] dp = new int[l];
        if(l == 1) return nums[0];

        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for( int i = 2; i < l; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[l-1];
    }
}

// DP with Space Optimization
// We can solve only using 2 variables prev and curr

class Solution {
    public int rob(int[] nums) {
        int l = nums.length;
        if(l == 1) return nums[0];

        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);

        for( int i = 2; i < l; i++) {
            int temp = curr;
            curr = Math.max(curr, prev + nums[i]);
            prev = temp;
        }
        return curr;
    }
}

// Enhansement - If we want to know which houses were robbed
// Use a boolean array ( True - robbed, False - not robbed)

class Solution {
    public int rob(int[] nums) {
        int l = nums.length;
        if(l == 1) return nums[0];

        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        boolean[] robbed = new boolean[l];
        robbed[0] = true;
        if(curr == nums[1]) robbed[1] = true;

        for( int i = 2; i < l; i++) {
            int temp = curr;
            if( curr < prev + nums[i]) {
                curr = prev + nums[i];
                robbed[i] = true;
            } else {
                robbed[i] = false;
            }
            prev = temp;
        }
}