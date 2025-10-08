package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_25326 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][][] count = new int[4][4][4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int subject = toIndex(st.nextToken());
            int fruit = toIndex(st.nextToken());
            int color = toIndex(st.nextToken());

            count[subject][fruit][color]++;
            count[subject][fruit][0]++;
            count[subject][0][color]++;
            count[0][fruit][color]++;
            count[subject][0][0]++;
            count[0][fruit][0]++;
            count[0][0][color]++;
            count[0][0][0]++;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int subject = toIndex(st.nextToken());
            int fruit = toIndex(st.nextToken());
            int color = toIndex(st.nextToken());

            sb.append(count[subject][fruit][color]).append("\n");
        }

        System.out.print(sb);
    }

    private static int toIndex(String s) {
        if (s.equals("kor") || s.equals("apple") || s.equals("red")) {
            return 1;
        }

        if (s.equals("eng") || s.equals("pear") || s.equals("blue")) {
            return 2;
        }

        if (s.equals("math") || s.equals("orange") || s.equals("green")) {
            return 3;
        }

        return 0;
    }
}
