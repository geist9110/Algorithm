package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_1915 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] array = new int[n + 1][m + 1];
        int result = 0;
        for (int row = 1; row <= n; row++) {
            String s = br.readLine();
            for (int col = 1; col <= m; col++) {
                if (s.charAt(col - 1) == '0') {
                    continue;
                }

                array[row][col] = Math.min(array[row - 1][col - 1],
                        Math.min(array[row - 1][col], array[row][col - 1])) + 1;
                result = Math.max(result, array[row][col]);
            }
        }

        System.out.print(result * result);
    }

}
