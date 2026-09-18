# Find the Point

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A person is getting ready to leave and needs a pair of matching socks.  If there are $n$ colors of socks in the drawer, how many socks need to be removed to be certain of having a matching pair?  

**Example**
$n = 2$  

There are $2$ colors of socks in the drawer.  If they remove $2$ socks, they may not match.  The minimum number to insure success is $3$.  

**Function Description**  

Complete the *maximumDraws* function in the editor below.  

*maximumDraws* has the following parameter:  

- *int n:* the number of colors of socks  

**Returns**  

- *int:* the minimum number of socks to remove to guarantee a matching pair. 

**Input Format**  
The first line contains the number of test cases, $t$.  
Each of the following $t$ lines contains an integer $n$.

**Constraints**  
$1 \le t \le 1000$  
$0 < n < 10^6$  

**Sample Input**

    2
    1
    2

**Sample Output**

    2
    3

**Explanation**  
Case 1 : Only 1 color of sock is in the drawer.  Any $2$ will match.    
Case 2 : 2 colors of socks are in the drawer. The first two removed may not match.  At least $3$ socks need to be removed to guarantee success.  

**Input Format**

 

**Constraints**

 

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-18T06:20:42.906Z  

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

[View on HackerRank](https://www.hackerrank.com/challenges/maximum-draws/problem)