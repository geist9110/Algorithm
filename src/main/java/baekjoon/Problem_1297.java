package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1297 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double D = Double.parseDouble(st.nextToken());
        double H = Double.parseDouble(st.nextToken());
        double W = Double.parseDouble(st.nextToken());

        double ratio = Math.sqrt(D * D / (H * H + W * W));
        int width = (int) Math.floor(ratio * W);
        int height = (int) Math.floor(ratio * H);
        System.out.print(String.format("%d %d", height, width));
    }
}
