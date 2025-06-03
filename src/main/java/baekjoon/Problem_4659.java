package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_4659 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("end")) {
                break;
            }

            boolean acceptable = true;
            boolean hasVowel = false;

            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                boolean isCurrentVowel = isVowel(currentChar);
                hasVowel |= isCurrentVowel;

                if (i >= 2) {
                    boolean isPrevVowel = isVowel(input.charAt(i - 1));
                    boolean isPrevPrevVowel = isVowel(input.charAt(i - 2));
                    if ((isCurrentVowel && isPrevVowel && isPrevPrevVowel) ||
                        (!isCurrentVowel && !isPrevVowel && !isPrevPrevVowel)) {
                        acceptable = false;
                        break;
                    }
                }

                if (i >= 1) {
                    char prevChar = input.charAt(i - 1);
                    if (currentChar == prevChar && currentChar != 'e' && currentChar != 'o') {
                        acceptable = false;
                        break;
                    }
                }
            }

            sb.append("<").append(input).append(">");
            if (hasVowel && acceptable) {
                sb.append(" is acceptable.").append("\n");
            } else {
                sb.append(" is not acceptable.").append("\n");
            }
        }
        System.out.print(sb);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
