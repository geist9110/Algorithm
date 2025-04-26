package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_16486 implements ProblemInterface {

    private static final double PI = 3.141592;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double width = Double.parseDouble(br.readLine());
        double height = Double.parseDouble(br.readLine());

        System.out.print(width * 2 + 2 * PI * height);

    }
}
