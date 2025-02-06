package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import baekjoon.config.ProblemInterface;

public class Problem_9658 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()) % 7;

        if (N == 1 || N == 3) {
            bw.write("CY");
            bw.flush();
            return;
        }

        bw.write("SK");
        bw.flush();
    }

}
