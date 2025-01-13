package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_9466 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] students = new int[n + 1];
            int[] studentsInputDegree = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                students[i] = Integer.parseInt(st.nextToken());
                studentsInputDegree[students[i]]++;
            }

            int notIncludeStudentCount = 0;
            boolean[] visit = new boolean[n + 1];

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (studentsInputDegree[i] == 0) {
                    queue.add(i);
                    visit[i] = true;
                    notIncludeStudentCount++;
                }
            }

            while (!queue.isEmpty()) {
                int nextStudent = students[queue.poll()];

                if (--studentsInputDegree[nextStudent] == 0 && !visit[nextStudent]) {
                    queue.add(nextStudent);
                    visit[nextStudent] = true;
                    notIncludeStudentCount++;
                }
            }

            bw.write(notIncludeStudentCount + "");
            bw.newLine();
        }

        bw.flush();
    }
}
