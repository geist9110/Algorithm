package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1543 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String word = br.readLine();

        int result = 0;
        for (int i = 0; i < document.length(); i++) {
            int documentIndex = i;
            int wordIndex = 0;
            for (
                ; wordIndex < word.length() && documentIndex < document.length();
                wordIndex++, documentIndex++
            ) {
                if (document.charAt(documentIndex) != word.charAt(wordIndex)) {
                    break;
                }
            }

            if (wordIndex == word.length()) {
                result++;
                i = documentIndex - 1;
            }
        }

        System.out.print(result);
    }
}
