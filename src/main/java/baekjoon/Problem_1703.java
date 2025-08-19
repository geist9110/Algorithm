package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1703 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());

            if (age == 0) {
                break;
            }

            long leaves = 1;
            for (int i = 0; i < age; i++) {
                long splittingFactor = Long.parseLong(st.nextToken());
                long pruning = Long.parseLong(st.nextToken());
                leaves = leaves * splittingFactor - pruning;
            }
            sb.append(leaves).append("\n");
        }

        System.out.print(sb);
    }
}
