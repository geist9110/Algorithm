package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1487 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] prices = new int[N];
        int[] deliveryPrices = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            prices[i] = Integer.parseInt(st.nextToken());
            deliveryPrices[i] = Integer.parseInt(st.nextToken());
        }

        int totalProfit = 0;
        int resultPrice = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int profit = 0;

            for (int j = 0; j < N; j++) {
                if (prices[j] < prices[i] || prices[i] < deliveryPrices[j]) {
                    continue;
                }

                profit += prices[i] - deliveryPrices[j];
            }

            if (profit > totalProfit) {
                totalProfit = profit;
                resultPrice = prices[i];
                continue;
            }

            if (profit > 0 && profit == totalProfit) {
                resultPrice = Math.min(resultPrice, prices[i]);
            }
        }

        if (resultPrice == Integer.MAX_VALUE) {
            System.out.print(0);
            return;
        }
        System.out.println(resultPrice);
    }
}
