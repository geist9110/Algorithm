package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_19843 implements ProblemInterface {
    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int totalSleepTime = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sleepTime = dayToTime(st.nextToken()) + Integer.parseInt(st.nextToken());
            int wakeupTime = dayToTime(st.nextToken()) + Integer.parseInt(st.nextToken());
            totalSleepTime += wakeupTime - sleepTime;
        }

        if (totalSleepTime >= T) {
            System.out.print(0);
            return;
        }

        if (T - totalSleepTime <= 48) {
            System.out.print(T - totalSleepTime);
            return;
        }

        System.out.print(-1);
    }

    private static int dayToTime(String day) {
        if (day.equals("Mon")) {
            return 0;
        }

        if (day.equals("Tue")) {
            return 24;
        }

        if (day.equals("Wed")) {
            return 48;
        }

        if (day.equals("Thu")) {
            return 72;
        }

        if (day.equals("Fri")) {
            return 96;
        }

        return 0;
    }
}
