class Solution {
    static String delAlternate(String s) {
        // code here
        String a="";
        for(int i=0;i<s.length();i+=2){
            a+=s.charAt(i);
        }
        return a;
    }
}