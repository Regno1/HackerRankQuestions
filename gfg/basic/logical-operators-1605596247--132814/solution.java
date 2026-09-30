class Solution {
    public String booleanOperations(boolean a, boolean b) {
        // Code here
        boolean c=a & b;
        boolean d=a || b;
        boolean e=!a;
        String m=c+" "+d+ " "+e;
        return m;
    }
}