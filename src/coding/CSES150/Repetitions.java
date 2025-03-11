package coding.CSES150;

import java.io.PrintWriter;
import java.util.*;

public class Repetitions {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		String s = sc.nextLine();
		char c = s.charAt(0);
		int count = 0;
		int ans = 0;
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == c) {
				++count;
			} else {
				c = s.charAt(i);
				ans = Math.max(ans, count);
				count = 0;
				--i;
			}
		}
		ans = Math.max(ans, count);
		out.println(ans);
		out.close();
	}
}
