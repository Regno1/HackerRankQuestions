

    static boolean isAnagram(String x, String y) {
        int[] a=new int[26];
        int[] b=new int[26];
        x= x.toLowerCase();
        y=y.toLowerCase();
        boolean m=false;
        if(x.length()!=y.length()) return false;
        for(char ch:x.toCharArray()){
            a[ch-'a']++;
        }
         for(char ch:y.toCharArray()){
            b[ch-'a']++;
        }
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i])  m=true;
            
        }
        if(m){
            return false;
        }
        return true;
    }

