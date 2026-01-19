class Solution {
    public int evalRPN(String[] tokens) {
        int res = 0;
        Stack<Integer> st = new Stack<>();
        for(String c: tokens) {
            if(c.equals("+")) {
                int a = st.pop();
                int b = st.pop();
                res = a + b;
                st.push(res);
            }
            else if(c.equals("-")) {
                int a = st.pop();
                int b = st.pop();
                res = (b - a);
                st.push(res);
            }
            else if(c.equals("*")) {
                int a = st.pop();
                int b = st.pop();
                res =  (a * b);
                st.push(res);
            }
            else if(c.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                res = (b / a);
                st.push(res);
            }
            else {
                st.push(Integer.parseInt(c));
            }
        }
        return st.pop();
    }
}
