package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem_2448 implements ProblemInterface {

    private static char[][] map;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        map = new char[N][2 * N];
        Arrays.stream(map).forEach(row -> Arrays.fill(row, ' '));

        drawMap(N, N - 1, N - 1);
        
        for (char[] row : map) {
            bw.write(row);
            bw.newLine();
        }

        bw.flush();
    }

    private static void drawMap(int size, int row, int col) {
        if (size == 3) {
            map[row][col - 2] = '*';
            map[row][col - 1] = '*';
            map[row][col] = '*';
            map[row][col + 1] = '*';
            map[row][col + 2] = '*';

            map[row - 1][col - 1] = '*';
            map[row - 1][col + 1] = '*';

            map[row - 2][col] = '*';

            return;
        }

        size /= 2;
        drawMap(size, row - size, col);
        drawMap(size, row, col - size);
        drawMap(size, row, col + size);
    }
}
