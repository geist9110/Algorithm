package baekjoon;

import baekjoon.config.ProblemInterface;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem_18221 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        Point professor = new Point(0, 0);
        Point sunggyu = new Point(0, 0);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 5) {
                    professor = new Point(i, j);
                }

                if (map[i][j] == 2) {
                    sunggyu = new Point(i, j);
                }
            }
        }

        double distance =
            Math.pow(professor.x - sunggyu.x, 2) + Math.pow(professor.y - sunggyu.y, 2);
        if (distance < 25) {
            System.out.print(0);
            return;
        }

        Point leftTop = new Point(
            Math.min(professor.x, sunggyu.x),
            Math.min(professor.y, sunggyu.y)
        );
        Point rightBottom = new Point(
            Math.max(professor.x, sunggyu.x),
            Math.max(professor.y, sunggyu.y)
        );

        int studentCount = 0;
        for (int row = leftTop.x; row <= rightBottom.x; row++) {
            for (int col = leftTop.y; col <= rightBottom.y; col++) {
                if (map[row][col] == 1) {
                    studentCount++;
                }
            }
        }

        if (studentCount >= 3) {
            System.out.println(1);
            return;
        }
        System.out.print(0);

    }
}
