class Solution {
    public String capitalizeTitle(String title) {

        String[] word = title.split(" ");

        for(int i=0; i<word.length; i++) {

            if(word[i].length() <=2) {
                word[i] = word[i].toLowerCase();

            } else {
                word[i] = word[i].toLowerCase();
                char first = word[i].charAt(0);
                first= Character.toUpperCase(first);
                String rem = word[i].substring(1);
                word[i] = first + rem ;
                
            }



        }
        return String.join(" ", word);
        
    }
}