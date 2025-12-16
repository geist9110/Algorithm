package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_31423 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] universities = new String[N + 1];
        int[] next = new int[N + 1];
        int[] tail = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            universities[i] = br.readLine();
            tail[i] = i;
        }

        int current = 0;
        for (int index = 1; index < N; index++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            next[tail[i]] = j;
            tail[i] = tail[j];
            current = i;
        }

        for (int i = 1; i <= N; i++) {
            sb.append(universities[current]);
            current = next[current];
        }

        System.out.print(sb);

    }

}
