package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_33573 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            long N = Long.parseLong(br.readLine());
            long NReverse = Long.parseLong(
                new StringBuilder(String.valueOf(N))
                    .reverse()
                    .toString()
            );

            if (isSquareNumber(N) && isSquareNumber(NReverse)) {
                sb.append("YES\n");
                continue;
            }

            sb.append("NO\n");
        }

        System.out.print(sb);
    }

    private static boolean isSquareNumber(long n) {
        long sqrt = (long) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
