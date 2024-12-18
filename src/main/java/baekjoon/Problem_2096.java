package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2096 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] maxPrev = new int[3];
        int[] minPrev = new int[3];

        int maxLeft = 0, maxRight = 0, minLeft = 0, minRight = 0;

        for (int row = 0; row < N; row++) {
            maxPrev[0] = maxLeft + matrix[row][0];
            maxPrev[1] = Math.max(maxLeft, maxRight) + matrix[row][1];
            maxPrev[2] = maxRight + matrix[row][2];

            maxLeft = Math.max(maxPrev[0], maxPrev[1]);
            maxRight = Math.max(maxPrev[1], maxPrev[2]);

            minPrev[0] = minLeft + matrix[row][0];
            minPrev[1] = Math.min(minLeft, minRight) + matrix[row][1];
            minPrev[2] = minRight + matrix[row][2];

            minLeft = Math.min(minPrev[0], minPrev[1]);
            minRight = Math.min(minPrev[1], minPrev[2]);
        }

        System.out.printf("%d %d", Math.max(maxLeft, maxRight), Math.min(minLeft, minRight));
    }
}
