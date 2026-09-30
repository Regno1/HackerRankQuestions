import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
       ch = Character.toLowerCase(ch);
       
        // code here
        if(ch=='a' || ch=='e'|| ch=='i'|| ch=='o'|| ch=='u' ){
           System.out.print("true");
        }else{
            System.out.print("false");
        }
    }
}