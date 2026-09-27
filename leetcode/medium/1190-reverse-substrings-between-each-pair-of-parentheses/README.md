# Reverse Substrings Between Each Pair of Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a string `s` that consists of lower case English letters and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should  **not**  contain any brackets.

 

 **Example 1:** 

```
Input: s = "(abcd)"
Output: "dcba"

```

 **Example 2:** 

```
Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.

```

 **Example 3:** 

```
Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.

```

 

 **Constraints:** 

- 1 <= s.length <= 2000
- s only contains lower case English characters and parentheses.
- It is guaranteed that all parentheses are balanced.

## Solution

**Language:** Java  
**Runtime:** 6 ms (beats 44.83%)  
**Memory:** 44.6 MB (beats 35.34%)  
**Submitted:** 2026-09-27T13:36:10.628Z  

```java
class Solution {
    public String reverseParentheses(String s) {

        Stack<String> stack = new Stack<>();
        String current = "";

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                stack.push(current);
                current = "";
            }

            else if (ch == ')') {
                current = new StringBuilder(current).reverse().toString();

                String previous = stack.pop();
                current = previous + current;
            }

            else {
                current = current + ch;
            }
        }

        return current;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/)