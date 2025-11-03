package baekjoon;

import baekjoon.config.ProblemInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_33147 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int jump = gcd(N, K);

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(st.nextToken());

            if ((A - i) % jump != 0) {
                System.out.print("NO");
                return;
            }
        }
        System.out.print("YES");
    }

    private static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
