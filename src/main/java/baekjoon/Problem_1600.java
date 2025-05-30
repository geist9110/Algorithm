package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1600 implements ProblemInterface {

    private static final int[][] CROSS_DIRECTION = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final int[][] HORSE_DIRECTION = {{1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2},
        {-2, 1}, {-2, -1}, {-1, -2}};

    private static int[][] map;
    private static boolean[][][] visit;
    private static int K;
    private static int H;
    private static int W;

    private static class Node {

        int row;
        int col;
        int depth;
        int k;

        public Node(int row, int col, int depth, int k) {
            this.row = row;
            this.col = col;
            this.depth = depth;
            this.k = k;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for (int row = 0; row < H; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < W; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[H][W][K + 1];
        visit[0][0][0] = true;

        System.out.println(bfs(0, 0));
    }

    public static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0, K));
        visit[x][y][K] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.row == H - 1 && node.col == W - 1) {
                return node.depth;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = node.row + CROSS_DIRECTION[i][0];
                int nextCol = node.col + CROSS_DIRECTION[i][1];
                if (nextRow >= 0 && nextCol >= 0 && nextRow < H && nextCol < W
                    && !visit[nextRow][nextCol][node.k]
                    && map[nextRow][nextCol] == 0) {
                    visit[nextRow][nextCol][node.k] = true;
                    queue.offer(new Node(nextRow, nextCol, node.depth + 1, node.k));
                }
            }

            if (node.k > 0) {
                for (int i = 0; i < 8; i++) {
                    int nextRow = node.row + HORSE_DIRECTION[i][0];
                    int nextCol = node.col + HORSE_DIRECTION[i][1];
                    if (nextRow >= 0 && nextCol >= 0 && nextRow < H && nextCol < W
                        && !visit[nextRow][nextCol][node.k - 1]
                        && map[nextRow][nextCol] == 0) {
                        visit[nextRow][nextCol][node.k - 1] = true;
                        queue.offer(new Node(nextRow, nextCol, node.depth + 1, node.k - 1));
                    }
                }
            }
        }
        return -1;
    }
}
