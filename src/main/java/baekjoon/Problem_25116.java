package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_25116 implements ProblemInterface {

    private static int N;
    private static long M;
    private static long[] A;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        A = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        long low = 0;
        long high = M;
        long answer = -1;
        while (low <= high) {
            long X = (low + high) / 2;

            if (countInterestingSection(X) >= K) {
                answer = X;
                high = X - 1;
            } else {
                low = X + 1;
            }
        }

        System.out.print(answer);
    }

    private static long countInterestingSection(long X) {
        long count = 0;
        int left = 0;
        int right = 0;
        long sum = 0;

        while (left < N) {
            while (right < N && sum < M) {
                sum += A[right++] + X;
            }

            if (sum >= M) {
                count += (N - right + 1);
            }

            sum -= (A[left++] + X);
        }

        return count;
    }
}
