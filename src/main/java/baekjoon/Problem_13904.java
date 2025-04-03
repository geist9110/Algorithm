package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_13904 implements ProblemInterface {

    private static class Assignment {

        int day;
        int score;

        public Assignment(int day, int score) {
            this.day = day;
            this.score = score;
        }

    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Assignment> assignments = new ArrayList<>();
        PriorityQueue<Assignment> assignmentPriorityQueue = new PriorityQueue<>(
            Comparator.comparingInt(o -> o.score));

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            assignments.add(new Assignment(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())));
        }
        assignments.sort(Comparator.comparingInt(o -> o.day));

        for (Assignment assignment : assignments) {
            if (assignment.day > assignmentPriorityQueue.size()) {
                assignmentPriorityQueue.add(assignment);
                continue;
            }

            if (assignmentPriorityQueue.peek().score < assignment.score) {
                assignmentPriorityQueue.poll();
                assignmentPriorityQueue.add(assignment);
            }
        }

        int result = 0;
        for (Assignment assignment : assignmentPriorityQueue) {
            result += assignment.score;
        }

        System.out.print(result);

    }
}
