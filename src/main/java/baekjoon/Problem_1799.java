package baekjoon;

import baekjoon.config.ProblemInterface;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_1799 implements ProblemInterface {

    private static boolean[] selectRowQueen;
    private static boolean[] selectColumnQueen;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int rotatedBoardSize = 2 * N - 1;
        selectRowQueen = new boolean[rotatedBoardSize];
        selectColumnQueen = new boolean[rotatedBoardSize];

        List<Point> whiteEmptyCell = new ArrayList<>();
        List<Point> blackEmptyCell = new ArrayList<>();

        for (int row = 0; row < N; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                if (st.nextToken().equals("1")) {
                    if ((row + col) % 2 == 0) {
                        whiteEmptyCell.add(new Point(row + col, N - 1 - row + col));
                        continue;
                    }
                    blackEmptyCell.add(new Point(row + col, N - 1 - row + col));
                }
            }
        }

        int whiteCellQueenCount = dfs(0, 0, whiteEmptyCell);
        int blackCellQueenCount = dfs(0, 0, blackEmptyCell);
        System.out.print(whiteCellQueenCount + blackCellQueenCount);
    }

    private static int dfs(int selectQueenCount, int depth, List<Point> emptyCell) {
        int result = selectQueenCount;

        for (int nextIndex = depth; nextIndex < emptyCell.size(); nextIndex++) {
            Point nextPoint = emptyCell.get(nextIndex);
            if (!selectColumnQueen[nextPoint.y] && !selectRowQueen[nextPoint.x]) {
                selectColumnQueen[nextPoint.y] = true;
                selectRowQueen[nextPoint.x] = true;
                result = Math.max(result, dfs(selectQueenCount + 1, nextIndex + 1, emptyCell));
                selectColumnQueen[nextPoint.y] = false;
                selectRowQueen[nextPoint.x] = false;
            }
        }

        return result;
    }
}

