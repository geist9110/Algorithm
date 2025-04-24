package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_1485 implements ProblemInterface {

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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            Point[] points = new Point[4];
            for (int i = 0; i < points.length; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i] = new Point(
                    Double.parseDouble(st.nextToken()),
                    Double.parseDouble(st.nextToken())
                );
            }

            double[] distances = new double[6];
            double diagonal = Double.MIN_VALUE;
            double side = Double.MAX_VALUE;
            for (int start = 0, index = 0; start < points.length; start++) {
                for (int end = start + 1; end < points.length; end++) {
                    distances[index] = getDistanceSquare(points[start], points[end]);

                    diagonal = Math.max(diagonal, distances[index]);
                    side = Math.min(side, distances[index]);

                    index++;
                }
            }

            int diagonalCount = 0;
            int sideCount = 0;

            for (double distance : distances) {
                if (diagonal == distance) {
                    diagonalCount++;
                    continue;
                }
                if (side == distance) {
                    sideCount++;
                }
            }

            if (diagonalCount == 2 && sideCount == 4) {
                bw.write("1\n");
                continue;
            }
            bw.write("0\n");
        }
        bw.flush();
    }

    private static double getDistanceSquare(Point p1, Point p2) {
        return Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2);
    }
}
