package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import baekjoon.config.ProblemInterface;

public class Problem_34530 implements ProblemInterface {

    private static final int FULL_ANGLE = 360;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int d = Integer.parseInt(br.readLine());
        System.out.println(FULL_ANGLE / getGCD(FULL_ANGLE, d));
    }

    private static int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

}
