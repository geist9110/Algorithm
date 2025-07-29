package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2357 implements ProblemInterface {

    private static int[] array;
    private static Node[] tree;
    private static int minValue;
    private static int maxValue;

    private static class Node {

        int minValue;
        int maxValue;
        int start;
        int end;

        public Node(int minValue, int maxValue, int start, int end) {
            this.minValue = minValue;
            this.maxValue = maxValue;
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

        array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        tree = new Node[4 * N];
        init(0, N - 1, 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startRange = Integer.parseInt(st.nextToken()) - 1;
            int endRange = Integer.parseInt(st.nextToken()) - 1;

            minValue = Integer.MAX_VALUE;
            maxValue = Integer.MIN_VALUE;
            query(startRange, endRange, 1);
            sb.append(minValue).append(" ").append(maxValue).append("\n");
        }

        System.out.print(sb);
    }

    private static Node init(int rangeStart, int rangeEnd, int node) {
        if (rangeStart == rangeEnd) {
            return tree[node] = new Node(
                array[rangeStart],
                array[rangeStart],
                rangeStart,
                rangeEnd
            );
        }

        int mid = (rangeStart + rangeEnd) / 2;
        Node leftNode = init(rangeStart, mid, node * 2);
        Node rightNode = init(mid + 1, rangeEnd, node * 2 + 1);
        return tree[node] = new Node(
            Math.min(leftNode.minValue, rightNode.minValue),
            Math.max(leftNode.maxValue, rightNode.maxValue),
            leftNode.start,
            rightNode.end
        );
    }

    private static void query(int rangeStart, int rangeEnd, int node) {
        if (tree[node].end < rangeStart || tree[node].start > rangeEnd) {
            return;
        }

        if (tree[node].start >= rangeStart && tree[node].end <= rangeEnd) {
            minValue = Math.min(minValue, tree[node].minValue);
            maxValue = Math.max(maxValue, tree[node].maxValue);
            return;
        }

        query(rangeStart, rangeEnd, node * 2);
        query(rangeStart, rangeEnd, node * 2 + 1);
    }
}
