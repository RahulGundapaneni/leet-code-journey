class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(curr == '(' || curr == '{' || curr == '[') {
                st.push(curr);
            }
            else if(curr == ')' || curr == '}' || curr == ']') {
                if(st.isEmpty()) return false;
                char prev = st.pop();
                if(map.get(curr) != prev) return false;
            }
        }
        if(!st.isEmpty()) {
            return false;
        }
        return true;
    }
}
