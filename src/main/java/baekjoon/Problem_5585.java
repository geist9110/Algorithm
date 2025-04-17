package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_5585 implements ProblemInterface {

    private static final int[] COINS = {500, 100, 50, 10, 5, 1};

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int change = 1000 - Integer.parseInt(br.readLine());

        int result = 0;
        for (int coin : COINS) {
            int remain = change / coin;
            result += remain;
            change -= remain * coin;
        }

        System.out.println(result);
    }
}
