package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_20303 implements ProblemInterface {

    private static int[] unionFind;

    private static class Children {
        int totalCandy;
        int childCount;

        public Children(int totalCandy, int childCount) {
            this.totalCandy = totalCandy;
            this.childCount = childCount;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] candyArray = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            candyArray[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<ArrayList<Integer>> friendGraph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            friendGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int firstChild = Integer.parseInt(st.nextToken());
            int secondChild = Integer.parseInt(st.nextToken());
            friendGraph.get(firstChild).add(secondChild);
            friendGraph.get(secondChild).add(firstChild);
        }

        unionFind = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            unionFind[i] = i;
        }

        boolean[] visit = new boolean[N + 1];
        ArrayList<Children> children = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (visit[i]) {
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visit[i] = true;

            Children child = new Children(0, 0);
            while (!queue.isEmpty()) {
                int currentChild = queue.poll();
                child.childCount++;
                child.totalCandy += candyArray[currentChild];

                for (int nextChild : friendGraph.get(currentChild)) {
                    if (visit[nextChild]) {
                        continue;
                    }
                    visit[nextChild] = true;
                    queue.add(nextChild);
                }
            }
            children.add(child);
        }

        int[] dp = new int[K];
        for (Children child : children) {
            for (int weight = K - 1; weight > 0; weight--) {
                if (weight >= child.childCount) {
                    dp[weight] =
                            Math.max(dp[weight], dp[weight - child.childCount] + child.totalCandy);
                }
            }
        }

        System.out.print(dp[K - 1]);
    }
}
