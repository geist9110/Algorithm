package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_14916 implements ProblemInterface {

    private static final int[] coins = {2, 5};

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] remains = new int[100_001];
        Arrays.fill(remains, Integer.MAX_VALUE);
        for (int coin : coins) {
            remains[coin] = 1;
        }
        remains[4] = 2;

        for (int i = 6; i <= n; i++) {
            for (int coin : coins) {
                if (remains[i - coin] == Integer.MAX_VALUE) {
                    continue;
                }
                remains[i] = Math.min(remains[i], remains[i - coin] + 1);
            }
        }

        if (remains[n] == Integer.MAX_VALUE) {
            System.out.print(-1);
            return;
        }
        System.out.println(remains[n]);
    }
}
