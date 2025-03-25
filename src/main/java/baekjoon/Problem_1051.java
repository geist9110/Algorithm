package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_1051 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int row = 0; row < N; row++) {
            String s = br.readLine();
            for (int col = 0; col < M; col++) {
                map[row][col] = s.charAt(col) - '0';
            }
        }

        for (int window = Math.min(N, M) - 1; window >= 0; window--) {
            for (int row = 0; row + window < N; row++) {
                for (int col = 0; col + window < M; col++) {
                    if (map[row][col] != map[row][col + window]) {
                        continue;
                    }

                    if (map[row][col] != map[row + window][col]) {
                        continue;
                    }

                    if (map[row][col] != map[row + window][col + window]) {
                        continue;
                    }

                    System.out.print((window + 1) * (window + 1));
                    return;
                }
            }
        }
    }

}
