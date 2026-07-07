class Solution {
    public String sortSentence(String s) {
        String[] word = s.split(" ");
        String[] ans = new String[word.length];

        for(int i=0; i<word.length; i++){
            char [] ch = word[i].toCharArray();
           
            char last = ch[ch.length-1];
            int index = last - '0';
           
            ans[index-1] = word[i].substring(0, word[i].length()-1);
    

        }
        return String.join(" ", ans);

        
    }
}