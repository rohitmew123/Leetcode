class Solution {
    public long countSubstrings(String s, char c) {
        long count = 0;
        long substrings = 0;

        for(char ch : s.toCharArray()) {
            if(ch == c) {
                substrings = substrings + (1 + count);
                count++;
            }
        }
        return substrings;
        
    }
}