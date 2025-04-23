package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1064 implements ProblemInterface {

    private static class Point {

        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Point[] points = new Point[3];

        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(Double.parseDouble(st.nextToken()),
                Double.parseDouble(st.nextToken()));
        }

        if (getInclinationRatio(points[0], points[1])
            == getInclinationRatio(points[0], points[2])) {
            System.out.println(-1.0);
            return;
        }

        double[] distances = new double[points.length];
        for (int i = 0, index = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++, index++) {
                distances[index] = getDistance(points[i], points[j]);
            }
        }

        Arrays.sort(distances);
        double maxPerimeter = distances[1] + distances[2];
        double minPerimeter = distances[0] + distances[1];

        System.out.print((maxPerimeter - minPerimeter) * 2);

    }

    private static double getDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    private static double getInclinationRatio(Point p1, Point p2) {
        return Math.abs(p1.y - p2.y) / Math.abs(p1.x - p2.x);
    }
}
