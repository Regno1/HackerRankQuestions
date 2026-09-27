import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // code here
        int last= n%10;
        if(n<0){
            System.out.print(-last);
        }else{
            
        
        System.out.print(last);
        }
    }
}