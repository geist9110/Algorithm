package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_16194 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cardPack = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            cardPack[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < i; j++) {
                cardPack[i] = Math.min(cardPack[i], cardPack[i - j] + cardPack[j]);
            }
        }

        System.out.print(cardPack[N]);
    }

}
