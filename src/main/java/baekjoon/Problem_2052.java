package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

import baekjoon.config.ProblemInterface;

public class Problem_2052 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        BigInteger result = BigInteger.valueOf(5).pow(N);
        String s = result.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        for (int i = 0; i < N - s.length(); i++) {
            sb.append("0");
        }
        sb.append(s);
        System.out.print(sb);
    }
}
