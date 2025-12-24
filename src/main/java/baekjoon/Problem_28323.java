package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_28323 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean isOdd = Integer.parseInt(st.nextToken()) % 2 == 1;
        int result = 1;

        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (isOdd && num % 2 == 0 || !isOdd && num % 2 == 1) {
                result++;
                isOdd = !isOdd;
            }
        }

        System.out.print(result);
    }

}
