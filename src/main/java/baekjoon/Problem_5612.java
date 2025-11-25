package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_5612 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int s = Integer.parseInt(br.readLine());
        int max = s;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            int output = Integer.parseInt(st.nextToken());
            s += input;
            s -= output;

            if (s < 0) {
                System.out.print(0);
                return;
            }
            max = Math.max(max, s);
        }

        System.out.print(max);
    }

}
