# Java Date and Time

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a [double-precision](https://en.wikipedia.org/wiki/Double-precision_floating-point_format) number, $payment$, denoting an amount of money, use the [NumberFormat](https://docs.oracle.com/javase/8/docs/api/java/text/NumberFormat.html) class' [getCurrencyInstance](https://docs.oracle.com/javase/8/docs/api/java/text/NumberFormat.html#getCurrencyInstance-java.util.Locale-) method to convert $payment$ into the US, Indian, Chinese, and French currency formats. Then print the formatted values as follows:

    US: formattedPayment
    India: formattedPayment
    China: formattedPayment
    France: formattedPayment
    
where $formattedPayment$ is $payment$ formatted according to the appropriate [Locale](https://docs.oracle.com/javase/8/docs/api/java/util/Locale.html)'s currency.

**Note:** India does not have a built-in Locale, so you must [construct one](https://docs.oracle.com/javase/8/docs/api/java/util/Locale.html#Locale-java.lang.String-java.lang.String-) where the language is `en` (i.e., English).

**Input Format**

A single double-precision number denoting $payment$.

**Constraints**

- $ 0 \le payment \le 10^{9}$

**Output Format**

On the first line, print `US: u` where $u$ is $payment$ formatted for US currency.		
On the second line, print `India: i` where $i$ is $payment$ formatted for Indian currency.		
On the third line, print `China: c` where $c$ is $payment$ formatted for Chinese currency.		
On the fourth line, print `France: f`, where $f$ is $payment$ formatted for French currency.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-04T06:32:35.578Z  

```java


class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
     Calendar cal= Calendar.getInstance();
     cal.set(year,month-1,day);
     
     String s= cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH).toUpperCase();
     return s;
    }

}


```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-currency-formatter/problem)