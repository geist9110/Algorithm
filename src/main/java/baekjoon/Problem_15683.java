package baekjoon;

import baekjoon.config.ProblemInterface;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_15683 implements ProblemInterface {

    private static final int CHECK = -1;
    private static final int EMPTY = 0;
    private static final int WALL = 6;

    private static final int TOP = 0;
    private static final int RIGHT = 1;
    private static final int BOTTOM = 2;
    private static final int LEFT = 3;
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static final int[][] TYPE = {
        {TOP},
        {TOP, BOTTOM},
        {TOP, RIGHT},
        {TOP, RIGHT, LEFT},
        {TOP, RIGHT, BOTTOM, LEFT}
    };

    private static class CCTV {

        int direction;
        int type;
        Point location;

        public CCTV(int direction, int type, Point location) {
            this.direction = direction;
            this.location = location;
            this.type = type;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        List<CCTV> cctvs = new ArrayList<>();
        int blindSpotCount = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == EMPTY) {
                    blindSpotCount++;
                    continue;
                }

                if (map[i][j] != WALL) {
                    cctvs.add(new CCTV(TOP, map[i][j] - 1, new Point(i, j)));
                }
            }
        }

        System.out.print(dfs(0, cctvs, map, blindSpotCount));
    }

    private static int dfs(int depth, List<CCTV> cctvs, int[][] map, int blindSpotCount) {
        if (depth == cctvs.size()) {
            return blindSpotCount;
        }

        int result = Integer.MAX_VALUE;
        CCTV cctv = cctvs.get(depth);
        for (int i = 0; i < 4; i++) {
            cctv.direction = i;
            List<Point> backtrack = new LinkedList<>();

            for (int dir : TYPE[cctv.type]) {
                int direction = (cctv.direction + dir) % 4;
                int dx = DIRECTIONS[direction][0];
                int dy = DIRECTIONS[direction][1];

                for (
                    int row = cctv.location.x + dx, col = cctv.location.y + dy;
                    row >= 0 && row < map.length && col >= 0 && col < map[0].length;
                    row += dx, col += dy
                ) {
                    if (map[row][col] == WALL) {
                        break;
                    }

                    if (map[row][col] == EMPTY) {
                        map[row][col] = CHECK;
                        backtrack.add(new Point(row, col));
                    }
                }
            }

            result = Math.min(result, dfs(depth + 1, cctvs, map, blindSpotCount - backtrack.size()));

            for (Point p : backtrack) {
                map[p.x][p.y] = EMPTY;
            }
        }
        return result;
    }
}
