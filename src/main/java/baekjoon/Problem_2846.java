package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_2846 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int distance = 0;
        int start = Integer.parseInt(st.nextToken());
        int currentHeight = start;
        for (int i = 1; i < N; i++) {
            int nextHeight = Integer.parseInt(st.nextToken());
            if (nextHeight > currentHeight) {
                currentHeight = nextHeight;
                distance = Math.max(distance, currentHeight - start);
                continue;
            }
            start = nextHeight;
            currentHeight = nextHeight;
        }

        System.out.print(distance);
    }
}
