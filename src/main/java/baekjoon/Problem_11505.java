package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11505 implements ProblemInterface {

    private static final long MOD = 1_000_000_007;
    private static final int UPDATE = 1;
    private static final int QUERY = 2;

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
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        array = new long[N];
        for (int i = 0; i < N; i++) {
            array[i] = Long.parseLong(br.readLine());
        }
        tree = new Node[4 * N];
        init(0, N - 1, 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            if (a == UPDATE) {
                update(b, 1, c);
                continue;
            }

            if (a == QUERY) {
                sb.append(query(b, c - 1, 1)).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static Node init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = new Node(
                array[start] % MOD,
                start,
                end
            );
        }

        int mid = (start + end) / 2;
        long leftValue = init(start, mid, node * 2).value % MOD;
        long rightValue = init(mid + 1, end, node * 2 + 1).value % MOD;

        return tree[node] = new Node(
            (leftValue * rightValue) % MOD,
            start,
            end
        );
    }

    private static long query(int start, int end, int node) {
        if (tree[node].start > end || tree[node].end < start) {
            return 1;
        }

        if (tree[node].start >= start && tree[node].end <= end) {
            return tree[node].value % MOD;
        }

        return (query(start, end, node * 2) * query(start, end, node * 2 + 1)) % MOD;
    }

    private static long update(int index, int node, long value) {
        if (tree[node].start == tree[node].end && tree[node].start == index) {
            return tree[node].value = value % MOD;
        }

        if (tree[node].start > index || tree[node].end < index) {
            return tree[node].value % MOD;
        }

        return tree[node].value = (
            (update(index, node * 2, value) * update(index, node * 2 + 1, value)) % MOD
        );
    }
}
