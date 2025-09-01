package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem_27495 implements ProblemInterface {

    private static class MiddleTarget {

        String target;
        String[] detailTargets;

        public MiddleTarget(String target, String[] detailTargets) {
            this.target = target;
            Arrays.sort(detailTargets);
            this.detailTargets = detailTargets;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[][] board = new String[9][9];
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = st.nextToken();
            }
        }

        MiddleTarget[] middleTargets = new MiddleTarget[8];
        int index = 0;
        for (int rowIndex = 0; rowIndex < 3; rowIndex++) {
            for (int colIndex = 0; colIndex < 3; colIndex++) {
                if (rowIndex == 1 && colIndex == 1) {
                    continue;
                }

                int row = rowIndex * 3 + 1;
                int col = colIndex * 3 + 1;
                middleTargets[index++] = new MiddleTarget(
                    board[row][col],
                    new String[]{
                        board[row - 1][col - 1], board[row - 1][col], board[row - 1][col + 1],
                        board[row][col - 1], board[row][col + 1],
                        board[row + 1][col - 1], board[row + 1][col], board[row + 1][col + 1]
                    }
                );
            }
        }
        Arrays.sort(middleTargets, Comparator.comparing(o -> o.target));

        for (int i = 0; i < middleTargets.length; i++) {
            sb.append("#").append(i + 1).append(". ").append(middleTargets[i].target).append("\n");
            for (int j = 0; j < middleTargets[i].detailTargets.length; j++) {
                sb.append("#").append(i + 1).append("-").append(j + 1).append(". ")
                    .append(middleTargets[i].detailTargets[j]).append("\n");
            }
        }

        System.out.print(sb);
    }
}
