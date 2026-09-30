# Logical Operators

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Logical operators  **AND, OR, NOT** are used in condition checking. Like a  **AND** b checks if both a and b are true. a **OR**  b checks if either of a or b is true. !a complements the boolean value of a.

In this question you basically need to do
a  **&&** b
a || b
 **!** a

 **Examples:** 

```
Input: a = false, b = true
Output: false true true
Explanation: false AND true gives false. false OR true gives true. NOT false give true.
```

```
Input: a = true, b = true 
Output: true true false
Explanation: true AND true gives true. true OR true gives true. NOT true give false.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-30T12:20:27.657Z  

```java
class Solution {
    public String booleanOperations(boolean a, boolean b) {
        // Code here
        boolean c=a & b;
        boolean d=a || b;
        boolean e=!a;
        String m=c+" "+d+ " "+e;
        return m;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/logical-operators-1605596247--132814/1)