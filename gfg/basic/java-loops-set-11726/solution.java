class Solution {
    static ArrayList<Integer> getSum(int N) {
        // code here
        ArrayList<Integer> a= new ArrayList<>();
        int e=0;
        int o=0;
        for(int i=1;i<=N;i++){
            if(i%2==0){
                e+=i;
            }else{
                o+=i;
            }
           
            
        }
         a.add(e);
        a.add(o);
        return a;
    }
}