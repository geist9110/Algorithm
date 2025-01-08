package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_10942 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] isPalindrom = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            isPalindrom[i][i] = true;
        }

        for (int i = 1; i < N; i++) {
            if (sequence[i] == sequence[i + 1]) {
                isPalindrom[i][i + 1] = true;
            }
        }

        for (int window = 3; window <= N; window++) {
            for (int i = 1; i <= N - window + 1; i++) {
                int strat = i;
                int end = i + window - 1;
                if (sequence[strat] == sequence[end] && isPalindrom[strat + 1][end - 1]) {
                    isPalindrom[strat][end] = true;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (isPalindrom[start][end]) {
                bw.write("1\n");
                continue;
            }
            bw.write("0\n");
        }

        bw.flush();
    }
}
