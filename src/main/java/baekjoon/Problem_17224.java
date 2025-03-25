package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_17224 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int solvedEasy = 0;
        int solvedHard = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int easy = Integer.parseInt(st.nextToken());
            int hard = Integer.parseInt(st.nextToken());

            if (hard <= L) {
                solvedHard++;
                continue;
            }

            if (easy <= L) {
                solvedEasy++;
            }
        }

        int result = 0;
        int solveCount = Math.min(solvedHard, K);
        result += solveCount * 140;
        K -= solveCount;

        solveCount = Math.min(solvedEasy, K);
        result += solveCount * 100;

        System.out.println(result);
    }

}
