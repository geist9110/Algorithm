package baekjoon;

import baekjoon.config.ProblemInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2669 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] map = new boolean[101][101];

        int result = 0;
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int leftBottomX = Integer.parseInt(st.nextToken());
            int leftBottomY = Integer.parseInt(st.nextToken());
            int rightTopX = Integer.parseInt(st.nextToken());
            int rightTopY = Integer.parseInt(st.nextToken());

            for (int x = leftBottomX; x < rightTopX; x++) {
                for (int y = leftBottomY; y < rightTopY; y++) {
                    if (!map[x][y]) {
                        result++;
                        map[x][y] = true;
                    }
                }
            }
        }
        System.out.print(result);
    }
}
