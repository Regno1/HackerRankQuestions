# Closest to n and Divisible by m

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given two integers  **n**  and  **m** (m != 0). The problem is to find the number closest to  **n**  and divisible by  **m**. If there is more than one such number, then output the one having the maximum absolute value.

 **Examples :** 

```
Input: n = 13, m = 4
Output: 12
Explanation: 12 is the Closest Number to 13 which is divisible by 4.
```

```
Input: n = -15, m = 6
Output: -18
Explanation: Both -12 and -18 are closest to -15 and divisible by 6, but -18 has the maximum absolute value. So, output is -18.
```

 **Constraints:** 
-105 ≤ n, m ≤ 105

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T18:29:48.313Z  

```java
class Solution {
    static int closestNumber(int n, int m) {

      int q=n/m;
      
      int n1=q*m;
      
      int n2= n*m>0 ?((q+1)*m):( (q-1)*m);
      if(Math.abs(n-n1)<Math.abs(n-n2)) return n1;
      return n2;
      
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/closest-number5728/1)