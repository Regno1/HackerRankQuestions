# Last Digit of Number

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given an integer **n**  **.** Write a program to print the last digit of n **.** 

 **Examples:** 

```
Input: n = 10
Output: 0
```

```
Input: n = 9768
Output: 8

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-27T18:26:30.069Z  

```java
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // code here
        int last= n%10;
        if(n<0){
            System.out.print(-last);
        }else{
            
        
        System.out.print(last);
        }
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/last-digit-of-a-number--145429/1)