class Solution {

    public String encode(List<String> strs) {
        // For encoding a string lets add a number and a delimiter
        // Ex: 5#
        StringBuilder sb = new StringBuilder(); 
        for(String s: strs) {
            int l = s.length();

            sb.append(l).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            // 1. Read length
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));

            // 2. Read the string
            j++; // skip '#'
            String word = str.substring(j, j + length);
            result.add(word);

            // 3. Move pointer
            i = j + length;
        }

        return result;
    }
}
