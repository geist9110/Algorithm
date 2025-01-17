package baekjoon;

import java.io.IOException;
import java.util.Scanner;
import baekjoon.config.ProblemInterface;

public class Problem_15439 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(N * (N - 1));
        sc.close();
    }
}
