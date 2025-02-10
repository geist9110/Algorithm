package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_11060 implements ProblemInterface {

    private static final int MAX_VALUE = 1_000_001;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] step = new int[N];
        Arrays.fill(step, MAX_VALUE);
        step[0] = 0;
        for (int i = 0; i < N; i++) {
            int nextStep = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= nextStep && i + j < N; j++) {
                step[i + j] = Math.min(step[i + j], step[i] + 1);
            }
        }

        if (step[N - 1] == MAX_VALUE) {
            System.out.print(-1);
            return;
        }
        System.out.print(step[N - 1]);
    }

}
