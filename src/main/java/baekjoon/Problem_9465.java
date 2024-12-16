package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_9465 implements ProblemInterface {

    private static final int FIRST_LINE = 0;
    private static final int SECOND_LINE = 1;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer firstLine = new StringTokenizer(br.readLine());
            StringTokenizer secondLine = new StringTokenizer(br.readLine());
            int[][] sticker = new int[2][n + 1];

            for (int i = 1; i <= n; i++) {
                sticker[FIRST_LINE][i] = Integer.parseInt(firstLine.nextToken());
                sticker[SECOND_LINE][i] = Integer.parseInt(secondLine.nextToken());
            }

            for (int i = 2; i <= n; i++) {
                sticker[FIRST_LINE][i] += Math.max(
                    sticker[SECOND_LINE][i - 1],
                    sticker[SECOND_LINE][i - 2]
                );
                sticker[SECOND_LINE][i] += Math.max(
                    sticker[FIRST_LINE][i - 1],
                    sticker[FIRST_LINE][i - 2]
                );
            }

            bw.write(
                String.valueOf(Math.max(sticker[FIRST_LINE][n], sticker[SECOND_LINE][n]))
            );
            bw.newLine();
        }

        bw.flush();
    }
}
