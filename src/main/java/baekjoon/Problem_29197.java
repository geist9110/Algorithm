package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem_29197 implements ProblemInterface {

    private static final int HALF = 10_000;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[20_001][20_001];
        int result = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int divide = gcd(Math.abs(x), Math.abs(y));
            x /= divide;
            y /= divide;
            x += HALF;
            y += HALF;

            if (map[x][y]) {
                continue;
            }
            map[x][y] = true;
            result++;
        }

        System.out.print(result);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
