package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_14428 implements ProblemInterface {

    private static int[] array;
    private static Node[] tree;

    private static class Node {

        int index;
        int start;
        int end;

        public Node(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        array = new int[N + 1];
        array[0] = Integer.MAX_VALUE;
        tree = new Node[4 * N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        init(1, N, 1);
        for (int M = Integer.parseInt(br.readLine()); M > 0; M--) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if (command == 1) {
                update(i, j, 1);
                continue;
            }

            if (command == 2) {
                sb.append(query(i, j, 1)).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static Node init(int start, int end, int nodeIndex) {
        if (start == end) {
            return tree[nodeIndex] = new Node(
                start,
                start,
                end
            );
        }

        int mid = (start + end) / 2;
        Node leftNode = init(start, mid, nodeIndex * 2);
        Node rightNode = init(mid + 1, end, nodeIndex * 2 + 1);

        if (array[leftNode.index] <= array[rightNode.index]) {
            return tree[nodeIndex] = new Node(
                leftNode.index,
                start,
                end
            );
        }

        return tree[nodeIndex] = new Node(
            rightNode.index,
            start,
            end
        );
    }

    private static Node update(int index, int value, int nodeIndex) {
        if (tree[nodeIndex].start == tree[nodeIndex].end && tree[nodeIndex].start == index) {
            array[index] = value;
            return tree[nodeIndex];
        }

        if (tree[nodeIndex].start > index || tree[nodeIndex].end < index) {
            return tree[nodeIndex];
        }

        Node leftNode = update(index, value, nodeIndex * 2);
        Node rightNode = update(index, value, nodeIndex * 2 + 1);

        if (array[leftNode.index] <= array[rightNode.index]) {
            tree[nodeIndex].index = leftNode.index;
            return tree[nodeIndex];
        }

        tree[nodeIndex].index = rightNode.index;
        return tree[nodeIndex];
    }

    private static int query(int start, int end, int nodeIndex) {
        if (tree[nodeIndex].start > end || tree[nodeIndex].end < start) {
            return 0;
        }

        if (tree[nodeIndex].start >= start && tree[nodeIndex].end <= end) {
            return tree[nodeIndex].index;
        }

        int leftNode = query(start, end, nodeIndex * 2);
        int rightNode = query(start, end, nodeIndex * 2 + 1);

        if (array[leftNode] <= array[rightNode]) {
            return leftNode;
        }

        return rightNode;
    }
}
