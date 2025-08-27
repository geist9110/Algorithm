package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_15784 implements ProblemInterface {

    private static int N;
    private static int a;
    private static int b;
    private static int[][] attractiveness;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken()) - 1;
        b = Integer.parseInt(st.nextToken()) - 1;

        attractiveness = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                attractiveness[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (isHappy()) {
            System.out.print("HAPPY");
            return;
        }
        System.out.print("ANGRY");
    }

    private static boolean isHappy() {
        for (int row = 0; row < N; row++) {
            if (attractiveness[row][b] > attractiveness[a][b]) {
                return false;
            }
        }

        for (int col = 0; col < N; col++) {
            if (attractiveness[a][col] > attractiveness[a][b]) {
                return false;
            }
        }

        return true;
    }
}
