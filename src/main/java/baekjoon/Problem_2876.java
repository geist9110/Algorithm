package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_2876 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] gradeSelected = new int[6][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int firstStudentGrade = Integer.parseInt(st.nextToken());
            int secondStudentGrade = Integer.parseInt(st.nextToken());

            gradeSelected[firstStudentGrade][i] = gradeSelected[firstStudentGrade][i - 1] + 1;
            gradeSelected[secondStudentGrade][i] = gradeSelected[secondStudentGrade][i - 1] + 1;

        }

        int minGrade = Integer.MAX_VALUE;
        int studentCount = Integer.MIN_VALUE;
        for (int grade = 1; grade <= 5; grade++) {
            for (int index = 1; index <= N; index++) {
                if (gradeSelected[grade][index] > studentCount) {
                    minGrade = grade;
                    studentCount = gradeSelected[grade][index];
                }
            }
        }

        System.out.printf("%d %d", studentCount, minGrade);
    }

}
