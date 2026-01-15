package baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import baekjoon.config.ProblemInterface;

public class Problem_2757 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            Point location = parseRC(br.readLine());

            if (location.x == 0 && location.y == 0) {
                break;
            }

            String colStr = toExcelColumn(location.y);
            sb.append(colStr).append(location.x).append('\n');
        }
        System.out.print(sb);
    }

    private static Point parseRC(String rc) {
        String[] parts = rc.substring(1).split("C");
        int row = Integer.parseInt(parts[0]);
        int col = Integer.parseInt(parts[1]);
        return new Point(row, col);
    }

    private static String toExcelColumn(int col) {
        StringBuilder sb = new StringBuilder();
        while (col > 0) {
            col--;
            sb.insert(0, (char) ('A' + (col % 26)));
            col /= 26;
        }
        return sb.toString();
    }

}
