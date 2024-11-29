package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_11727 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n + 2];
        array[1] = 1;
        array[2] = 3;

        int mod = 10_007;
        for (int i = 3; i <= n + 1; i++) {
            array[i] = (array[i - 1] + (2 * array[i - 2] % mod)) % mod;
        }

        bw.write(String.valueOf(array[n]));
        bw.flush();
    }
}
