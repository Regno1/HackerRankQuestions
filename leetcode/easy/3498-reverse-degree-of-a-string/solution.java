class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
        int value= s.charAt(i)-'a'+1;
        int reverse= 27-value ;
        sum+=(i+1)*reverse;


        }
        return sum;
    }
}