class Solution {

    Set<String> st = new HashSet<>();
    int maxLen = 0;

    public void solve(String s, int i, String curr, int count) {

        if(count < 0) {
            return;
        }

        if(i == s.length()) {

            if(count == 0) {

                if(curr.length() > maxLen) {
                    maxLen = curr.length();
                    st.clear();
                }

                if(curr.length() == maxLen) {
                    st.add(curr);
                }
            }

            return;
        }

        char ch = s.charAt(i);

        if(ch != '(' && ch != ')') {

            solve(s, i + 1, curr + ch, count);

            return;
        }

        curr += ch;

        if(ch == '(') {
            solve(s, i + 1, curr, count + 1);
        } else {
            solve(s, i + 1, curr, count - 1);
        }

        curr = curr.substring(0, curr.length() - 1);

        solve(s, i + 1, curr, count);
    }

    public List<String> removeInvalidParentheses(String s) {

        st.clear();
        maxLen = 0;

        solve(s, 0, "", 0);

        return new ArrayList<>(st);
    }
}