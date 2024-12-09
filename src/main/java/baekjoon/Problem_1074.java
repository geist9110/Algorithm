package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1074 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long r = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.print(solve(N, r, c, (long) Math.pow(2, N)));
    }

    private static long solve(int N, long r, long c, long halfNum) {
        if (r == 0 && c == 0) {
            return 0;
        }
        halfNum /= 2;

        if (r >= halfNum && c >= halfNum) {
            return 3 * halfNum * halfNum + solve(N - 1, r - halfNum, c - halfNum, halfNum);
        }
        if (r >= halfNum) {
            return 2 * halfNum * halfNum + solve(N - 1, r - halfNum, c, halfNum);
        }
        if (c >= halfNum) {
            return halfNum * halfNum + solve(N - 2, r, c - halfNum, halfNum);
        }
        return solve(N - 1, r, c, halfNum);
    }
}
