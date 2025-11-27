package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_12971 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int P1 = Integer.parseInt(st.nextToken());
        int P2 = Integer.parseInt(st.nextToken());
        int P3 = Integer.parseInt(st.nextToken());
        int X1 = Integer.parseInt(st.nextToken());
        int X2 = Integer.parseInt(st.nextToken());
        int X3 = Integer.parseInt(st.nextToken());

        int result = -1;
        for (int N = 1; N <= P1 * P2 * P3; N++) {
            if (N % P1 == X1 && N % P2 == X2 && N % P3 == X3) {
                result = N;
                break;
            }
        }
        System.out.print(result);
    }

}
