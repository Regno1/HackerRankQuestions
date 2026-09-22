# Find X Value of Array II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an array of  **positive**  integers `nums` and a  **positive**  integer `k`. You are also given a 2D array `queries`, where `queries[i] = [indexi, valuei, starti, xi]`.

You are allowed to perform an operation  **once**  on `nums`, where you can remove any  **suffix**  from `nums` such that `nums` remains  **non-empty**.

The  **x-value**  of `nums`  **for a given**  `x` is defined as the number of ways to perform this operation so that the  **product**  of the remaining elements leaves a  *remainder*  of `x`  **modulo**  `k`.

For each query in `queries` you need to determine the  **x-value**  of `nums` for `xi` after performing the following actions:

- Update nums[indexi] to valuei. Only this step persists for the rest of the queries.
- Remove the prefix nums[0..(starti - 1)] (where nums[0..(-1)] will be used to represent the empty prefix).

Return an array `result` of size `queries.length` where `result[i]` is the answer for the `ith` query.

A  **prefix**  of an array is a subarray that starts from the beginning of the array and extends to any point within it.

A  **suffix**  of an array is a subarray that starts at any point within the array and extends to the end of the array.

 **Note**  that the prefix and suffix to be chosen for the operation can be  **empty**.

 **Note**  that x-value has a  *different*  definition in this version.

 

 **Example 1:** 

 **Input:**  nums = [1,2,3,4,5], k = 3, queries = [[2,2,0,2],[3,3,3,0],[0,1,0,1]]

 **Output:**  [2,2,2]

 **Explanation:** 

- For query 0, nums becomes [1, 2, 2, 4, 5], and the empty prefix must be removed. The possible operations are: Remove the suffix [2, 4, 5]. nums becomes [1, 2]. Remove the empty suffix. nums becomes [1, 2, 2, 4, 5] with a product 80, which gives remainder 2 when divided by 3.
- For query 1, nums becomes [1, 2, 2, 3, 5], and the prefix [1, 2, 2] must be removed. The possible operations are: Remove the empty suffix. nums becomes [3, 5]. Remove the suffix [5]. nums becomes [3].
- For query 2, nums becomes [1, 2, 2, 3, 5], and the empty prefix must be removed. The possible operations are: Remove the suffix [2, 2, 3, 5]. nums becomes [1]. Remove the suffix [3, 5]. nums becomes [1, 2, 2].

 **Example 2:** 

 **Input:**  nums = [1,2,4,8,16,32], k = 4, queries = [[0,2,0,2],[0,2,0,1]]

 **Output:**  [1,0]

 **Explanation:** 

- For query 0, nums becomes [2, 2, 4, 8, 16, 32]. The only possible operation is: Remove the suffix [2, 4, 8, 16, 32].
- For query 1, nums becomes [2, 2, 4, 8, 16, 32]. There is no possible way to perform the operation.

 **Example 3:** 

 **Input:**  nums = [1,1,2,1,1], k = 2, queries = [[2,1,0,1]]

 **Output:**  [5]

 

 **Constraints:** 

- 1 <= nums[i] <= 109
- 1 <= nums.length <= 105
- 1 <= k <= 5
- 1 <= queries.length <= 2 * 104
- queries[i] == [indexi, valuei, starti, xi]
- 0 <= indexi <= nums.length - 1
- 1 <= valuei <= 109
- 0 <= starti <= nums.length - 1
- 0 <= xi <= k - 1

## Solution

**Language:** Java  
**Runtime:** 278 ms (beats 21.05%)  
**Memory:** 279.1 MB (beats 47.37%)  
**Submitted:** 2026-09-22T13:05:07.539Z  

```java
class Node {
    int[] cnt = new int[5];
    int prod = 0;
}

class SegmentTree {
    int n, k;
    Node[] segTree;

    SegmentTree(int[] nums, int k) {
        this.k = k;
        this.n = nums.length;
        segTree = new Node[4 * n];
        for (int i = 0; i < 4 * n; i++) {
            segTree[i] = new Node();
        }
        build(0, 0, n - 1, nums);
    }

    void build(int i, int l, int r, int[] nums) {
        if (l == r) {
            leafNode(i, nums[l]);
            return;
        }

        int mid = l + (r - l) / 2;
        build(2 * i + 1, l, mid, nums);
        build(2 * i + 2, mid + 1, r, nums);
        segTree[i] = mergeNodes(segTree[2 * i + 1], segTree[2 * i + 2]);
    }

    void leafNode(int i, int value) { //represents 1 element nums[i];
        for (int x = 0; x < k; x++) {
            segTree[i].cnt[x] = 0;
        }

        int r = value % k;
        segTree[i].cnt[r] = 1;
        segTree[i].prod = r;
    }

    Node mergeNodes(Node left, Node right) {
        Node result = new Node();
        result.prod = (left.prod * right.prod) % k;

        for (int x = 0; x < k; x++) {
            result.cnt[x] = left.cnt[x];
        }
        for (int x = 0; x < k; x++) {
            int newRem = (left.prod * x) % k;
            result.cnt[newRem] += right.cnt[x];
        }

        return result;
    }

    void segTreeUpdate(int i, int l, int r, int index, int value) {
        if (l == r) {
            leafNode(i, value);
            return;
        }

        int mid = l + (r - l) / 2;
        if (index <= mid) {
            segTreeUpdate(2 * i + 1, l, mid, index, value);
        } else {
            segTreeUpdate(2 * i + 2, mid + 1, r, index, value);
        }

        segTree[i] = mergeNodes(segTree[2 * i + 1], segTree[2 * i + 2]);
    }

    void update(int index, int value) {
        segTreeUpdate(0, 0, n - 1, index, value);
    }

    Node segTreeQuery(int start, int end, int i, int l, int r) {
        if (l >= start && r <= end) {
            return segTree[i];
        }

        int mid = l + (r - l) / 2;
        if (end <= mid) {
            return segTreeQuery(start, end, 2 * i + 1, l, mid);
        }
        if (start > mid) {
            return segTreeQuery(start, end, 2 * i + 2, mid + 1, r);
        }

        Node left  = segTreeQuery(start, end, 2 * i + 1, l, mid);
        Node right = segTreeQuery(start, end, 2 * i + 2, mid + 1, r);

        return mergeNodes(left, right);
    }

    Node query(int start, int end) {
        //range is [start, end]
        //i = 0 -> index of root node of segment tree which covers the range of 0...n-1 of nums
        return segTreeQuery(start, end, 0, 0, n - 1);
    }
}

class Solution {
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        SegmentTree segTree = new SegmentTree(nums, k);
        int[] result = new int[queries.length];

        for (int idx = 0; idx < queries.length; idx++) {
            int index = queries[idx][0];
            int value = queries[idx][1];
            int start = queries[idx][2];
            int x     = queries[idx][3];

            segTree.update(index, value);

            Node node = segTree.query(start, n - 1);

            result[idx] = node.cnt[x];
        }

        return result;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/find-x-value-of-array-ii/)