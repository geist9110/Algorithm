package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import baekjoon.config.ProblemInterface;

public class Problem_2440 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = N; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                bw.write("*");
            }
            bw.newLine();
        }
        bw.flush();
    }

}
