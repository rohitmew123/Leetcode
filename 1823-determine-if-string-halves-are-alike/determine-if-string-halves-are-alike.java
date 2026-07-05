class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int mid = n/2;

        int i = 0; 
        int j = mid;

        int countL = 0;
        int countR = 0;

        while(i < mid && j < n) {

            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u' || ch == 'A' ||ch == 'E' ||ch == 'I' ||ch == 'O' ||ch == 'U' ) {  

                countL++;
            }

            char chh = s.charAt(j);
            if(chh == 'a' || chh == 'e' ||chh == 'i' ||chh == 'o' ||chh == 'u' || chh == 'A' ||chh == 'E' ||chh == 'I' ||chh == 'O' ||chh == 'U') {
                
                countR++;
            }

            i++;
            j++;
        
        }

        return countL == countR;
     
    }
}