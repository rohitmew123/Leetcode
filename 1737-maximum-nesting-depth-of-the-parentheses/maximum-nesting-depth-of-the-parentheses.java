class Solution {
    public int maxDepth(String s) {

        int res = 0;
        int curr = 0;

        for(int i = 0; i<s.length(); i++) {

            char ch = s.charAt(i);

            if(ch == '(') {
                curr++;
                res = Math.max(res, curr);
            }
            if(ch == ')') {
                curr--;
            }
        } 
        return res;
        
    }
}