package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_15921 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.print("divide by zero");
            return;
        }

        double sum = 0;
        double[] counts = new double[101];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(st.nextToken());
            counts[score]++;
            sum += score;
        }

        double average = sum / N;
        double expectedValue = 0;
        for (int i = 0; i <= 100; i++) {
            if (counts[i] == 0) {
                continue;
            }

            expectedValue += i * (counts[i] / N);
        }

        if (expectedValue == 0) {
            System.out.print("divide by zero");
            return;
        }
        System.out.printf("%.2f", average / expectedValue);
    }

}
