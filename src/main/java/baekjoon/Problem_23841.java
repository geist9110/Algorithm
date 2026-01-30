package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_23841 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String color = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = color.charAt(j);
                if (c == '.') {
                    sb.append(color.charAt(M - j - 1));
                } else {
                    sb.append(c);
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

}
