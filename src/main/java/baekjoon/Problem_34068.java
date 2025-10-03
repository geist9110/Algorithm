package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_34068 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] duelResult = new long[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            duelResult[Integer.parseInt(st.nextToken())]++;
        }

        Arrays.sort(duelResult);
        long result = 0;
        for (int i = 2; i <= N; i++) {
            if (duelResult[i] > duelResult[i - 1]) {
                continue;
            }
            result += duelResult[i - 1] - duelResult[i] + 1;
            duelResult[i] = duelResult[i - 1] + 1;
        }

        System.out.print(result);
    }
}
