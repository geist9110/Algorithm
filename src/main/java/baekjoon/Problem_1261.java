package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_1261 implements ProblemInterface {

    private static class Node {
        int row;
        int col;
        int count;

        public Node(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 0));
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Node current = queue.pollFirst();

            if (current.row == N - 1 && current.col == M - 1) {
                System.out.println(current.count);
                return;
            }

            for (int[] direction : DIRECTIONS) {
                int nextX = current.row + direction[0];
                int nextY = current.col + direction[1];
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue;
                }

                if (visited[nextX][nextY]) {
                    continue;
                }

                visited[nextX][nextY] = true;

                if (map[nextX][nextY] == 1) {
                    queue.addLast(new Node(nextX, nextY, current.count + 1));
                } else {
                    queue.addFirst(new Node(nextX, nextY, current.count));
                }
            }
        }

    }

}
