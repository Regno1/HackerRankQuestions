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