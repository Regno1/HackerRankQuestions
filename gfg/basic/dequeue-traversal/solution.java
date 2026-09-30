class Solution {
    public static void printDeque(ArrayDeque<Integer> deq) {
        // code here
       for(Iterator<Integer> iq= deq.iterator(); iq.hasNext();){
           System.out.print(iq.next() +" ");
       }
       System.out.println();
    }
}