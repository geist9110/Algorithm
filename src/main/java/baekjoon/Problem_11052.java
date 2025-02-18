package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_11052 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cardPacks = new int[N + 1];
        for (int currentCard = 1; currentCard <= N; currentCard++) {
            cardPacks[currentCard] = Integer.parseInt(st.nextToken());
            for (int prevCard = 0; prevCard < currentCard; prevCard++) {
                cardPacks[currentCard] =
                        Math.max(cardPacks[currentCard],
                                cardPacks[prevCard] + cardPacks[currentCard - prevCard]);
            }
        }

        System.out.print(cardPacks[N]);
    }

}
