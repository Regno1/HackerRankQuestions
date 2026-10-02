class Complete {
    public static ArrayList<Integer> array(int a[][], int b[], int n) {
        // Complete the function
        int sum=0;
        int j=0;
        int max=0;
        
        ArrayList<Integer> m= new ArrayList<>();
        for(int i=0;i<a.length;i++){
            if(b[j]>max){
                max=b[j];
            }
            if(i==j){
                sum+=a[i][j];
                j++;
            }
            
        }
       
        m.add(sum);
        m.add(max);
        return m;
    }
}
