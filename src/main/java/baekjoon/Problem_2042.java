package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2042 implements ProblemInterface {

    private static Node[] tree;
    private static long[] array;

    private static class Node {

        long value;
        int start;
        int end;

        public Node(long value, int start, int end) {
            this.value = value;
            this.start = start;
            this.end = end;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        array = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            array[i] = Long.parseLong(br.readLine());
        }
        tree = new Node[4 * N];
        init(1, array.length - 1, 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int changeIndex = Integer.parseInt(st.nextToken());
                long nextValue = Long.parseLong(st.nextToken());
                long diff = nextValue - array[changeIndex];
                array[changeIndex] = nextValue;

                update(1, changeIndex, diff);
                continue;
            }

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(sum(start, end, 1)).append("\n");
        }

        System.out.print(sb);

    }

    private static Node init(int nodeRangeStart, int nodeRangeEnd, int node) {
        if (nodeRangeStart == nodeRangeEnd) {
            tree[node] = new Node(
                array[nodeRangeStart],
                nodeRangeStart,
                nodeRangeEnd
            );

            return tree[node];
        }

        int mid = (nodeRangeStart + nodeRangeEnd) / 2;

        Node leftNode = init(nodeRangeStart, mid, node * 2);
        Node rightNode = init(mid + 1, nodeRangeEnd, node * 2 + 1);

        tree[node] = new Node(leftNode.value + rightNode.value, nodeRangeStart, nodeRangeEnd);
        return tree[node];
    }

    private static long sum(int start, int end, int node) {
        if (start > tree[node].end || end < tree[node].start) {
            return 0;
        }

        if (start <= tree[node].start && end >= tree[node].end) {
            return tree[node].value;
        }

        return sum(start, end, node * 2) + sum(start, end, node * 2 + 1);
    }

    private static void update(int node, int index, long diff) {
        if (index < tree[node].start || index > tree[node].end) {
            return;
        }

        tree[node].value += diff;

        if (tree[node].start == tree[node].end) {
            return;
        }

        update(node * 2, index, diff);
        update(node * 2 + 1, index, diff);
    }
}
