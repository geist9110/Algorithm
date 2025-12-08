package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_4781 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = priceToInt(st.nextToken());
        while (n != 0 && m != 0) {

            int[] calories = new int[m + 1];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int calorie = Integer.parseInt(st.nextToken());
                int price = priceToInt(st.nextToken());

                for (int money = price; money <= m; money++) {
                    calories[money] = Math.max(
                            calories[money],
                            calories[money - price] + calorie);
                }
            }

            sb.append(calories[m]).append("\n");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = priceToInt(st.nextToken());
        }
        System.out.print(sb);
    }

    private static int priceToInt(String s) {
        double v = Double.parseDouble(s);
        return (int) (v * 100 + 0.5);
    }

}
