package baekjoon;

import baekjoon.config.ProblemInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_5623 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 2) {
            System.out.print("1 1");
            return;
        }
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int lastNumber = (map[N - 2][N - 1] + map[N - 3][N - 1] - map[N - 3][N - 2]) / 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(Math.abs(map[i][N - 1] - lastNumber)).append(" ");
        }
        System.out.print(sb);
    }
}
