package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_10868 implements ProblemInterface {

    private static int[] array;
    private static Node[] tree;

    private static class Node {

        int value;
        int start;
        int end;

        public Node(int value, int start, int end) {
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

        array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        tree = new Node[4 * N];
        init(0, N - 1, 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(query(
                Integer.parseInt(st.nextToken()) - 1,
                Integer.parseInt(st.nextToken()) - 1,
                1
            )).append("\n");
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
            Math.min(leftNode.value, rightNode.value),
            start,
            end
        );
    }

    private static int query(int start, int end, int nodeIndex) {
        if (start > tree[nodeIndex].end || end < tree[nodeIndex].start) {
            return Integer.MAX_VALUE;
        }

        if (start <= tree[nodeIndex].start && end >= tree[nodeIndex].end) {
            return tree[nodeIndex].value;
        }

        return Math.min(
            query(start, end, nodeIndex * 2),
            query(start, end, nodeIndex * 2 + 1)
        );
    }
}
