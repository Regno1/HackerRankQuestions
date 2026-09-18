# Maximum Draws

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
**Submitted:** 2026-09-18T06:22:22.208Z  

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
     * Complete the 'maximumDraws' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int maximumDraws(int n) {
    // Write your code here
return n+1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            int result = Result.maximumDraws(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/maximum-draws/problem)