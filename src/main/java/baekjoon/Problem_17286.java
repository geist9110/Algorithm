package baekjoon;

import baekjoon.config.ProblemInterface;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem_17286 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Point yumi = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Point[] users = new Point[3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            users[i] = new Point(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            );
        }

        double minDistance = Double.MAX_VALUE;
        for (int first = 0; first < 3; first++) {
            for (int second = 0; second < 3; second++) {
                if (first == second) {
                    continue;
                }
                minDistance = Math.min(minDistance,
                    getDistance(yumi, users[first])
                        + getDistance(users[first], users[second])
                        + getDistance(users[second], users[3 - first - second])
                );
            }
        }

        System.out.print((int) minDistance);
    }

    private static double getDistance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }
}
