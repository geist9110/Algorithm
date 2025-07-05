package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_4485 implements ProblemInterface {

    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    private static class Node {
        int row;
        int col;
        int cost;

        public Node(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int problem = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean[][] visited = new boolean[n][n];
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
            pq.add(new Node(0, 0, map[0][0]));
            visited[0][0] = true;

            while (!pq.isEmpty()) {
                Node current = pq.poll();
                if (current.row == n - 1 && current.col == n - 1) {
                    sb.append("Problem ").append(problem).append(": ").append(current.cost).append("\n");
                    break;
                }

                for (int[] direction : DIRECTIONS) {
                    int newRow = current.row + direction[0];
                    int newCol = current.col + direction[1];
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        pq.add(new Node(newRow, newCol, current.cost + map[newRow][newCol]));
                    }
                }
            }

            problem++;
        }

        System.out.print(sb.toString());
    }

}
