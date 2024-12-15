package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_16953 implements ProblemInterface {

    private static long A, B, result;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        result = Long.MAX_VALUE;

        solve(A, 1);
        System.out.print(result == Long.MAX_VALUE ? -1 : result);
    }

    private static void solve(long number, long depth) {
        if (number > B) {
            return;
        }

        if (number == B) {
            result = Math.min(result, depth);
            return;
        }

        solve(number * 2, depth + 1);
        solve(number * 10 + 1, depth + 1);
    }
}
