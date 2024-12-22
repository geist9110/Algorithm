package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_12851 implements ProblemInterface {

    private static final int LAST_INDEX = 200_000;
    private static int[] time;
    private static int[] count;
    private static Queue<Integer> queue;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        time = new int[LAST_INDEX + 1];
        Arrays.fill(time, Integer.MAX_VALUE);
        count = new int[LAST_INDEX + 1];

        queue = new LinkedList<>();
        queue.add(N);
        time[N] = 0;
        count[N] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            moveNextLocation(current, current - 1);
            moveNextLocation(current, current + 1);
            moveNextLocation(current, current * 2);
        }

        System.out.printf("%d\n%d", time[K], count[K]);
    }

    private static void moveNextLocation(int currentIndex, int nextIndex) {
        if (isValidIndex(nextIndex)) {
            return;
        }

        if (isCurrentSmallerThanNext(currentIndex, nextIndex)) {
            time[nextIndex] = time[currentIndex] + 1;
            count[nextIndex] = 1;
            queue.add(nextIndex);
            return;
        }

        if (isCurrentSameNext(currentIndex, nextIndex)) {
            count[nextIndex]++;
            queue.add(nextIndex);
        }
    }

    private static boolean isValidIndex(int index) {
        return index > LAST_INDEX || index < 0;
    }

    private static boolean isCurrentSameNext(int currentIndex, int nextIndex) {
        return time[currentIndex] + 1 == time[nextIndex];
    }

    private static boolean isCurrentSmallerThanNext(int currentIndex, int nextIndex) {
        return time[currentIndex] + 1 < time[nextIndex];
    }
}
