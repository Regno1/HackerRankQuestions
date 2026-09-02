import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        try {
    if(a <= 0 || b <= 0) {
        throw new Exception("Breadth and height must be positive");
    }

    int area = a * b;
    System.out.println(area);
}
catch(Exception e) {
    System.out.println(e);
}
        }
        
        }
    
