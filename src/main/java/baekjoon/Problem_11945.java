package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem_11945 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        String[] taiyaki = new String[row];
        for (int i = 0; i < row; i++) {
            taiyaki[i] = br.readLine();
        }

        for (int i = 0; i < row; i++) {
            for (int j = col - 1; j >= 0; j--) {
                bw.write(taiyaki[i].charAt(j));
            }
            bw.write("\n");
        }

        bw.flush();
    }
}
