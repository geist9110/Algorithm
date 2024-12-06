package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_6064 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long M = Long.parseLong(st.nextToken());
            long N = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken()) - 1;
            long y = Long.parseLong(st.nextToken()) - 1;

            long lcm = lcm(M, N);
            long year = -1;
            for (; x <= lcm; x += M) {
                if (x % N == y) {
                    year = x + 1;
                    break;
                }
            }
            bw.write(year + "\n");
        }
        bw.flush();
    }

    private static long lcm(long M, long N) {
        return M * N / gcd(M, N);
    }

    private static long gcd(long M, long N) {
        if (N == 0) {
            return M;
        }
        return gcd(N, M % N);
    }
}
