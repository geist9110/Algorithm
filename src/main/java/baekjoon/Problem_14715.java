package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import baekjoon.config.ProblemInterface;

public class Problem_14715 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int primeFactorCount = 0;
        for (int i = 2; i * i <= K; i++) {
            while (K % i == 0) {
                primeFactorCount++;
                K /= i;
            }
        }
        if (K > 1) {
            primeFactorCount++;
        }

        System.out.println(32 - Integer.numberOfLeadingZeros(primeFactorCount - 1));
    }

}
