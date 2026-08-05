class Solution {
    public boolean wordPattern(String pattern, String s) {

        HashMap<Character, String> hm = new HashMap<>();

        String[] arr = s.split(" ");

        if (pattern.length() != arr.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);
            boolean containsKey = hm.containsKey(ch);

            // Same word cannot be mapped to different characters
            if (hm.containsValue(arr[i]) && !containsKey) {
                return false;
            }

            if (containsKey) {
                if (!hm.get(ch).equals(arr[i])) {
                    return false;
                }
            } else {
                hm.put(ch, arr[i]);
            }
        }

        return true;
    }
}