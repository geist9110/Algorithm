package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_15734 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        int min = Math.min(l, r);
        int max = Math.max(l, r);

        int diff = max - min;
        if (a >= diff) {
            min += diff;
            a -= diff;
        } else {
            min += a;
            a = 0;
        }

        System.out.print((min + a / 2) * 2);
    }
}
