package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_31861 implements ProblemInterface {

    private static final int MOD = 1_000_000_007;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[M][26];
        for (int alphabet = 0; alphabet < 26; alphabet++) {
            if (alphabet - N >= 0 || alphabet + N < 26) {
                dp[0][alphabet] = 1;
            }
        }

        for (int m = 1; m < M; m++) {
            for (int alphabet = 0; alphabet < 26; alphabet++) {
                for (int prevAlphabet = alphabet - N; prevAlphabet >= 0; prevAlphabet--) {
                    dp[m][prevAlphabet] += dp[m - 1][alphabet];
                    dp[m][prevAlphabet] %= MOD;
                }

                int nextAlphabet = alphabet + N;
                if (N == 0) {
                    nextAlphabet++;
                }

                for (; nextAlphabet < 26; nextAlphabet++) {
                    dp[m][nextAlphabet] += dp[m - 1][alphabet];
                    dp[m][nextAlphabet] %= MOD;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 26; i++) {
            answer += dp[M - 1][i];
            answer %= MOD;
        }

        System.out.print(answer);
    }
}
