class Solution {
    public String decodeAtIndex(String s, int k) {
        int n = s.length();

        long size = 0;

        for(char ch : s.toCharArray()) {

            if(Character.isDigit(ch)) {
                size = size * (ch - '0');

            } else {
                size += 1;
            }
        }

        for(int i = n-1; i>=0; i--) {

            k = (int)(k % size);

            if(k == 0 && Character.isLetter(s.charAt(i))) {
                return String.valueOf(s.charAt(i));
            }

            if( Character.isLetter(s.charAt(i))) {
                size -= 1;
            }
            else {
                size = size / (s.charAt(i) - '0');
            }
        }

        return "";

    }
}