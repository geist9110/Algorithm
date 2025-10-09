package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_33897 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sliceCount = 1;
        int maxSlice = 0;
        int currentNumber = 0;
        int currentSlice = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num >= currentNumber) {
                currentSlice++;
                currentNumber = num;
                continue;
            }

            sliceCount++;
            maxSlice = Math.max(maxSlice, currentSlice);
            currentSlice = 1;
            currentNumber = num;
        }
        maxSlice = Math.max(maxSlice, currentSlice);
        System.out.printf("%d %d", sliceCount, maxSlice);
    }
}
