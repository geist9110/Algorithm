package baekjoon;

import baekjoon.config.ProblemInterface;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_20125 implements ProblemInterface {

    private static final char EMPTY = '_';
    private static final char COOKIE = '*';

    private static char[][] map;
    private static int N;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int row = 0; row < N; row++) {
            String s = br.readLine();
            for (int col = 0; col < N; col++) {
                map[row][col] = s.charAt(col);
            }
        }

        Point head = findHead();
        Point heart = new Point(head.x + 1, head.y);

        Point leftArm = getPartLastPoint(heart, new int[]{0, -1});
        Point rightArm = getPartLastPoint(heart, new int[]{0, 1});
        Point waist = getPartLastPoint(heart, new int[]{1, 0});
        Point leftLeg = getPartLastPoint(new Point(waist.x + 1, waist.y - 1), new int[]{1, 0});
        Point rightLeg = getPartLastPoint(new Point(waist.x + 1, waist.y + 1), new int[]{1, 0});

        sb.append(heart.x + 1).append(" ").append(heart.y + 1).append("\n");
        sb.append(heart.y - leftArm.y).append(" ")
            .append(rightArm.y - heart.y).append(" ")
            .append(waist.x - heart.x).append(" ")
            .append(leftLeg.x - waist.x).append(" ")
            .append(rightLeg.x - waist.x);

        System.out.print(sb);
    }

    private static Point findHead() {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (map[row][col] == COOKIE) {
                    return new Point(row, col);
                }
            }
        }
        return null;
    }

    private static Point getPartLastPoint(Point p, int[] direction) {
        Point nextPoint = new Point(p.x + direction[0], p.y + direction[1]);

        if (nextPoint.x < 0 || nextPoint.x >= N || nextPoint.y < 0 || nextPoint.y >= N) {
            return p;
        }

        if (map[nextPoint.x][nextPoint.y] == EMPTY) {
            return p;
        }

        return getPartLastPoint(nextPoint, direction);
    }
}
