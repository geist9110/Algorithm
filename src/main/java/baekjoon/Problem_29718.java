package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_29718 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] clapSum = new int[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                clapSum[j] += Integer.parseInt(st.nextToken());
            }
        }

        int A = Integer.parseInt(br.readLine());
        int currentClap = 0;
        for (int i = 0; i < A; i++) {
            currentClap += clapSum[i];
        }
        int maxClap = currentClap;

        for (int i = A; i < M; i++) {
            currentClap += clapSum[i] - clapSum[i - A];
            maxClap = Math.max(maxClap, currentClap);
        }
        System.out.print(maxClap);

    }

}
