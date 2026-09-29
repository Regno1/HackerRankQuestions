# Check if There Is a Valid Parentheses String Path

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

A parentheses string is a  **non-empty**  string consisting only of `'('` and `')'`. It is  **valid**  if  **any**  of the following conditions is  **true** :

- It is ().
- It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
- It can be written as (A), where A is a valid parentheses string.

You are given an `m x n` matrix of parentheses `grid`. A  **valid parentheses string path**  in the grid is a path satisfying  **all**  of the following conditions:

- The path starts from the upper left cell (0, 0).
- The path ends at the bottom-right cell (m - 1, n - 1).
- The path only ever moves down or right.
- The resulting parentheses string formed by the path is valid.

Return `true`  *if there exists a  **valid parentheses string path**  in the grid.*  Otherwise, return `false`.

 

 **Example 1:** 

```
Input: grid = [["(","(","("],[")","(",")"],["(","(",")"],["(","(",")"]]
Output: true
Explanation: The above diagram shows two possible paths that form valid parentheses strings.
The first path shown results in the valid parentheses string "()(())".
The second path shown results in the valid parentheses string "((()))".
Note that there may be other valid parentheses string paths.

```

 **Example 2:** 

```
Input: grid = [[")",")"],["(","("]]
Output: false
Explanation: The two possible paths form the parentheses strings "))(" and ")((". Since neither of them are valid parentheses strings, we return false.

```

 

 **Constraints:** 

- m == grid.length
- n == grid[i].length
- 1 <= m, n <= 100
- grid[i][j] is either '(' or ')'.

## Solution

**Language:** Java  
**Runtime:** 90 ms (beats 40.00%)  
**Memory:** 66.7 MB (beats 67.62%)  
**Submitted:** 2026-09-29T15:18:02.431Z  

```java
import java.util.*;

class Solution {
    public boolean hasValidPath(char[][] grid) {


        int m = grid.length;
        int n = grid[0].length;


        // Total path length must be even
        if ((m + n - 1) % 2 != 0) {
            return false;
        }


        // First character must be '('
        if (grid[0][0] == ')') {
            return false;
        }


        Queue<int[]> queue = new LinkedList<>();


        // {row, col, balance}
        queue.offer(new int[]{0, 0, 1});


        // visited[row][col][balance]
        boolean[][][] visited = new boolean[m][n][m + n];


        visited[0][0][1] = true;


        int[][] directions = {
            {1, 0},  // down
            {0, 1}   // right
        };


        while (!queue.isEmpty()) {


            int[] current = queue.poll();


            int row = current[0];
            int col = current[1];
            int balance = current[2];


            // Reached destination
            if (row == m - 1 && col == n - 1) {
                if (balance == 0) {
                    return true;
                }
            }


            for (int[] dir : directions) {


                int newRow = row + dir[0];
                int newCol = col + dir[1];


                // Out of bounds
                if (newRow >= m || newCol >= n) {
                    continue;
                }


                int newBalance = balance;


                if (grid[newRow][newCol] == '(') {
                    newBalance++;
                } else {
                    newBalance--;
                }


                // Invalid prefix
                if (newBalance < 0) {
                    continue;
                }


                // Already visited same state
                if (visited[newRow][newCol][newBalance]) {
                    continue;
                }


                visited[newRow][newCol][newBalance] = true;


                queue.offer(new int[]{
                    newRow,
                    newCol,
                    newBalance
                });
            }
        }


        return false;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/check-if-there-is-a-valid-parentheses-string-path/)