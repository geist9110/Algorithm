package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_28238 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] totalCount = new int[21];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] array = new int[5];
            for (int j = 0; j < 5; j++) {
                array[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < 5; j++) {
                if (array[j] == 0) {
                    continue;
                }
                for (int k = j + 1; k < 5; k++) {
                    if (array[k] == 0) {
                        continue;
                    }
                    totalCount[(j + 1) * (k + 1)]++;
                }
            }
        }

        int maxCount = 0;
        int[] days = new int[5];
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if (totalCount[i * j] > maxCount) {
                    maxCount = totalCount[i * j];
                    days = new int[5];
                    days[i - 1] = 1;
                    days[j - 1] = 1;
                }
            }
        }

        if (maxCount == 0) {
            days[0] = 1;
            days[1] = 1;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxCount).append("\n");
        for (int i = 0; i < 5; i++) {
            sb.append(days[i]).append(" ");
        }
        System.out.print(sb);
    }
}
