class Solution {
    public Deque<Integer> dqInsertion(List<Integer> arr) {
        // code here
        Deque<Integer> dq= new ArrayDeque<>();
        for(int i=0;i<arr.size();i++){
            dq.add(arr.get(i));
        }
        return dq;
    }
}