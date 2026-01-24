package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_26648 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] subjects = new int[3][N];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                subjects[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int previousScore = -1;
        for (int i = 0; i < N; i++) {
            int minScore = Math.min(subjects[0][i], Math.min(subjects[1][i], subjects[2][i]));
            int maxScore = Math.max(subjects[0][i], Math.max(subjects[1][i], subjects[2][i]));

            if (previousScore >= maxScore) {
                System.out.print("NO");
                return;
            }

            previousScore = Math.max(minScore, previousScore + 1);
        }

        System.out.print("YES");
    }

}
