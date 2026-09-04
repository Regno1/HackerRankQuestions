import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        int i=0;
        int n=A.length()-1;
        boolean a=true;
        while(i<=n){
            if(A.charAt(i)==A.charAt(n)){
                a= true;
                i++;
                n--;
            }else{
                a=false;
                break;
            }
        }
        System.out.println(a ? "Yes" : "No");
    }
}



