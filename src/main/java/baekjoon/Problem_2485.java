package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2485 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] tree = new int[N];
        tree[0] = Integer.parseInt(br.readLine());
        int gcd = 0;
        for (int i = 1; i < N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
            gcd = gcd(tree[i] - tree[i - 1], gcd);
        }
        
        System.out.print((tree[N - 1] - tree[0]) / gcd - N + 1);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
