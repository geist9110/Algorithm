package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_17939 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] price = new int[N];
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int profit = 0;
        int maxPrice = 0;
        for (int i = N - 1; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, price[i]);
            profit += maxPrice - price[i];
        }

        System.out.print(profit);

    }

}
