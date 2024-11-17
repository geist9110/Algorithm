package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_15829 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String s = br.readLine();

        long r = 1;
        long rMultiply = 31;
        long M = 1234567891;
        long sum = 0;

        for(char c : s.toCharArray()) {
            sum = (sum + ((c - 'a' + 1) * r) % M) % M;
            r = (r*rMultiply) % M;
        }

        System.out.print(sum);
    }
}
