package coding.CSES150;

import java.io.PrintWriter;
import java.util.*;

public class IncreasingArray {
	/*
	Input:
5
3 2 5 1 7
Output:
5
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i)
			arr[i] = sc.nextInt();
		long ans = 0;
		for (int i = 1; i < n; ++i) {
			if (arr[i] < arr[i - 1]) {
				ans += arr[i - 1] - arr[i];
				arr[i] = arr[i - 1];
			}
		}

		out.println(ans);
		out.close();
	}
}
