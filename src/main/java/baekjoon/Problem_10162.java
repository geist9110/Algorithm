package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10162 implements ProblemInterface {

    private static final int[] times = {300, 60, 10};

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int time : times) {
            int count = N / time;
            sb.append(count + " ");
            N %= time;
        }

        if (N != 0) {
            System.out.print(-1);
            return;
        }

        System.out.print(sb);
    }
}
