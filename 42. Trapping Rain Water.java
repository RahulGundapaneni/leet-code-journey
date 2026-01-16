// Define 2 arrays to store left max and right max values
// Then iterate through height array and find min of left max and right max at each index
// Subtract height at that index from min of left max and right max to get capacity at
// that index and add to volume if capacity is positive

class Solution {
    public int trap(int[] height) {
        // find left pass max values
        int l = height.length;
        int[] leftWall = new int[l];
        int leftMax = 0;
        for(int i = 0; i < l; i++) {
            leftWall[i] = leftMax;
            leftMax = Math.max(leftMax, height[i]);
        }
        // find from right side

        int[] rightWall = new int[l];
        int rightMax = 0;
        for(int i = l-1; i >= 0; i--) {
            rightWall[i] = rightMax;
            rightMax = Math.max(rightMax, height[i]);
        }
        // calculate volume
        int volume = 0;
        for(int i = 0; i < l; i++) {
            int count = Math.min(rightWall[i], leftWall[i]);
            int cap = count - height[i];
            if(cap > 0){
                volume = volume + cap;
            }
        }
        return volume;
    }
}


// Optimzed apprach
// Use 2 pointers left and right
// Also maintain left wall and right wall max values
// Move the pointer which has smaller height value
// If left wall is smaller than current left height update left wall
// else add left wall - current left height to result
// Similarly for right wall and right pointer

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lw = height[0], l = 0;
        int rw = 0, r = n-1;
        int result = 0;
        while ( l < r ) {
            if(height[l] <= height[r]) {
                if(lw <= height[l]) {
                    lw = height[l];
                }
                else {
                    result += lw - height[l]; 
                }
                l++;
            }
            else if(height[r] < height[l]) {
                if(rw <= height[r]) {
                    rw = height[r];
                }
                else {
                    result += rw - height[r];
                }
                r--;
            }
        }
        return result;
    }
}
