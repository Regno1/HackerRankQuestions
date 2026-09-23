# Minimum Operations to Reduce X to Zero

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer array `nums` and an integer `x`. In one operation, you can either remove the leftmost or the rightmost element from the array `nums` and subtract its value from `x`. Note that this  **modifies**  the array for future operations.

Return  *the  **minimum number**  of operations to reduce* `x`  *to  **exactly***  `0`  *if it is possible**, otherwise, return* `-1`.

 

 **Example 1:** 

```
Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.

```

 **Example 2:** 

```
Input: nums = [5,6,7,8,9], x = 4
Output: -1

```

 **Example 3:** 

```
Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.

```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- 1 <= nums[i] <= 104
- 1 <= x <= 109

## Solution

**Language:** Java  
**Runtime:** 86 ms (beats 5.07%)  
**Memory:** 151 MB (beats 8.74%)  
**Submitted:** 2026-09-23T12:35:52.751Z  

```java
class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        // Step 1: Calculate total sum
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        // Step 2: Remaining subarray sum
        int target = total - x;

        if (target < 0) return -1;
        if (target == 0) return n;

        // Step 3: Prefix Sum + HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefixSum = 0;
        int maxLength = -1;

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];

            int required = prefixSum - target;

            if (map.containsKey(required)) {
                int length = i - map.get(required);
                maxLength = Math.max(maxLength, length);
            }

            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }

        // No valid subarray
        if (maxLength == -1) {
            return -1;
        }

        // Minimum operations
        return n - maxLength;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/)