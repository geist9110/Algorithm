package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import baekjoon.config.ProblemInterface;

public class Problem_24723 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        System.out.print((int) Math.pow(2,
                Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())));
    }
}
