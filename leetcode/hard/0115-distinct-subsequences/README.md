# Distinct Subsequences

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given two strings s and t, return  *the number of distinct*   ***subsequences** ** of  *s*  which equals *t.

The test cases are generated so that the answer fits on a 32-bit signed integer.

 

 **Example 1:** 

```
Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabbbit
rabbbit
rabbbit

```

 **Example 2:** 

```
Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from s.
babgbag
babgbag
babgbag
babgbag
babgbag
```

 

 **Constraints:** 

- 1 <= s.length, t.length <= 1000
- s and t consist of English letters.

## Solution

**Language:** Java  
**Runtime:** 23 ms (beats 19.32%)  
**Memory:** 54.7 MB (beats 20.83%)  
**Submitted:** 2026-09-06T14:46:40.304Z  

```java
class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }
        return solve(s, t, 0, 0, dp);
    }

    private int solve(String s, String t, int i, int j, int[][] dp) {
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == t.charAt(j)) {
            int pick = solve(s, t, i + 1, j + 1, dp);
            int skip = solve(s, t, i + 1, j, dp);
            return dp[i][j] = pick + skip;
        }
        int skip = solve(s, t, i + 1, j, dp);
        return dp[i][j] = skip;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/distinct-subsequences/)