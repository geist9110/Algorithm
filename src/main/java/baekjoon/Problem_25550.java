package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_25550 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[][] boxes = new long[N][M];
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                boxes[row][col] = Long.parseLong(st.nextToken());
            }
        }

        long result = 0;
        for (int row = 1; row < N - 1; row++) {
            for (int col = 1; col < M - 1; col++) {
                if (boxes[row][col] <= 1) {
                    continue;
                }

                long localMin = Math.min(
                        Math.min(boxes[row - 1][col], boxes[row + 1][col]),
                        Math.min(boxes[row][col - 1], boxes[row][col + 1]));

                if (localMin >= boxes[row][col]) {
                    result += boxes[row][col] - 1;
                    continue;
                }

                result += localMin;
            }
        }

        System.out.print(result);
    }

}
