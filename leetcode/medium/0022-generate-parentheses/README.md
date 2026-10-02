# Generate Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given `n` pairs of parentheses, write a function to  *generate all combinations of well-formed parentheses*.

 

 **Example 1:** 

```
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

```

 **Example 2:** 

```
Input: n = 1
Output: ["()"]

```

 

 **Constraints:** 

- 1 <= n <= 8

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 44.4 MB (beats 79.36%)  
**Submitted:** 2026-10-02T15:14:26.066Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/generate-parentheses/)