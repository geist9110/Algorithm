package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_1980 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int maxHamburger = 0;
        int minColaTime = Integer.MAX_VALUE;

        for (int i = t / n; i >= 0; i--) {
            int leftTime = t - i * n;
            int colaTime = leftTime % m;
            int hamburger = i + leftTime / m;

            if (colaTime < minColaTime) {
                maxHamburger = hamburger;
                minColaTime = colaTime;
            } else if (colaTime == minColaTime) {
                maxHamburger = Math.max(maxHamburger, hamburger);
            }
        }

        System.out.printf("%d %d", maxHamburger, minColaTime);
    }

}
