package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import baekjoon.config.ProblemInterface;

public class Problem_26147 implements ProblemInterface {

    private static final int WORDLE_LENGTH = 5;
    private static final char[] ANSWER_WORD = { 'A', 'B', 'C', 'D', 'E' };
    private static final char GRAY_WORD = 'F';

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append(ANSWER_WORD).append("\n");

        int N = Integer.parseInt(br.readLine());
        String[] wordleBoard = new String[N];
        for (int i = 0; i < N; i++) {
            wordleBoard[i] = br.readLine();
        }

        for (String wordle : wordleBoard) {
            if (isImpossible(wordle)) {
                System.out.print("IMPOSSIBLE");
                return;
            }

            char[] guess = new char[WORDLE_LENGTH];
            List<Integer> withoutGreenIndices = new ArrayList<>();
            for (int i = 0; i < WORDLE_LENGTH; i++) {
                if (wordle.charAt(i) == 'G') {
                    guess[i] = ANSWER_WORD[i];
                    continue;
                } else {
                    withoutGreenIndices.add(i);
                }
            }

            for (int i = 0; i < withoutGreenIndices.size(); i++) {
                int currentIndex = withoutGreenIndices.get(i);
                int nextIndex = withoutGreenIndices.get((i + 1) % withoutGreenIndices.size());

                if (wordle.charAt(currentIndex) == 'Y') {
                    guess[currentIndex] = ANSWER_WORD[nextIndex];
                } else {
                    guess[currentIndex] = GRAY_WORD;
                }
            }

            sb.append(guess).append("\n");
        }

        System.out.print(sb);
    }

    private static boolean isImpossible(String s) {
        int greenCount = 0;
        int yellowCount = 0;

        for (int i = 0; i < WORDLE_LENGTH; i++) {
            if (s.charAt(i) == 'G') {
                greenCount++;
            } else if (s.charAt(i) == 'Y') {
                yellowCount++;
            }
        }

        return greenCount == 4 && yellowCount == 1;
    }
}
