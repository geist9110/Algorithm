package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_16946 implements ProblemInterface {

    private static final int[][] DIRECTION = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int N, M;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int row = 0; row < N; row++) {
            String line = br.readLine();
            for (int col = 0; col < M; col++) {
                map[row][col] = line.charAt(col) - '0';
            }
        }

        boolean[][] visit = new boolean[N][M];
        Queue<int[]> wallQueue = new LinkedList<>();
        Queue<int[]> movableQueue = new LinkedList<>();

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (visit[row][col]) {
                    continue;
                }

                if (map[row][col] != 0) {
                    continue;
                }

                int count = 0;
                movableQueue.add(new int[] {row, col});
                visit[row][col] = true;

                while (!movableQueue.isEmpty()) {
                    count++;
                    int[] current = movableQueue.poll();
                    for (int[] direction : DIRECTION) {
                        int nextRow = current[0] + direction[0];
                        int nextCol = current[1] + direction[1];

                        if (!isInBound(nextRow, nextCol)) {
                            continue;
                        }

                        if (visit[nextRow][nextCol]) {
                            continue;
                        }

                        visit[nextRow][nextCol] = true;

                        if (map[nextRow][nextCol] == 0) {
                            movableQueue.add(new int[] {nextRow, nextCol});
                            continue;
                        }

                        if (map[nextRow][nextCol] > 0) {
                            wallQueue.add(new int[] {nextRow, nextCol});
                        }

                    }
                }
                while (!wallQueue.isEmpty()) {
                    int[] current = wallQueue.poll();
                    map[current[0]][current[1]] += count;
                    visit[current[0]][current[1]] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                sb.append(map[row][col] % 10);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static boolean isInBound(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < M;
    }
}
