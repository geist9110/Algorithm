package baekjoon;

import baekjoon.config.ProblemInterface;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_10655 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i] = new Point(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            );
        }

        int totalDistance = 0;
        int[] distances = new int[N];
        for (int i = 1; i < N; i++) {
            distances[i] = calcDistance(points[i - 1], points[i]);
            totalDistance += distances[i];
        }

        int skipDistance = Integer.MAX_VALUE;
        for (int i = 1; i < N - 1; i++) {
            skipDistance = Math.min(
                skipDistance,
                totalDistance - distances[i] - distances[i + 1] + calcDistance(points[i - 1],
                    points[i + 1]));
        }

        System.out.print(skipDistance);
    }

    private static int calcDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}
