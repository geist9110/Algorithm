package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_12100 implements ProblemInterface {

    private static int result;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = 0;
        game(board, 0);
        System.out.print(result);

    }

    private static void game(int[][] board, int depth) {
        if (depth == 5) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    result = Math.max(result, board[i][j]);
                }
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            board = rotate(board);
            game(pushTop(board), depth + 1);
        }
    }

    private static int[][] pushTop(int[][] board) {
        Queue<Integer> queue = new LinkedList<>();
        int[][] pushedBoard = new int[board.length][board[0].length];
        for (int col = 0; col < board[0].length; col++) {
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] == 0) {
                    continue;
                }
                queue.add(board[row][col]);
            }

            int rowIndex = 0;
            while (!queue.isEmpty()) {
                if (queue.size() == 1) {
                    pushedBoard[rowIndex++][col] = queue.poll();
                    continue;
                }
                int first = queue.poll();

                if (first == queue.peek()) {
                    pushedBoard[rowIndex++][col] = first * 2;
                    queue.poll();
                    continue;
                }

                pushedBoard[rowIndex++][col] = first;
            }
        }

        return pushedBoard;
    }

    private static int[][] rotate(int[][] board) {
        int[][] rotatedBoard = new int[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                rotatedBoard[col][board.length - row - 1] = board[row][col];
            }
        }

        return rotatedBoard;
    }
}
