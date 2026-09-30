class Solution {
    public static boolean isPowerofTwo(int n) {
        // code here
        if(n==0){
            return false;
        }
        else if(n==1){
            return true;
        }
        return ((n &(n-1))==0) ? true: false;
        
    }
}