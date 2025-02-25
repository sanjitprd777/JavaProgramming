package coding.CSES150;

import java.io.PrintWriter;
import java.util.Scanner;

public class WeirdAlgorithm {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long n;
        n = sc.nextLong();
        PrintWriter out = new PrintWriter(System.out);
        while(n!=1) {
            out.print(n + " ");
            if ((n%2)==0)
                n/=2;
            else {
                n *= 3;
                n++;
            }
        }
        out.print(1);
        out.close();
    }
}
