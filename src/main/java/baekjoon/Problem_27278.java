package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_27278 implements ProblemInterface {

    private static long[] times;
    private static int N;
    private static long lastTime;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        times = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= N; i++) {
            times[i] = Long.parseLong(st.nextToken()) + times[i - 1];
        }
        lastTime = Long.parseLong(st.nextToken());

        long result = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            result = Math.max(result,
                    calculateStartTime(c, times[p], times[N] + lastTime) + calculateInBusTime(p, r));
        }

        System.out.print(result);
    }

    private static long calculateStartTime(long c, long busFirstArriveTime, long busPatrolTime) {
        if (c <= busFirstArriveTime) {
            return busFirstArriveTime;
        }

        return (c - busFirstArriveTime + busPatrolTime - 1) / busPatrolTime * busPatrolTime + busFirstArriveTime;
    }

    private static long calculateInBusTime(int depart, int arrive) {
        long inBusTime = times[arrive] - times[depart];

        if (depart > arrive) {
            inBusTime += times[N] + lastTime;
        }

        return inBusTime;
    }
}
