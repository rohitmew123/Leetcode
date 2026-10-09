class Solution {
    public int minInsertions(String s) {

        int result = 0;
        int count = 0;

        for(int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if(ch == '(') {

                count += 2;

                if(count % 2 != 0) {
                    result++;
                    count--;
                }

            } else {

                count--;

                if(count < 0) {
                    result++;
                    count = 1;
                }
            }
        }

        return result + count;
    }
}