import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        // code here
        int l=a>>b;
        int r=a<<b;
        
        System.out.print(l+" "+r );
    }
}