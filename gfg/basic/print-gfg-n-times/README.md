# Print GFG n times

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given a positive number  **n**, print the string " **GFG** " exactly n times separated by a single space.

 **Examples:** 

```
Input: n = 5
Output:
GFG GFG GFG GFG GFG
```

```
Input: 3
Output:
GFG GFG GFG
```

 **Constraint:** 
1 ≤ n ≤ 103

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-30T07:13:36.830Z  

```java
import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i=0;
        // code here
        while(i<n){
            System.out.print("GFG ");
            i++;
        }
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/print-gfg-n-times/1)