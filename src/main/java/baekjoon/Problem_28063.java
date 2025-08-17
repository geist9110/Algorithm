package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_28063 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        if (N == 1) {
            System.out.print(0);
            return;
        }

        int result = 4;
        if (x == 1 || x == N) {
            result--;
        }

        if (y == 1 || y == N) {
            result--;
        }

        System.out.print(result);
    }
}
