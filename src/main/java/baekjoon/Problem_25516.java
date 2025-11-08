package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_25516 implements ProblemInterface {

    private static List<List<Integer>> tree;
    private static int[] apples;
    private static int k;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        tree = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            tree.add(new LinkedList<>());
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            tree.get(Integer.parseInt(st.nextToken()))
                    .add(Integer.parseInt(st.nextToken()));
        }

        apples = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            apples[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(dfs(0, 0));
    }

    private static int dfs(int current, int depth) {
        if (depth == k) {
            return apples[current];
        }

        int apple = apples[current];
        for (Integer next : tree.get(current)) {
            apple += dfs(next, depth + 1);
        }
        return apple;
    }
}
