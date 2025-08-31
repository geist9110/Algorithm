package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1895 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] image = new int[R][C];
        for (int row = 0; row < R; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < C; col++) {
                image[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] J = new int[R - 2][C - 2];
        for (int row = 1; row < R - 1; row++) {
            for (int col = 1; col < C - 1; col++) {
                int[] arr = {image[row - 1][col - 1], image[row - 1][col], image[row - 1][col + 1],
                    image[row][col - 1], image[row][col], image[row][col + 1],
                    image[row + 1][col - 1], image[row + 1][col], image[row + 1][col + 1]};
                Arrays.sort(arr);
                J[row - 1][col - 1] = arr[4];
            }
        }

        int T = Integer.parseInt(br.readLine());
        int result = 0;
        for (int row = 0; row < R - 2; row++) {
            for (int col = 0; col < C - 2; col++) {
                if (J[row][col] >= T) {
                    result++;
                }
            }
        }

        System.out.print(result);
    }
}
