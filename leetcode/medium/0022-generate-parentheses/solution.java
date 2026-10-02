class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, n, ans);
        return ans;
    }

    void backtrack(StringBuilder current, int open, int close, int n, List<String> ans) {
        if (current.length() == 2 * n) {
            ans.add(current.toString());
            return;
        }
        if (open < n) {
            current.append('(');
            backtrack(current, open + 1, close, n, ans);
            current.deleteCharAt(current.length() - 1);
        }
        if (close < open) {
            current.append(')');
            backtrack(current, open, close + 1, n, ans);
            current.deleteCharAt(current.length() - 1);
        }
    }
}