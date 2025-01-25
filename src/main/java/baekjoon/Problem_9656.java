package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import baekjoon.config.ProblemInterface;

public class Problem_9656 implements ProblemInterface {
    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (Integer.parseInt(br.readLine()) % 2 == 0) {
            System.out.print("SK");
            return;
        }
        System.out.print("CY");
    }
}
