package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_2589 implements ProblemInterface {

    private static boolean[][] map;
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static int L;
    private static int W;

    private static class Node {
        int row;
        int col;
        int depth;

        public Node(int row, int col, int depth) {
            this.row = row;
            this.col = col;
            this.depth = depth;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new boolean[L][W];
        for (int i = 0; i < L; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = line.charAt(j) == 'L';
            }
        }

        int maxDepth = 0;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j]) {
                    maxDepth = Math.max(maxDepth, bfs(i, j));
                }
            }
        }

        System.out.print(maxDepth);
    }

    private static int bfs(int row, int col) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[L][W];
        visited[row][col] = true;
        queue.add(new Node(row, col, 0));
        int depth = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            depth = Math.max(depth, current.depth);
            for (int[] direction : DIRECTIONS) {
                int nextRow = current.row + direction[0];
                int nextCol = current.col + direction[1];
                if (nextRow < 0 || nextRow >= L || nextCol < 0 || nextCol >= W) {
                    continue;
                }
                if (visited[nextRow][nextCol]) {
                    continue;
                }
                if (map[nextRow][nextCol]) {
                    queue.add(new Node(nextRow, nextCol, current.depth + 1));
                    visited[nextRow][nextCol] = true;
                }
            }
        }
        return depth;
    }

}
