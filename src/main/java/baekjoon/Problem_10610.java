package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem_10610 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] N = br.readLine().toCharArray();

        int sum = 0;
        boolean isContainZero = false;
        for (int i = 0; i < N.length; i++) {
            int n = N[i] - '0';
            if (n == 0) {
                isContainZero = true;
                continue;
            }
            sum += n;
        }

        if (!isContainZero || sum % 3 != 0) {
            bw.write("-1");
            bw.flush();
            return;
        }

        Arrays.sort(N);
        for (int i = N.length - 1; i >= 0; i--) {
            bw.write(N[i]);
        }
        bw.flush();
    }
}
