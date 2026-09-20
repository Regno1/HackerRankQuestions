# Maximum Score of Non-overlapping Intervals

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given a 2D integer array `intervals`, where `intervals[i] = [li, ri, weighti]`. Interval `i` starts at position `li` and ends at `ri`, and has a weight of `weighti`. You can choose  *up to*  4  **non-overlapping**  intervals. The  **score**  of the chosen intervals is defined as the total sum of their weights.

Return the lexicographically smallest array of at most 4 indices from `intervals` with  **maximum**  score, representing your choice of non-overlapping intervals.

Two intervals are said to be  **non-overlapping**  if they do not share any points. In particular, intervals sharing a left or right boundary are considered overlapping.

 

 **Example 1:** 

 **Input:**  intervals = [[1,3,2],[4,5,2],[1,5,5],[6,9,3],[6,7,1],[8,9,1]]

 **Output:**  [2,3]

 **Explanation:** 

You can choose the intervals with indices 2, and 3 with respective weights of 5, and 3.

 **Example 2:** 

 **Input:**  intervals = [[5,8,1],[6,7,7],[4,7,3],[9,10,6],[7,8,2],[11,14,3],[3,5,5]]

 **Output:**  [1,3,5,6]

 **Explanation:** 

You can choose the intervals with indices 1, 3, 5, and 6 with respective weights of 7, 6, 3, and 5.

 

 **Constraints:** 

- 1 <= intevals.length <= 5 * 104
- intervals[i].length == 3
- intervals[i] = [li, ri, weighti]
- 1 <= li <= ri <= 109
- 1 <= weighti <= 109

## Solution

**Language:** Java  
**Runtime:** 86 ms (beats 84.72%)  
**Memory:** 165.5 MB (beats 66.36%)  
**Submitted:** 2026-09-20T05:12:10.497Z  

```java
class Solution {

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        // [start, end, weight, originalIndex]
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by start
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            return Integer.compare(a[1], b[1]);
        });

        // next[i] = first interval whose start > arr[i][1]
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = binarySearch(arr, arr[i][1], i + 1);
        }

        /*
            dp[i][k] = maximum weight we can get
                       starting from i
                       with at most k intervals.
        */
        long[][] dp = new long[n + 1][5];

        /*
            chosen[i][k] = indices producing dp[i][k]
        */
        int[][][] chosen = new int[n + 1][5][];

        for (int k = 0; k <= 4; k++) {
            chosen[n][k] = new int[0];
        }

        for (int i = n - 1; i >= 0; i--) {

            chosen[i][0] = new int[0];

            for (int k = 1; k <= 4; k++) {

                // Option 1: skip current interval
                long skipWeight = dp[i + 1][k];
                int[] skipIndices = chosen[i + 1][k];

                // Option 2: take current interval
                int j = next[i];

                long takeWeight =
                        arr[i][2] + dp[j][k - 1];

                int[] takeIndices =
                        addAndSort(arr[i][3], chosen[j][k - 1]);

                // Compare
                if (takeWeight > skipWeight) {

                    dp[i][k] = takeWeight;
                    chosen[i][k] = takeIndices;

                } else if (takeWeight < skipWeight) {

                    dp[i][k] = skipWeight;
                    chosen[i][k] = skipIndices;

                } else {

                    dp[i][k] = takeWeight;

                    if (lexicographicallySmaller(
                            takeIndices,
                            skipIndices)) {

                        chosen[i][k] = takeIndices;

                    } else {

                        chosen[i][k] = skipIndices;
                    }
                }
            }
        }

        return chosen[0][4];
    }


    // First interval whose start > end
    private int binarySearch(int[][] arr, int end, int left) {

        int right = arr.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid][0] > end) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }


    private int[] addAndSort(int index, int[] other) {

        int[] result = new int[other.length + 1];

        result[0] = index;

        for (int i = 0; i < other.length; i++) {
            result[i + 1] = other[i];
        }

        Arrays.sort(result);

        return result;
    }


    private boolean lexicographicallySmaller(
            int[] a,
            int[] b) {

        int n = Math.min(a.length, b.length);

        for (int i = 0; i < n; i++) {

            if (a[i] != b[i]) {
                return a[i] < b[i];
            }
        }

        return a.length < b.length;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-score-of-non-overlapping-intervals/)