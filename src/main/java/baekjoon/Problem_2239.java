package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import baekjoon.config.ProblemInterface;

public class Problem_2239 implements ProblemInterface {

    private static final int ROW = 0, COL = 1, GRID = 2;
    private static int[][] sudokuVisitBoard;
    private static int[][] sudoku;

    private static List<Point> emptyPointList;
    private static boolean flag;

    private static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sudokuVisitBoard = new int[3][9];
        sudoku = new int[9][9];

        emptyPointList = new ArrayList<>();
        flag = false;

        for (int row = 0; row < 9; row++) {
            char[] st = br.readLine().toCharArray();
            for (int col = 0; col < 9; col++) {
                int number = st[col] - '0';
                if (number == 0) {
                    emptyPointList.add(new Point(row, col));
                    continue;
                }

                sudoku[row][col] = number;
                sudokuVisitBoard[ROW][row] |= 1 << number;
                sudokuVisitBoard[COL][col] |= 1 << number;
                sudokuVisitBoard[GRID][row / 3 * 3 + col / 3] |= 1 << number;
            }
        }

        fillSudoku(0);

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                bw.write(sudoku[row][col] + "");
            }
            bw.newLine();
        }
        bw.flush();
    }

    private static boolean hasSameNumber(Point point, int number) {
        return hasRowSameNumber(point, number) || hasColSameNumber(point, number)
                || hasBlockSameNumber(point, number);
    }

    private static boolean hasRowSameNumber(Point point, int number) {
        return (sudokuVisitBoard[ROW][point.row] & 1 << number) != 0;
    }

    private static boolean hasColSameNumber(Point point, int number) {
        return (sudokuVisitBoard[COL][point.col] & 1 << number) != 0;
    }

    private static boolean hasBlockSameNumber(Point point, int number) {
        return (sudokuVisitBoard[GRID][point.row / 3 * 3 + point.col / 3] & 1 << number) != 0;
    }

    private static void fillSudoku(int pointIndex) {
        if (pointIndex == emptyPointList.size()) {
            flag = true;
            return;
        }
        Point currentPoint = emptyPointList.get(pointIndex);

        for (int i = 1; i <= 9 && !flag; i++) {
            if (hasSameNumber(currentPoint, i)) {
                continue;
            }

            sudokuVisitBoard[ROW][currentPoint.row] |= 1 << i;
            sudokuVisitBoard[COL][currentPoint.col] |= 1 << i;
            sudokuVisitBoard[GRID][currentPoint.row / 3 * 3 + currentPoint.col / 3] |= 1 << i;

            sudoku[currentPoint.row][currentPoint.col] = i;
            fillSudoku(pointIndex + 1);

            sudokuVisitBoard[ROW][currentPoint.row] &= ~(1 << i);
            sudokuVisitBoard[COL][currentPoint.col] &= ~(1 << i);
            sudokuVisitBoard[GRID][currentPoint.row / 3 * 3 + currentPoint.col / 3] &= ~(1 << i);
        }
    }
}
