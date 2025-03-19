package coding.CSES150;

import java.io.PrintWriter;
import java.util.*;

public class Permutations {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n == 1) {
			System.out.println(1);
		} else if (n == 2 || n == 3) {
			System.out.println("NO SOLUTION");
		} else {
			Deque<Integer> list = new LinkedList<>(); // <Integer>
			// 2 4 1 3
			list.add(2);
			list.add(4);
			list.add(1);
			list.add(3);
			for (int i = 5; i <= n; ++i) {
				if ((i & 1) == 1)
					list.addFirst(i);
				else
					list.addLast(i);
			}
			PrintWriter out = new PrintWriter(System.out);
			for (int i = 0; i < n; ++i) {
				out.print(list.poll() + " ");
			}
			out.close();
		}
	}
}
