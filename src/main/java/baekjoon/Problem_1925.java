package baekjoon;

import baekjoon.config.ProblemInterface;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1925 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Point[] points = new Point[3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i] = new Point(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            );
        }

        double[] distances = new double[3];
        for (int i = 0; i < 3; i++) {
            distances[i] = calcDistanceSquare(points[i], points[(i + 1) % 3]);
        }

        Arrays.sort(distances);
        if (Math.sqrt(distances[0]) + Math.sqrt(distances[1]) <= Math.sqrt(distances[2])) {
            System.out.print("X");
            return;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if (distances[0] + distances[1] < distances[2]) {
            bw.write("Dunkak");
        } else if (distances[0] + distances[1] == distances[2]) {
            bw.write("Jikkak");
        } else {
            bw.write("Yeahkak");
        }

        if (distances[0] == distances[1] || distances[1] == distances[2]) {
            bw.write("2Triangle");
        } else {
            bw.write("Triangle");
        }

        bw.flush();
    }

    private static double calcDistanceSquare(Point p1, Point p2) {
        return Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2);
    }
}
