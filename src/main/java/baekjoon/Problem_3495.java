package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem_3495 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[h][w];
        for (int row = 0; row < h; row++) {
            String line = br.readLine();
            for (int col = 0; col < w; col++) {
                char nextChar = line.charAt(col);
                if (nextChar == '/' || nextChar == '\\') {
                    map[row][col] = true;
                }
            }
        }

        int result = 0;
        for (int row = 0; row < h; row++) {
            int diagonalCount = 0;
            for (int col = 0; col < w; col++) {
                if (map[row][col]) {
                    result += 1;
                    diagonalCount++;
                    continue;
                }

                if (diagonalCount % 2 == 1) {
                    result += 2;
                }
            }
        }

        System.out.print(result / 2);
    }
}
