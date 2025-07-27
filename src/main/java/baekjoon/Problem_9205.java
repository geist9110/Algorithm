package baekjoon;

import baekjoon.config.ProblemInterface;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_9205 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Point> points = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points.add(new Point(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
                ));
            }

            boolean[][] graph = new boolean[n + 2][n + 2];
            for (int i = 0; i < n + 2; i++) {
                for (int j = 0; j < n + 2; j++) {
                    if (getDistance(points.get(i), points.get(j)) <= 1000) {
                        graph[i][j] = true;
                        graph[j][i] = true;
                    }
                }
            }

            boolean[] visited = new boolean[n + 2];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            visited[0] = true;
            boolean isHappy = false;
            while (!queue.isEmpty() && !isHappy) {
                Integer current = queue.poll();
                for (int i = 0; i < n + 2; i++) {
                    if (graph[current][i] && !visited[i]) {
                        if (i == n + 1) {
                            isHappy = true;
                            break;
                        }
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
            if(isHappy){
                bw.write("happy\n");
                continue;
            }
            bw.write("sad\n");
        }
        bw.flush();
    }

    private static int getDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}
