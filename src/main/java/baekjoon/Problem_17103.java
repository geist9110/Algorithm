package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_17103 implements ProblemInterface {

    private static final int PRIME_ARRAY_LENGTH = 1000001;

    public void solution(String[] args) throws IOException {
        boolean[] primeArray = new boolean[PRIME_ARRAY_LENGTH];
        primeArray[0] = true;
        primeArray[1] = true;
        primeArray[2] = false;
        primeArray[3] = false;

        for (int i = 2; i * i < PRIME_ARRAY_LENGTH; i++) {
            if (primeArray[i]) {
                continue;
            }

            for (int j = i * i; j < PRIME_ARRAY_LENGTH; j += i) {
                primeArray[j] = true;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;
            int half = N / 2;
            while (half >= 2) {
                if (!primeArray[half] && !primeArray[N - half]) {
                    cnt++;
                }
                half--;
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb.toString().trim());
    }
}
