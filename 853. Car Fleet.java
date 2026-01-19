class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // Its a Card Fleet
        // Order it so the back car can match up to forward car as they should have same speed
        int l = speed.length;
        int[][] combined = new int[l][2];
        for(int i = 0; i < l; i++) {
            combined[i] = new int[]{position[i], speed[i]};
        }
        Arrays.sort(combined, (a,b) -> b[0]-a[0]);
        Stack<Double> st = new Stack<>();
        // Take Double as numbers can be decimal
        for(int i = 0; i < l ;i++) {
            int curr[] = combined[i];
            double destTime = (double)(target - curr[0]) / curr[1];
            
            if(!st.isEmpty()) {
                double lastEle = st.peek();
                if(destTime > st.peek())
                {
                    st.push(destTime);
                }
            }
            else{
                st.push(destTime);
            }
        }
        return st.size();
    }
}
