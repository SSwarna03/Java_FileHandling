import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner scanner=new Scanner(System.in);
        try{
            int num1=scanner.nextInt();
            int num2=scanner.nextInt();
            System.out.println(num1/num2);
        }
        catch(ArithmeticException e1)
        {
            System.out.println("java.lang.ArithmeticException: / by zero");
        }
        catch(InputMismatchException e2)
        {
            System.out.println("java.util.InputMismatchException");
        }
}
}