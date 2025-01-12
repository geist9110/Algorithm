package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_2623 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] singerInputDegree = new int[N + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int singerInChargeCount = Integer.parseInt(st.nextToken());
            int prevSinger = Integer.parseInt(st.nextToken());
            for (int j = 1; j < singerInChargeCount; j++) {
                int singer = Integer.parseInt(st.nextToken());
                graph.get(prevSinger).add(singer);
                singerInputDegree[singer]++;
                prevSinger = singer;
            }
        }

        Queue<Integer> topoloyQueue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (singerInputDegree[i] == 0) {
                topoloyQueue.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int singerVisitCount = 0;
        while (!topoloyQueue.isEmpty()) {
            int currentSinger = topoloyQueue.poll();
            singerVisitCount++;
            sb.append(currentSinger).append("\n");

            for (Integer nextSinger : graph.get(currentSinger)) {
                singerInputDegree[nextSinger]--;
                if (singerInputDegree[nextSinger] == 0) {
                    topoloyQueue.add(nextSinger);
                }
            }
        }

        if (singerVisitCount == N) {
            System.out.print(sb);
            return;
        }
        System.out.print("0");
    }
}
