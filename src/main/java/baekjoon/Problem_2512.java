package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2512 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] budgets = new int[N];
        int left = 0;
        int right = 0;
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, budgets[i]);
        }
        right++;
        int maxBudget = Integer.parseInt(br.readLine());
        while (left < right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for (int budget : budgets) {
                sum += Math.min(budget, mid);
            }
            if (sum <= maxBudget) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.print(left - 1);
    }
}
