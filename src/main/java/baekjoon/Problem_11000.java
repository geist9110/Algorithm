package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_11000 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Task[] tasks = new Task[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tasks[i] = new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(tasks, (a, b) -> Integer.compare(a.startTime, b.startTime));

        PriorityQueue<Integer> classRoomEndTime = new PriorityQueue<>(List.of(tasks[0].endTime));

        for (int i = 1; i < N; i++) {
            if (classRoomEndTime.peek() <= tasks[i].startTime) {
                classRoomEndTime.poll();
            }

            classRoomEndTime.add(tasks[i].endTime);
        }

        System.out.print(classRoomEndTime.size());
    }

    private static class Task {
        int startTime;
        int endTime;

        public Task(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

    }

}
