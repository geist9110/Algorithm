package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_28126 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String operation = br.readLine();
        int maxRow = 0;
        int maxCol = 0;
        int diagonal = 0;

        for (int i = 0; i < N; i++) {
            char c = operation.charAt(i);
            if (c == 'U') {
                maxRow++;
                continue;
            }

            if (c == 'R') {
                maxCol++;
                continue;
            }

            diagonal++;
        }

        int result = 0;
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken()) - 1;
            int row = Integer.parseInt(st.nextToken()) - 1;

            int maxDiagonal = Math.min(diagonal, Math.min(col, row));
            col -= maxDiagonal;
            row -= maxDiagonal;

            if (col <= maxCol && row <= maxRow) {
                result++;
            }
        }

        System.out.print(result);
    }

}
