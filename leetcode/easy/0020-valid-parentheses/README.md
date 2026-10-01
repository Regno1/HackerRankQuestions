# Valid Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

- Open brackets must be closed by the same type of brackets.
- Open brackets must be closed in the correct order.
- Every close bracket has a corresponding open bracket of the same type.

 

 **Example 1:** 

 **Input:**  s = "()"

 **Output:**  true

 **Example 2:** 

 **Input:**  s = "()[]{}"

 **Output:**  true

 **Example 3:** 

 **Input:**  s = "(]"

 **Output:**  false

 **Example 4:** 

 **Input:**  s = "([])"

 **Output:**  true

 **Example 5:** 

 **Input:**  s = "([)]"

 **Output:**  false

 

 **Constraints:** 

- 1 <= s.length <= 104
- s consists of parentheses only '()[]{}'.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 97.69%)  
**Memory:** 43.3 MB (beats 57.06%)  
**Submitted:** 2026-10-01T06:12:37.622Z  

```java
class Solution {
    public boolean isValid(String s) {

        Deque<Character> stack= new ArrayDeque<>();
        for(char c: s.toCharArray()){
            if(c=='(' ||  c=='[' || c=='{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    if(c==')' && stack.peek()=='('){
                        stack.pop();
                    }else if(c==']' && stack.peek()=='['){
                        stack.pop();
                    }else if(c=='}' && stack.peek()=='{'){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
            
        }
        return (stack.isEmpty());
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/valid-parentheses/)