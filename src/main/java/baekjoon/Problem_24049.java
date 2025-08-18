package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_24049 implements ProblemInterface {

    private static final String YELLOW = "0";
    private static final String RED = "1";

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] leftSideFlowers = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            leftSideFlowers[i] = st.nextToken().equals(RED);
        }

        boolean[] row = new boolean[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            row[i] = st.nextToken().equals(RED);
        }

        for (int i = 0; i < N; i++) {
            if (leftSideFlowers[i] == row[0]) {
                row[0] = false;
            } else {
                row[0] = true;
            }
            for (int j = 1; j < M; j++) {
                if (row[j - 1] == row[j]) {
                    row[j] = false;
                } else {
                    row[j] = true;
                }
            }
        }

        System.out.print(row[M - 1] ? RED : YELLOW);
    }
}
