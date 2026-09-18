# Find the Point

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Consider two points, $p = (p_x, p_y)$ and $q = (q_x, q_y)$. We consider the inversion or [point reflection](https://en.wikipedia.org/wiki/Point_reflection), $r = (r_x, r_y)$, of point $p$ across point $q$ to be a $180°$ rotation of point $p$ around $q$.

Given $n$ sets of points $p$ and $q$, find $r$ for each pair of points and print two space-separated integers denoting the respective values of $r_x$ and $r_y$ on a new line.  

**Function Description**  

Complete the *findPoint* function in the editor below.  

*findPoint* has the following parameters:  

- *int px, py, qx, qy:* x and y coordinates for points $p$ and $q$  

**Returns**  

- *int[2]:* x and y coordinates of the reflected point $r$  

**Input Format**

The first line contains an integer, $n$, denoting the number of sets of points.		
Each of the $n$ subsequent lines contains four space-separated integers that describe the respective values of $p_x$, $p_y$, $q_x$, and $q_y$ defining points $p = (p_x, p_y)$ and $q = (q_x, q_y)$. 

**Constraints**

- $1 \le n \le 15$  
- $-100 \le p_x, p_y, q_x, q_y \le 100$  

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-18T06:20:41.041Z  

```java
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'findPoint' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER px
     *  2. INTEGER py
     *  3. INTEGER qx
     *  4. INTEGER qy
     */

    public static List<Integer> findPoint(int px, int py, int qx, int qy) {
    // Write your code here
     List<Integer> a=new ArrayList<>();
     int rx=qx+(qx-px);
     int ry=qy+(qy-py);
     a.add(rx);
     a.add(ry);
     return a;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        for (int nItr = 0; nItr < n; nItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int px = Integer.parseInt(firstMultipleInput[0]);

            int py = Integer.parseInt(firstMultipleInput[1]);

            int qx = Integer.parseInt(firstMultipleInput[2]);

            int qy = Integer.parseInt(firstMultipleInput[3]);

            List<Integer> result = Result.findPoint(px, py, qx, qy);

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(String.valueOf(result.get(i)));

                if (i != result.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/find-point/problem)