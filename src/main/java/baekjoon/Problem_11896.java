package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11896 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = (Long.parseLong(st.nextToken()) + 1) / 2 * 2;
        long b = Long.parseLong(st.nextToken()) / 2 * 2;

        long n = (b - a) / 2 + 1;
        long result = n * (a + (n - 1));
        if (a <= 2 && 2 <= b) {
            result -= 2;
        }
        System.out.print(result);
    }
}
