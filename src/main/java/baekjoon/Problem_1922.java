package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_1922 implements ProblemInterface {

    private static int[] unionFind;

    private static class Node implements Comparable<Node> {

        int a;
        int b;
        int weight;

        public Node(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new Node(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()))
            );
        }

        int result = 0;
        unionFind = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            unionFind[i] = i;
        }

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (find(node.a) != find(node.b)) {
                union(node.a, node.b);
                result += node.weight;
            }
        }

        System.out.print(result);
    }

    private static int find(int a) {
        if (a == unionFind[a]) {
            return a;
        }

        return unionFind[a] = find(unionFind[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        unionFind[b] = a;
    }
}
