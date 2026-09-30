class Solution {
    public static int findMean(int[] arr) {
        // code here
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        int avg= sum/arr.length;
        return avg;
    }
};