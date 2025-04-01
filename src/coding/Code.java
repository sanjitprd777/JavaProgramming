package coding;

import java.time.LocalDateTime;
import java.util.*;

/*
Problem Description
You are given an integer array arr of size n. You need to perform operations on this array to convert all its elements to 0.

In one operation, you can select a prefix of the given array and increment or decrement all the elements of the prefix by 1.

A prefix is a contiguous subarray that includes the first element of the array. For example, in arr = [1, 2, 3, 4, 5], valid prefixes are: [1], [1, 2], [1, 2, 3], [1, 2, 3, 4], [1, 2, 3, 4, 5].

Find the minimum number of operations required to convert every element of the array to 0.

Constraints:
1 <= n <= 10^5
-10^9 <= arr[i] <= 10^9
Input
n = 5
arr = [3, 2, 0, 0, -1]
Output
result = 5
Explanation:
Select prefix length 2 and decrement → [2,1,0,0,−1]
Select prefix length 2 and decrement → [1,0,0,0,−1]
Select prefix length 1 and decrement → [0,0,0,0,−1]
Select prefix length 4 and decrement → [-1,-1,-1,-1,−1]
Select prefix length 5 and increment → [0,0,0,0,0]
 */

public class Code {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
        System.out.println(LocalDateTime.now().toLocalDate()); // YYYY-MM-DD HH:MM:SS.SSS
        System.out.println(System.currentTimeMillis());
    }
}