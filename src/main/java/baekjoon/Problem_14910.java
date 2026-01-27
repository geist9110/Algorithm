package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_14910 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int previous = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int current = Integer.parseInt(st.nextToken());
            if (previous > current) {
                System.out.print("Bad");
                return;
            }
            previous = current;
        }
        System.out.print("Good");
    }

}
