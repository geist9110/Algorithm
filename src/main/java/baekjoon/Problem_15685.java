package baekjoon;

import baekjoon.config.ProblemInterface;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_15685 implements ProblemInterface {

    private static final int[][] DIRECTION = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    private static final int MAX_INDEX = 100;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] map = new boolean[MAX_INDEX + 1][MAX_INDEX + 1];

        for (int N = Integer.parseInt(br.readLine()); N > 0; N--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point startPoint = new Point(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            );

            int direction = Integer.parseInt(st.nextToken());
            int generation = Integer.parseInt(st.nextToken());

            ArrayList<Point> dragonCurve = new ArrayList<>();
            dragonCurve.add(startPoint);
            Point endPoint = new Point(
                startPoint.x + DIRECTION[direction][0],
                startPoint.y + DIRECTION[direction][1]
            );
            dragonCurve.add(endPoint);

            for (int g = 1; g <= generation; g++) {
                for (int i = dragonCurve.size() - 2; i >= 0; i--) {
                    dragonCurve.add(rotatePoint(dragonCurve.get(i), endPoint));
                }
                endPoint = dragonCurve.get(dragonCurve.size() - 1);
            }

            fillMap(map, dragonCurve);
        }

        int result = 0;
        for (int row = 0; row < MAX_INDEX; row++) {
            for (int col = 0; col < MAX_INDEX; col++) {
                if (isSquare(map, row, col)) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    private static Point rotatePoint(Point point, Point axisPoint) {
        return new Point(
            axisPoint.x + axisPoint.y - point.y,
            -axisPoint.x + axisPoint.y + point.x
        );
    }

    private static boolean isSquare(boolean[][] map, int row, int col) {
        return map[row][col] && map[row + 1][col] && map[row][col + 1] && map[row + 1][col + 1];
    }

    private static void fillMap(boolean[][] map, List<Point> dragonCurve) {
        for (Point point : dragonCurve) {
            map[point.y][point.x] = true;
        }
    }
}
