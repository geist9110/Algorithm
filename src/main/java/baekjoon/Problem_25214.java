package baekjoon;

import baekjoon.config.ProblemInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_25214 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int minValue = Integer.MAX_VALUE;
        int maxDiff = 0;

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            maxDiff = Math.max(maxDiff, value - minValue);
            sb.append(maxDiff).append(" ");
            minValue = Math.min(minValue, value);
        }
        System.out.print(sb);
    }
}
