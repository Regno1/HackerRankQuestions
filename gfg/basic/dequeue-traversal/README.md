# Deque Traversal

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given a deque  **dq** containing integer elements, the task is to traverse the  **dq**  and print elements of it. 
 **Note** : Print a newline at the end.

 **Examples:** 

```
Input: dq = [1, 2, 3, 4, 5]
Output: 1 2 3 4 5
Explanation: dq will look like [1, 2, 3, 4, 5].
```

```
Input: dq = [1]
Output: 1
Explanation: dq will look like [1].
```

 **Constraints:** 
1 ≤ dq.size() ≤ 105

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-30T13:42:23.389Z  

```java
class Solution {
    public static void printDeque(ArrayDeque<Integer> deq) {
        // code here
       for(Iterator<Integer> iq= deq.iterator(); iq.hasNext();){
           System.out.print(iq.next() +" ");
       }
       System.out.println();
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/dequeue-traversal/1)