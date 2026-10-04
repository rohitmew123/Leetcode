class Solution {
    public boolean checkValidString(String s) {

        int n = s.length();
        
        if(s.length() == 0) {
            return true;
        }

        int minOpen = 0;
        int maxOpen = 0;

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '(') {
                minOpen++;
                maxOpen++;
            } 
            if(ch == ')') {
                minOpen--;
                maxOpen--;

                if(minOpen < 0) {
                    minOpen = 0;
                }

                if(maxOpen < 0) {
                    return false;
                }
            }

            if(ch == '*') {
                minOpen--;
                maxOpen++;

                if(minOpen < 0) {
                    minOpen = 0;
                }
            }
        }
        return minOpen == 0 ;

        
    }
}