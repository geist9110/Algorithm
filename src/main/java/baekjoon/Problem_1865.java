package baekjoon;

import static java.lang.Integer.MAX_VALUE;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_1865 implements ProblemInterface {

    private static class Edge {

        int depart, arrive, weight;

        public Edge(int depart, int arrive, int weight) {
            this.depart = depart;
            this.arrive = arrive;
            this.weight = weight;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            List<Edge> edges = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int depart = Integer.parseInt(st.nextToken());
                int arrive = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edges.add(new Edge(depart, arrive, weight));
                edges.add(new Edge(arrive, depart, weight));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int depart = Integer.parseInt(st.nextToken());
                int arrive = Integer.parseInt(st.nextToken());
                int weight = -Integer.parseInt(st.nextToken());
                edges.add(new Edge(depart, arrive, weight));
            }

            boolean result = false;
            for (int start = 1; start <= N && !result; start++) {
                result = bellmanFord(N, start, edges);
            }

            bw.write(result ? "YES" : "NO");
            bw.newLine();
        }
        bw.flush();
    }

    private static boolean bellmanFord(int nodeSize, int start, List<Edge> edges) {
        int[] distance = new int[nodeSize + 1];
        Arrays.fill(distance, MAX_VALUE);
        distance[start] = 0;
        boolean flag = true;
        for (int node = 1; node <= nodeSize && flag; node++) {
            flag = false;
            for (Edge edge : edges) {
                if (distance[edge.depart] == MAX_VALUE) {
                    continue;
                }

                int weight = distance[edge.depart] + edge.weight;

                if (distance[edge.arrive] <= weight) {
                    continue;
                }

                distance[edge.arrive] = weight;
                flag = true;

                if (node == nodeSize) {
                    return true;
                }
            }
        }

        return false;
    }
}
