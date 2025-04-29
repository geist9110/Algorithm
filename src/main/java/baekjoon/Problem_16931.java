package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_16931 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] cube = new int[M];

        int result = N * M * 2;
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            int prev = 0;
            for (int col = 0; col < M; col++) {
                int value = Integer.parseInt(st.nextToken());

                // 세로 방향
                result += Math.abs(cube[col] - value);
                cube[col] = value;

                // 가로 방향
                result += Math.abs(cube[col] - prev);
                prev = cube[col];
            }
            result += prev;
        }

        result += Arrays.stream(cube).sum();

        System.out.println(result);
    }
}
