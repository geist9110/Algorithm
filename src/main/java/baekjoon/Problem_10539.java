package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_10539 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long prev = 0;
        for (int i = 1; i <= N; i++) {
            long current = Long.parseLong(st.nextToken()) * i;
            sb.append(current - prev).append(" ");
            prev = current;
        }

        System.out.print(sb);
    }
}
