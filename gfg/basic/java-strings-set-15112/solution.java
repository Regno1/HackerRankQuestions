class Solution {
    static String conRevstr(String s1, String s2) {
        // code here
        String s=s1+s2;
        String m="";
        for(int i=s.length()-1;i>=0;i--){
            m+=s.charAt(i);
        }
        return m;
    }
}