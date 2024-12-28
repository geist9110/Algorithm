package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_17144 implements ProblemInterface {

    private static int[][] map;
    private static int R, C;

    private static final int AIR_PURIFIER = -1;
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static final int CLOCKWISE = 1, COUNTERCLOCKWISE = 3;
    private static final int ROW = 0, COL = 1;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        int[] airPurifierRowIndex = new int[2];
        int airPurifierCount = 0;

        for (int row = 0; row < R; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < C; col++) {
                int value = Integer.parseInt(st.nextToken());

                if (value == AIR_PURIFIER) {
                    airPurifierRowIndex[airPurifierCount++] = row;
                }

                map[row][col] = value;
            }
        }

        for (int t = 0; t < T; t++) {
            expandDust();
            moveDust(airPurifierRowIndex[0], COUNTERCLOCKWISE);
            moveDust(airPurifierRowIndex[1], CLOCKWISE);
        }

        int result = 2;
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                result += map[row][col];
            }
        }

        System.out.print(result);
    }

    private static void expandDust() {
        int[][] expandedMap = new int[R][C];

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (!isFineDust(row, col)) {
                    continue;
                }

                int expandDustQuantity = map[row][col] / 5;
                for (int[] direction : DIRECTIONS) {
                    int expandDustRow = row + direction[0];
                    int expandDustCol = col + direction[1];
                    if (isInBoundary(expandDustRow, expandDustCol)
                        && isNotAirPurifier(expandDustRow, expandDustCol)) {
                        expandedMap[expandDustRow][expandDustCol] += expandDustQuantity;
                        expandedMap[row][col] -= expandDustQuantity;
                    }
                }
            }
        }

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < map[0].length; col++) {
                map[row][col] += expandedMap[row][col];
            }
        }
    }

    private static void moveDust(int row, int clockwise) {
        int direction = 0;
        int col = 1;
        int previousValue = 0, tempValue;

        while (isNotAirPurifier(row, col)) {
            int nextRow = row + DIRECTIONS[direction][ROW];
            int nextCol = col + DIRECTIONS[direction][COL];

            if (!isInBoundary(nextRow, nextCol)) {
                direction += clockwise;
                direction %= 4;
                continue;
            }

            tempValue = map[row][col];
            map[row][col] = previousValue;
            previousValue = tempValue;

            row = nextRow;
            col = nextCol;
        }
    }

    private static boolean isFineDust(int row, int col) {
        return map[row][col] > 0;
    }

    private static boolean isInBoundary(int row, int col) {
        return row >= 0 && row < R && col >= 0 && col < C;
    }

    private static boolean isNotAirPurifier(int row, int col) {
        return map[row][col] != AIR_PURIFIER;
    }
}
