class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<>();
        int l = temperatures.length;
        int[] result = new int[l];
        // Iterate through temperatures
        for(int i = 0; i < l; i++) {
            int curr = temperatures[i]; 
            // while st is not empty and temperate > prev
            // pop and add to result
            while( !st.isEmpty() && st.peek()[0] < curr) {  
                int outIndex = st.pop()[1];  
                result[outIndex] = i - outIndex;  
            }
            // append currnent element to stack
            st.push(new int[]{curr, i});
        }
        return result;
    }
}
