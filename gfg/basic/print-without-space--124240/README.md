# Print Without Space

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given two inputs that are stored in variables  **a** and  **b**, you need to print  **a** and  **b**  in a single line without space between them.
 **Note:**  Print a new line at the end after printing.

 **Examples:** 

```
Input: a = "Hello", b = "World"
Output: HelloWorld
Explanation: a and b are printed in a single line without space between them.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-30T08:14:16.533Z  

```java
class Solution {
    public void concatAndPrint(String a, String b) {
        // code here
        System.out.print(a+b);
        System.out.println();
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/print-without-space--124240/1)