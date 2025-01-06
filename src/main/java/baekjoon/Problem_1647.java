package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_1647 implements ProblemInterface {

    private static int[] unionFindArray;

    private static class Edge {

        int firstVillage, secondVillage, distance;

        public Edge(int firstVillage, int secondVillage, int distance) {
            this.firstVillage = firstVillage;
            this.secondVillage = secondVillage;
            this.distance = distance;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparing(o -> o.distance));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges.add(new Edge(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
                )
            );
        }

        unionFindArray = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            unionFindArray[i] = i;
        }

        int distanceSum = 0;
        while (!edges.isEmpty() && N > 2) {
            Edge edge = edges.poll();

            int firstVillage = find(edge.firstVillage);
            int secondVillage = find(edge.secondVillage);

            if (firstVillage == secondVillage) {
                continue;
            }

            distanceSum += edge.distance;

            // Union
            unionFindArray[firstVillage] = secondVillage;
            N--;
        }

        System.out.print(distanceSum);
    }

    private static int find(int x) {
        if (unionFindArray[x] == x) {
            return x;
        }
        return unionFindArray[x] = find(unionFindArray[x]);
    }
}
