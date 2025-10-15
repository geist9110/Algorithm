package baekjoon;

import baekjoon.config.ProblemInterface;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1531 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[101][101];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Point leftBottom = new Point(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            );
            Point rightTop = new Point(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            );

            for (int row = leftBottom.y; row <= rightTop.y; row++) {
                for (int col = leftBottom.x; col <= rightTop.x; col++) {
                    map[row][col]++;
                }
            }
        }

        int result = 0;
        for (int row = 0; row <= 100; row++) {
            for (int col = 0; col <= 100; col++) {
                if (map[row][col] > M) {
                    result++;
                }
            }
        }

        System.out.print(result);
    }
}
