package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1275 implements ProblemInterface {

    private static long[] array;
    private static Node[] tree;

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
        int Q = Integer.parseInt(st.nextToken());

        array = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Long.parseLong(st.nextToken());
        }

        tree = new Node[4 * N];
        init(0, N - 1, 1);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            sb.append(query(Math.min(x, y), Math.max(x, y), 1)).append("\n");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            update(a - 1, b, 1);
        }

        System.out.print(sb);
    }

    private static Node init(int start, int end, int nodeIndex) {
        if (start == end) {
            return tree[nodeIndex] = new Node(array[start], start, end);
        }

        int mid = (start + end) / 2;
        Node leftNode = init(start, mid, nodeIndex * 2);
        Node rightNode = init(mid + 1, end, nodeIndex * 2 + 1);
        return tree[nodeIndex] = new Node(
            leftNode.value + rightNode.value,
            start,
            end
        );
    }

    private static long query(int start, int end, int nodeIndex) {
        if (start > tree[nodeIndex].end || end < tree[nodeIndex].start) {
            return 0;
        }

        if (start <= tree[nodeIndex].start && end >= tree[nodeIndex].end) {
            return tree[nodeIndex].value;
        }

        long leftValue = query(start, end, nodeIndex * 2);
        long rightValue = query(start, end, nodeIndex * 2 + 1);

        return leftValue + rightValue;
    }

    private static long update(int index, int value, int nodeIndex) {
        if (tree[nodeIndex].start == tree[nodeIndex].end && tree[nodeIndex].start == index) {
            return tree[nodeIndex].value = value;
        }

        if (tree[nodeIndex].start > index || tree[nodeIndex].end < index) {
            return tree[nodeIndex].value;
        }

        long leftValue = update(index, value, nodeIndex * 2);
        long rightValue = update(index, value, nodeIndex * 2 + 1);
        return tree[nodeIndex].value = leftValue + rightValue;
    }
}
