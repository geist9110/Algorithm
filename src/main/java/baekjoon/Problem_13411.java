package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_13411 implements ProblemInterface {

    private static class Point {

        int index;
        double time;

        public Point(int index, double time) {
            this.index = index;
            this.time = time;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Point[] points = new Point[N];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double dx = Double.parseDouble(st.nextToken());
            double dy = Double.parseDouble(st.nextToken());
            double speed = Double.parseDouble(st.nextToken());
            points[i - 1] = new Point(i, Math.sqrt(dx * dx + dy * dy) / speed);
        }

        Arrays.sort(points, (a, b) -> {
            if (a.time == b.time) {
                return a.index - b.index;
            }
            return Double.compare(a.time, b.time);
        });
        for (Point point : points) {
            sb.append(point.index).append("\n");
        }
        System.out.print(sb);
    }
}
