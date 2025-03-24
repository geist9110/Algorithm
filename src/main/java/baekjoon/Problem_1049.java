package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_1049 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int minBrandPrice = Integer.MAX_VALUE;
        int minEachPrice = Integer.MAX_VALUE;
        for (int M = Integer.parseInt(st.nextToken()); M > 0; M--) {
            st = new StringTokenizer(br.readLine());
            minBrandPrice = Math.min(minBrandPrice, Integer.parseInt(st.nextToken()));
            minEachPrice = Math.min(minEachPrice, Integer.parseInt(st.nextToken()));
        }

        int result = minEachPrice * N;
        result = Math.min(result, (N / 6 + 1) * minBrandPrice);
        result = Math.min(result, N / 6 * minBrandPrice + N % 6 * minEachPrice);
        System.out.print(result);
    }

}
