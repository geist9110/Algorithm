package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_23056 implements ProblemInterface {

    private static class Student implements Comparable<Student> {

        int classNumber;
        String name;

        public Student(int classNumber, String name) {
            this.classNumber = classNumber;
            this.name = name;
        }

        @Override
        public int compareTo(Student o) {
            if (this.classNumber == o.classNumber && this.name.equals(o.name)) {
                return 0;
            }

            if (this.classNumber != o.classNumber) {
                return this.classNumber - o.classNumber;
            }

            if (this.name.length() != o.name.length()) {
                return this.name.length() - o.name.length();
            }

            return this.name.compareTo(o.name);
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] classCount = new int[N + 1];
        List<Student> blueTeam = new ArrayList<>();
        List<Student> whiteTeam = new ArrayList<>();

        while (true) {
            st = new StringTokenizer(br.readLine());
            Student student = new Student(
                Integer.parseInt(st.nextToken()),
                st.nextToken()
            );

            if (student.classNumber == 0 && student.name.equals("0")) {
                break;
            }

            if (classCount[student.classNumber]++ >= M) {
                continue;
            }

            if (student.classNumber % 2 == 0) {
                whiteTeam.add(student);
                continue;
            }

            blueTeam.add(student);
        }

        blueTeam.sort(null);
        whiteTeam.sort(null);

        for (Student student : blueTeam) {
            sb.append(student.classNumber).append(" ").append(student.name).append("\n");
        }

        for (Student student : whiteTeam) {
            sb.append(student.classNumber).append(" ").append(student.name).append("\n");
        }

        System.out.print(sb);
    }
}
