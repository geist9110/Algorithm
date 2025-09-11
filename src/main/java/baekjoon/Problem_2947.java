package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2947 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] array = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            boolean sorted = true;
            for (int i = 0; i < 4; i++) {
                if (array[i] <= array[i + 1]) {
                    continue;
                }

                sorted = false;
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;

                sb.append(array[0]).append(" ")
                    .append(array[1]).append(" ")
                    .append(array[2]).append(" ")
                    .append(array[3]).append(" ")
                    .append(array[4]).append("\n");
            }

            if (sorted) {
                break;
            }
        }

        System.out.print(sb);
    }
}
