package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_16937 implements ProblemInterface {

    private static final int WIDTH = 0;
    private static final int HEIGHT = 1;
    private static final int[][][] DIRECTIONS = {
        {{WIDTH, HEIGHT}, {WIDTH, HEIGHT}},
        {{WIDTH, HEIGHT}, {HEIGHT, WIDTH}},
        {{HEIGHT, WIDTH}, {WIDTH, HEIGHT}},
        {{HEIGHT, WIDTH}, {HEIGHT, WIDTH}},
    };

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());

        int[][] boards = {
            {H, W},
            {W, H}
        };

        int[][] stickers = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stickers[i][0] = Integer.parseInt(st.nextToken());
            stickers[i][1] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int[] board : boards) {
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    for (int[][] direction : DIRECTIONS) {
                        int[] firstStickerDirection = direction[0];
                        int[] secondStickerDirection = direction[1];

                        if (stickers[i][firstStickerDirection[HEIGHT]] <= board[HEIGHT]
                            && stickers[j][secondStickerDirection[HEIGHT]] <= board[HEIGHT]
                            && stickers[i][firstStickerDirection[WIDTH]]
                            + stickers[j][secondStickerDirection[WIDTH]] <= board[WIDTH]) {
                            result = Math.max(result,
                                stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1]);
                        }
                    }
                }
            }
        }

        System.out.print(result);
    }
}
