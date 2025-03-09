package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_11728 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int AIndex = 0;
        int BIndex = 0;
        while (AIndex < N && BIndex < M) {
            if (A[AIndex] < B[BIndex]) {
                bw.write(A[AIndex++] + " ");
                continue;
            }

            bw.write(B[BIndex++] + " ");
        }

        while (AIndex < N) {
            bw.write(A[AIndex++] + " ");
        }
        while (BIndex < M) {
            bw.write(B[BIndex++] + " ");
        }

        bw.flush();
    }

}
