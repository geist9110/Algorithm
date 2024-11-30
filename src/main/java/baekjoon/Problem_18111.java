package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_18111 implements ProblemInterface {

    private static final int MAX_HEIGHT = 256;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] heightCountArray = new int[MAX_HEIGHT + 1];
        int[] times = new int[MAX_HEIGHT + 1];
        int[] remainBlocks = new int[MAX_HEIGHT + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                heightCountArray[Integer.parseInt(st.nextToken())]++;
            }
        }

        Arrays.fill(remainBlocks, B);

        int height = 0;

        for (int currentHeight = 0; currentHeight <= MAX_HEIGHT; currentHeight++) {
            for (int fromHeight = 0; fromHeight < currentHeight; fromHeight++) {
                addBlock(
                    fromHeight,
                    currentHeight,
                    heightCountArray[fromHeight],
                    times,
                    remainBlocks
                );
            }
            for (int toHeight = currentHeight + 1; toHeight <= MAX_HEIGHT; toHeight++) {
                removeBlock(
                    currentHeight,
                    toHeight,
                    heightCountArray[toHeight],
                    times,
                    remainBlocks
                );
            }

            if (remainBlocks[currentHeight] < 0) {
                break;
            }

            if (times[height] >= times[currentHeight]) {
                height = currentHeight;
            }
        }

        System.out.printf("%d %d", times[height], height);
    }

    private static void addBlock(
        int fromHeight,
        int toHeight,
        int quantity,
        int[] times,
        int[] remainBlocks
    ) {
        times[toHeight] += quantity * (toHeight - fromHeight);
        remainBlocks[toHeight] -= quantity * (toHeight - fromHeight);
    }

    private static void removeBlock(
        int fromHeight,
        int toHeight,
        int quantity,
        int[] times,
        int[] remainBlocks
    ) {
        times[fromHeight] += 2 * quantity * (toHeight - fromHeight);
        remainBlocks[fromHeight] += quantity * (toHeight - fromHeight);
    }
}
