package baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_1063 implements ProblemInterface {

    private static final Map<String, int[]> DIRECTIONS = Map.of(
            "R", new int[] { 0, 1 },
            "L", new int[] { 0, -1 },
            "B", new int[] { 1, 0 },
            "T", new int[] { -1, 0 },
            "RT", new int[] { -1, 1 },
            "LT", new int[] { -1, -1 },
            "RB", new int[] { 1, 1 },
            "LB", new int[] { 1, -1 });

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Point king = fromChessBoard(st.nextToken());
        Point stone = fromChessBoard(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            int[] direction = DIRECTIONS.get(br.readLine());

            Point nextKing = move(king, direction);
            if (!isInBound(nextKing)) {
                continue;
            }

            if (nextKing.equals(stone)) {
                Point nextStone = move(stone, direction);
                if (!isInBound(nextStone)) {
                    continue;
                }

                stone = nextStone;
            }
            king = nextKing;
        }

        System.out.printf("%s\n%s", fromPoint(king), fromPoint(stone));
    }

    private static Point fromChessBoard(String p) {
        int row = 8 - (p.charAt(1) - '0');
        int col = p.charAt(0) - 'A';
        return new Point(row, col);
    }

    private static Point move(Point p, int[] direction) {
        return new Point(p.x + direction[0], p.y + direction[1]);
    }

    private static boolean isInBound(Point p) {
        return p.x >= 0 && p.x < 8 && p.y >= 0 && p.y < 8;
    }

    private static String fromPoint(Point p) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) (p.y + 'A')).append(8 - p.x);
        return sb.toString();
    }
}
