package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_10431 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int P = Integer.parseInt(br.readLine());
        for (int i = 1; i <= P; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());

            int[] line = new int[20];
            for (int j = 0; j < 20; j++) {
                line[j] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < j; k++) {
                    if (line[j] < line[k]) {
                        count++;
                    }
                }
            }
            sb.append(p).append(" ").append(count).append("\n");
        }
        System.out.print(sb);
    }
}
