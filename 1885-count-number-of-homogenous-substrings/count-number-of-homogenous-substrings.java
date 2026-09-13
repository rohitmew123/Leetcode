class Solution {
    public int countHomogenous(String s) {

        int MOD = 1000000007;
        
        int length = 0;
        int result = 0;

        for(int i=0; i<s.length(); i++) {
           
            if( i>0 && s.charAt(i) == s.charAt(i-1)) {
                length++;
            } else {
                length = 1;
            }
            result =( result + length) % MOD;
        }
        return result;
        
    }
}