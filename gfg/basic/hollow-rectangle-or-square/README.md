# Print Hollow Rectangle

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given two integers  **n**  and  **m**, print a hollow rectangle pattern consisting of n rows and m columns.

 **Examples:** 

```
Input: n = 3, m = 5
Output:
  *
 ** 
  *

```

```
Input: n = 4, m = 3
Output:
***
 ** 
 **   
*** 

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-25T05:54:07.303Z  

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
                if(i==1 || i==n){
            System.out.print("*");
                }else if(j==1){
                    System.out.print("*");
                }else if(j==m){
                    System.out.print("*");
                }else{
                 System.out.print(" ");
                }
                

            }
            System.out.println();
        }
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/hollow-rectangle-or-square/1)