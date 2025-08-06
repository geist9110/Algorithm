package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_17829 implements ProblemInterface {

    private static int[][] array;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        array = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(get222Pooling(N, 0, 0));
    }

    private static int get222Pooling(int width, int row, int col) {
        if (width == 2) {
            return getSecondaryMax(
                array[row][col],
                array[row][col + 1],
                array[row + 1][col],
                array[row + 1][col + 1]
            );
        }

        return getSecondaryMax(
            get222Pooling(width / 2, row, col),
            get222Pooling(width / 2, row, col + width / 2),
            get222Pooling(width / 2, row + width / 2, col),
            get222Pooling(width / 2, row + width / 2, col + width / 2)
        );
    }

    private static int getSecondaryMax(int a, int b, int c, int d) {
        int[] arr = {a, b, c, d};
        Arrays.sort(arr);
        return arr[2];
    }
}
