package coding.CSES150;

import java.util.Scanner;

public class MissingNumber {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
//        PrintWriter out = new PrintWriter(System.out);
        String s = sc.nextLine();
        String s1 = sc.nextLine();
        System.out.println(s);
        System.out.println(s1);
        String[] sl = new String[3];
        for (int i = 0; i < 3; ++i) {
            sl[i] = sc.next();
        }
        for (int i = 0; i < 3; ++i)
            System.out.println(sl[i]);
//        out.close();
    }
}
