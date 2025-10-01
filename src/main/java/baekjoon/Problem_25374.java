package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_25374 implements ProblemInterface {

    private static final int[] ratio = {4, 11, 23, 40, 60, 77, 89, 96, 100};

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[101];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }

        int previousCount = 0;
        int currentCount = 0;
        int currentRatio = 0;
        for (int i = 100; i >= 0 && currentRatio < ratio.length; i--) {
            currentCount += arr[i];

            while (currentRatio < ratio.length && currentCount * 100 / N >= ratio[currentRatio]) {
                sb.append(currentCount - previousCount).append("\n");
                previousCount = currentCount;
                currentRatio++;
            }
        }

        System.out.print(sb);
    }
}
