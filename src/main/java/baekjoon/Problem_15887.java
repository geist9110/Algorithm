package baekjoon;

import baekjoon.config.ProblemInterface;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_15887 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Point> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (array[i] == i) {
                continue;
            }
            int locatedIndex = i;
            for (int j = i + 1; j <= N; j++) {
                if (array[j] == i) {
                    locatedIndex = j;
                }
            }

            int start = i;
            int end = locatedIndex;
            queue.add(new Point(start, end));

            while (start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
        }

        sb.append(queue.size()).append("\n");
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }

        System.out.print(sb);
    }
}
