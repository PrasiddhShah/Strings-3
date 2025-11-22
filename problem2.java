// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Approach here is to use stack and firstly do the "*" before doing anything else
we maintain 2 var "cur" and "lastSign", first to track the latest number seen and second to keep track of the lastest sign seen
push the element to stack if a sign is encountered, while pushing check the lastsign if it was + or - push the number this that sign
if it is * or /(not required for this problem) pop one element from the stack and do * or / on the popped and the curent num and push that it

once everything is processed
take another while loop, keep popping till stack is empty and keep adding the nums

*/

class Solution {
    public int calculate(String s) {
        s = s.trim();
        int n = s.length();
        char lastSign = '+';
        int cur = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                cur = cur * 10 + ch - '0';

            }
            if (i == n - 1 || (!Character.isDigit(ch) && ch != ' ')) {
                if (lastSign == '+') {
                    st.push(cur);
                } else if (lastSign == '-') {
                    st.push(-cur);
                } else if (lastSign == '*') {
                    int num = st.pop();
                    st.push(num * cur);

                } else {
                    int num = st.pop();
                    st.push(num / cur);

                }
                lastSign = ch;
                cur = 0;
            }
        }
        int ans = 0;
        while (!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }
}