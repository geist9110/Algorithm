package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem_15686 implements ProblemInterface {

    private static final String HOUSE = "1", CHICKEN_HOUSE = "2";
    private static int M;
    private static int minDistance;
    private static ArrayList<ArrayList<Integer>> chickenDistances;
    private static boolean[] visit;

    private static class Point {

        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        LinkedList<Point> houses = new LinkedList<>();
        LinkedList<Point> chickenHouses = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                String s = st.nextToken();
                if (s.equals(HOUSE)) {
                    houses.add(new Point(i, j));
                    continue;
                }
                if (s.equals(CHICKEN_HOUSE)) {
                    chickenHouses.add(new Point(i, j));
                }
            }
        }

        chickenDistances = new ArrayList<>();
        for (Point chickenHouse : chickenHouses) {
            ArrayList<Integer> chickenDistance = new ArrayList<>();
            for (Point house : houses) {
                chickenDistance.add(calcChickenDistance(house, chickenHouse));
            }
            chickenDistances.add(chickenDistance);
        }
        minDistance = Integer.MAX_VALUE;
        visit = new boolean[chickenDistances.size()];
        dfs(0, -1);
        System.out.println(minDistance);
    }

    private static int calcChickenDistance(Point house, Point chickenHouse) {
        return Math.abs(house.row - chickenHouse.row) + Math.abs(house.col - chickenHouse.col);
    }

    private static void dfs(int depth, int prevIndex) {
        if (depth == M) {
            int[] min = new int[chickenDistances.getFirst().size()];
            Arrays.fill(min, Integer.MAX_VALUE);
            for (int i = 0; i < chickenDistances.size(); i++) {
                if (visit[i]) {
                    for (int j = 0; j < chickenDistances.getFirst().size(); j++) {
                        min[j] = Math.min(min[j], chickenDistances.get(i).get(j));
                    }
                }
            }

            minDistance = Math.min(minDistance, Arrays.stream(min).sum());
            return;
        }

        for (int i = prevIndex + 1; i < chickenDistances.size(); i++) {
            visit[i] = true;
            dfs(depth + 1, i);
            visit[i] = false;
        }
    }
}
