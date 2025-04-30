package baekjoon;

import baekjoon.config.ProblemInterface;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1711 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));
        }

        long[] distances = new long[3];

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                distances[0] = calcDistanceSquare(points[i], points[j]);
                for (int k = j + 1; k < N; k++) {
                    distances[1] = calcDistanceSquare(points[i], points[k]);
                    distances[2] = calcDistanceSquare(points[j], points[k]);

                    if (distances[0] + distances[1] == distances[2]
                        || distances[0] + distances[2] == distances[1]
                        || distances[1] + distances[2] == distances[0]) {
                        result++;
                    }
                }
            }
        }

        System.out.print(result);
    }

    private static long calcDistanceSquare(Point p1, Point p2) {
        long x = p1.x - p2.x;
        long y = p1.y - p2.y;
        return x * x + y * y;
    }
}
