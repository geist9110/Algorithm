package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_24954 implements ProblemInterface {

    private static class Discount {
        int index;
        int price;

        public Discount(int index, int price) {
            this.index = index;
            this.price = price;
        }
    }

    private static List<List<Discount>> discounts;
    private static int[] prices;
    private static boolean[] visited;
    private static int N;
    private static int result = Integer.MAX_VALUE;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        prices = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        discounts = new ArrayList<>();
        discounts.add(new ArrayList<>());
        for (int i = 1; i <= N; i++) {
            int p = Integer.parseInt(br.readLine());
            List<Discount> discountList = new ArrayList<>();
            for (int j = 0; j < p; j++) {
                st = new StringTokenizer(br.readLine());
                discountList.add(
                        new Discount(
                                Integer.parseInt(st.nextToken()),
                                Integer.parseInt(st.nextToken())));
            }

            discounts.add(discountList);
        }

        visited = new boolean[N + 1];
        dfs(0, 0);
        System.out.print(result);
    }

    private static void dfs(int depth, int sum) {
        if (sum >= result) {
            return;
        }

        if (depth == N) {
            result = Math.min(result, sum);
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            for (Discount discount : discounts.get(i)) {
                prices[discount.index] -= discount.price;
            }

            dfs(depth + 1, sum + Math.max(prices[i], 1));

            visited[i] = false;
            for (Discount discount : discounts.get(i)) {
                prices[discount.index] += discount.price;
            }
        }
    }

}
