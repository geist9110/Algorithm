package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2243 implements ProblemInterface {

    private static int[] tree;
    private static final int MAX_SIZE = 1_000_001;
    private static final int POP = 1;
    private static final int UPDATE = 2;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        tree = new int[MAX_SIZE * 4];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == POP) {
                int order = Integer.parseInt(st.nextToken());
                sb.append(pop(1, MAX_SIZE, order, 1)).append("\n");

                continue;
            }

            if (command == UPDATE) {
                int taste = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                update(1, MAX_SIZE, taste, count, 1);
            }
        }

        System.out.print(sb);
    }

    private static int pop(int start, int end, int order, int nodeIndex) {
        tree[nodeIndex]--;
        if (start == end) {
            return start;
        }

        int leftCandies = tree[nodeIndex * 2];
        int mid = (start + end) / 2;

        if (order <= leftCandies) {
            return pop(start, mid, order, nodeIndex * 2);
        }
        return pop(mid + 1, end, order - leftCandies, nodeIndex * 2 + 1);
    }

    private static void update(int start, int end, int taste, int count, int nodeIndex) {
        if (taste < start || taste > end) {
            return;
        }

        tree[nodeIndex] += count;
        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, taste, count, nodeIndex * 2);
        update(mid + 1, end, taste, count, nodeIndex * 2 + 1);
    }
}
