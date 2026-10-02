class Solution {
    ArrayList<Integer> solve(int N, ArrayList<Integer> A, int Q,
                             ArrayList<Integer> Query) {
        // code here
         ArrayList<Integer> a= new ArrayList<>();
        if(Q==1){
            for(int i=0;i<N;i++){
            
            if(i==Query.get(0)){
                a.add(Query.get(1));
               
            }
            a.add(A.get(i));
                
            }
            
        }else if(Q==2){
                int p=Query.get(0);
                int lastindex=-1;
                for(int i=0;i<N;i++){
                    if(A.get(i)==p){
                    lastindex=i;
                    
                    }
                }
               a.add(lastindex); 
            }
        
            
        
            
                
      return a;
       
       
    }
}