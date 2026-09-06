import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        s=s.replaceAll("\\s+", " ").trim();
        // Write your code here.
        String[] a= s.split("[\\s!,?._'@]+");
        if(s.isEmpty()) System.out.print(0);
        else System.out.println(a.length);
        for(String i:a){
            
            System.out.println(i);
        }
        scan.close();
    }
}

