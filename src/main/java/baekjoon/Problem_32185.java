package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_32185 implements ProblemInterface {

    private static class Student {

        int statsSum;
        int index;

        public Student(int v, int p, int s, int index) {
            this.statsSum = v + p + s;
            this.index = index;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        Student jaewon = new Student(
            Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken()),
            0
        );

        Student[] students = new Student[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            students[i] = new Student(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                i + 1
            );
        }

        Arrays.sort(students, ((o1, o2) -> o2.statsSum - o1.statsSum));

        sb.append(jaewon.index).append(" ");
        for (Student student : students) {
            if (student.statsSum > jaewon.statsSum) {
                continue;
            }

            if (M-- == 0) {
                break;
            }

            sb.append(student.index).append(" ");
        }

        System.out.print(sb);
    }
}
