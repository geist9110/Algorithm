package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_8911 implements ProblemInterface {

    private static final int[][] DIRECTIONS = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            String command = br.readLine();
            int minX = 0;
            int maxX = 0;
            int minY = 0;
            int maxY = 0;

            int currentX = 0;
            int currentY = 0;
            int direction = 0;

            for (char c : command.toCharArray()) {
                if (c == 'R') {
                    direction = (direction + 1) % 4;
                    continue;
                }

                if (c == 'L') {
                    direction = (direction + 3) % 4;
                    continue;
                }

                if (c == 'F') {
                    currentX += DIRECTIONS[direction][0];
                    currentY += DIRECTIONS[direction][1];
                }

                if (c == 'B') {
                    currentX -= DIRECTIONS[direction][0];
                    currentY -= DIRECTIONS[direction][1];
                }

                minX = Math.min(minX, currentX);
                maxX = Math.max(maxX, currentX);
                minY = Math.min(minY, currentY);
                maxY = Math.max(maxY, currentY);
            }

            sb.append((maxX - minX) * (maxY - minY)).append("\n");
        }

        System.out.print(sb);
    }
}
