package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_29732 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String S = br.readLine();
        int[] infectedRange = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            if (S.charAt(i - 1) == '.') {
                continue;
            }

            infectedRange[Math.max(1, i - K)]++;
            infectedRange[Math.min(N + 1, i + K + 1)]--;
        }

        int currentInfected = 0;
        int infectedCount = 0;
        for (int i = 1; i <= N; i++) {
            currentInfected += infectedRange[i];
            if (currentInfected > 0) {
                infectedCount++;
            }
        }

        if (infectedCount <= M) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}
