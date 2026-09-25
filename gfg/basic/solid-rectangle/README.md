# Solid Rectangle

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given two integers  **n**  and  **m**, print a solid rectangle pattern of n rows and m columns using the "  *" character.

 **Note:**  There is a space between two adjacent stars (*) in the pattern.

 **Examples:** 

```
Input: n = 3, m = 5
Output:
 **   **  *
 **   **  *
 **   **  *

```

```
Input: n = 4, m = 2
Output:
 ** 
 **  
 **   
 **  

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-25T05:45:26.307Z  

```java
import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // code here
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/solid-rectangle/1)