# Brace Expansion II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Under the grammar given below, strings can represent a set of lowercase words. Let `R(expr)` denote the set of words the expression represents.

The grammar can best be understood through simple examples:

- Single letters represent a singleton set containing that word. R("a") = {"a"} R("w") = {"w"}
- When we take a comma-delimited list of two or more expressions, we take the union of possibilities. R("{a,b,c}") = {"a","b","c"} R("{{a,b},{b,c}}") = {"a","b","c"} (notice the final set only contains each word at most once)
- When we concatenate two expressions, we take the set of possible concatenations between two words where the first word comes from the first expression and the second word comes from the second expression. R("{a,b}{c,d}") = {"ac","ad","bc","bd"} R("a{b,c}{d,e}f{g,h}") = {"abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"}

Formally, the three rules for our grammar:

- For every lowercase letter x, we have R(x) = {x}.
- For expressions e1, e2,..., ek with k >= 2, we have R({e1, e2,...}) = R(e1) ∪ R(e2) ∪...
- For expressions e1 and e2, we have R(e1 + e2) = {a + b for (a, b) in R(e1) × R(e2)}, where + denotes concatenation, and × denotes the cartesian product.

Given an expression representing a set of words under the given grammar, return  *the sorted list of words that the expression represents*.

 

 **Example 1:** 

```
Input: expression = "{a,b}{c,{d,e}}"
Output: ["ac","ad","ae","bc","bd","be"]

```

 **Example 2:** 

```
Input: expression = "{{a,z},a{b,c},{ab,z}}"
Output: ["a","ab","ac","z"]
Explanation: Each distinct word is written only once in the final answer.

```

 

 **Constraints:** 

- 1 <= expression.length <= 60
- expression[i] consists of '{', '}', ','or lowercase English letters.
- The given expression represents a set of words based on the grammar given in the description.

## Solution

**Language:** Java  
**Runtime:** 9 ms (beats 82.40%)  
**Memory:** 47.1 MB (beats 72.00%)  
**Submitted:** 2026-09-25T14:01:27.611Z  

```java
class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> result = solve(expression, 0, expression.length() - 1);

        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);

        return ans;
    }

    private Set<String> solve(String s, int l, int r) {
        Set<String> result = new HashSet<>();

        // Single character
        if (l == r) {
            result.add(String.valueOf(s.charAt(l)));
            return result;
        }

        // Remove outer braces if they enclose the whole expression
        if (s.charAt(l) == '{' && matchingBrace(s, l) == r) {
            return solve(s, l + 1, r - 1);
        }

        int balance = 0;
        int start = l;

        // First handle top-level union
        for (int i = l; i <= r; i++) {
            char ch = s.charAt(i);

            if (ch == '{') {
                balance++;
            } else if (ch == '}') {
                balance--;
            } else if (ch == ',' && balance == 0) {   //  a,{b,c},d

                result.addAll(solve(s, start, i - 1));
                start = i + 1;
            }
        }

        // If a top-level comma existed
        if (start != l) {
            result.addAll(solve(s, start, r));
            return result;
        }

        // Otherwise, this is concatenation
        balance = 0;

        for (int i = l; i < r; i++) {
            char ch = s.charAt(i);   //{a,b} {c,d}

            if (ch == '{') {
                balance++;
            } else if (ch == '}') {
                balance--;
            }

            // Split at a valid concatenation point
            if (balance == 0) {
                Set<String> left = solve(s, l, i);
                Set<String> right = solve(s, i + 1, r);

                for (String a : left) {
                    for (String b : right) {
                        result.add(a + b);
                    }
                }

                return result;
            }
        }

        return result;
    }

    private int matchingBrace(String s, int start) {
        int balance = 0;

        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                balance++;
            } else if (s.charAt(i) == '}') {
                balance--;

                if (balance == 0) {
                    return i;
                }
            }
        }

        return -1;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/brace-expansion-ii/)