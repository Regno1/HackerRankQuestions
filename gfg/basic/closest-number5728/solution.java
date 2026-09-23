class Solution {
    static int closestNumber(int n, int m) {

      int q=n/m;
      
      int n1=q*m;
      
      int n2= n*m>0 ?((q+1)*m):( (q-1)*m);
      if(Math.abs(n-n1)<Math.abs(n-n2)) return n1;
      return n2;
      
    }
}