# Maximum Draws

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

At the annual meeting of Board of Directors of Acme Inc.  If everyone attending shakes hands exactly one time with every other attendee, how many handshakes are there?

**Example**  
$n = 3$  

There are $3$ attendees, $p1$, $p2$ and $p3$.  $p1$ shakes hands with $p2$ and $p3$, and $p2$ shakes hands with $p3$.  Now they have all shaken hands after $3$ handshakes.  

**Function Description**  

Complete the *handshakes* function in the editor below.  

*handshakes* has the following parameter:  

- *int n:*  the number of attendees  

**Returns**  

- *int:*  the number of handshakes  

**Input Format**  
The first line contains the number of test cases $t$.  
Each of the following $t$ lines contains an integer, $n$.   

**Constraints**  

$1 \le t \le 1000$  
$0 \lt n \lt 10^6$  

**Sample Input**

    2
    1
    2

**Sample Output**  

    0
    1

**Explanation**

Case 1 : The lonely board member shakes no hands, hence 0.   
Case 2 : There are 2 board members, so 1 handshake takes place. 

**Input Format**

 

**Constraints**

 

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-18T06:22:23.605Z  

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

[View on HackerRank](https://www.hackerrank.com/challenges/handshake/problem)