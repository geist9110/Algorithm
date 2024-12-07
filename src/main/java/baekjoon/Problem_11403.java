package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_11403 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        boolean[][] map = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (st.nextToken().equals("1")) {
                    map[i][j] = true;
                }
            }
        }

        for (int via = 0; via < N; via++) {
            for (int depart = 0; depart < N; depart++) {
                for (int arrive = 0; arrive < N; arrive++) {
                    if (map[depart][via] && map[via][arrive]) {
                        map[depart][arrive] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                sb.append(map[i][j] ? "1" : "0").append(" ");
            }
            bw.write(sb.toString().trim());
            sb.setLength(0);
            bw.newLine();
        }

        bw.flush();
    }
}
