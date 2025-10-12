package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_32687 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int minRange = (int) Math.pow(10, K - 1);
        int maxRange = (int) Math.pow(10, K);
        long count = 0;
        int[] array = new int[K];

        int number = minRange;
        for (int j = K - 1; j >= 0; j--) {
            array[j] = number % 10;
            number /= 10;
        }

        for (int i = minRange; i < maxRange; i++) {
            int sIndex = 0;
            long value = i;
            while (value <= B) {
                if (value >= A && value % M == 0) {
                    count++;
                }

                value = value * 10 + array[sIndex];
                sIndex = (sIndex + 1) % K;
            }

            for (int j = K - 1; j >= 0; j--) {
                if (++array[j] > 9) {
                    array[j] = 0;
                    continue;
                }
                break;
            }
        }

        System.out.print(count);
    }
}
