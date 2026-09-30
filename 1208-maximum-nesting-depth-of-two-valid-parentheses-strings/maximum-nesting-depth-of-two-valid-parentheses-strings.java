class Solution {
    public int[] maxDepthAfterSplit(String seq) {

        int[] result = new int[seq.length()];
        int d = 0;

        for (int i = 0; i < seq.length(); i++) {

            if (seq.charAt(i) == '(') {
                d++;
                result[i] = d % 2;
            } else {
                result[i] = d % 2;
                d--;
            }
        }

        return result;
    }
}