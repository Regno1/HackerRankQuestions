# Print Square

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given an integer  **n**, write a program to print the square of size  **n**  using "  *" character **.** 

 **Examples :** 

```
Input: n = 4
Output:
 **   ** 
 ** 
 ** 
 **   ** 
Explanation: It's a square! Each side contains n = 4.

```

```
Input: n = 3
Output:
 **  * 
 ** 
 **  *
Explanation: It's a square! Each side contains n = 3.
```

 **Constraints:** 
1 ≤ n ≤ 10

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-30T07:47:49.955Z  

```java
import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // code here
       for (int i = 1; i <= n; i++) {

           if (i == 1 || i == n) {
               for (int j = 1; j <= n; j++) {
                   System.out.print("*"+" ");
               }
           } else {
               System.out.print("*"+" ");

               for (int j = 1; j <= n - 2; j++) {
                   System.out.print(" "+" ");
               }

               System.out.print("*"+" ");
           }

           System.out.println();
       }
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/print-square--105330/1)