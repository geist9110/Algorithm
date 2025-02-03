package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_1535 implements ProblemInterface {

    private static final int MAX_HLEATH = 100;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] lostHealthPoint = new int[N];
        int[] getHappyPoint = new int[N];

        StringTokenizer healthString = new StringTokenizer(br.readLine());
        StringTokenizer happyString = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lostHealthPoint[i] = Integer.parseInt(healthString.nextToken());
            getHappyPoint[i] = Integer.parseInt(happyString.nextToken());
        }

        int[] dp = new int[MAX_HLEATH];
        for (int person = 0; person < N; person++) {
            for (int health = MAX_HLEATH - 1; health >= lostHealthPoint[person]; health--) {
                dp[health] = Math.max(dp[health],
                        dp[health - lostHealthPoint[person]] + getHappyPoint[person]);
            }
        }

        System.out.print(dp[MAX_HLEATH - 1]);
    }
}
