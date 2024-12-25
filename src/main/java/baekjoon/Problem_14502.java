package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_14502 implements ProblemInterface {

    private static final int EMPTY = 0, WALL = 1, VIRUS = 2;
    private static final int SELECT_WALL_COUNT = 3;
    private static final int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int[][] map;
    private static ArrayList<Integer> virusList;
    private static int N, M;
    private static int result;
    private static int[] selectedWalls;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        virusList = new ArrayList<>();

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                int inputValue = Integer.parseInt(st.nextToken());

                if (inputValue == VIRUS) {
                    virusList.add(row * M + col);
                }

                map[row][col] = inputValue;
            }
        }

        result = 0;
        selectedWalls = new int[SELECT_WALL_COUNT + 1];
        selectedWalls[0] = -1;
        selectWallAndCountEmpty(0);
        System.out.print(result);
    }

    private static void selectWallAndCountEmpty(int selectWallCount) {
        if (selectWallCount == SELECT_WALL_COUNT) {
            int[][] spreadMap = spreadVirus();
            result = Math.max(result, countEmpty(spreadMap));
            return;
        }

        for (int location = selectedWalls[selectWallCount] + 1; location < N * M; location++) {
            if (map[location / M][location % M] == EMPTY) {
                selectedWalls[selectWallCount + 1] = location;
                selectWallAndCountEmpty(selectWallCount + 1);
            }
        }
    }

    private static int[][] spreadVirus() {
        int[][] spreadMap = Arrays.stream(map).map(int[]::clone).toArray(int[][]::new);
        for (int i = 1; i < selectedWalls.length; i++) {
            spreadMap[selectedWalls[i] / M][selectedWalls[i] % M] = WALL;
        }

        Queue<Integer> queue = new LinkedList<>(virusList);
        while (!queue.isEmpty()) {
            int location = queue.poll();
            int row = location / M;
            int col = location % M;

            for (int[] direction : DIRECTION) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];

                if (nextRow >= 0 && nextRow < N
                    && nextCol >= 0 && nextCol < M
                    && spreadMap[nextRow][nextCol] == EMPTY
                ) {
                    queue.add(nextRow * M + nextCol);
                    spreadMap[nextRow][nextCol] = VIRUS;
                }
            }
        }

        return spreadMap;
    }

    private static int countEmpty(int[][] map) {
        int result = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (map[row][col] == EMPTY) {
                    result++;
                }
            }
        }
        return result;
    }
}
