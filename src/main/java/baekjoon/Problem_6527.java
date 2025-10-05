package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem_6527 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int bullshitCount = 0;
        int wordCount = 0;
        Set<String> words = new HashSet<>();

        Pattern p = Pattern.compile("[A-Z]+");

        while (br.ready()) {
            Matcher matcher = p.matcher(br.readLine().toUpperCase());
            while (matcher.find()) {
                String word = matcher.group();
                if (word.equals("BULLSHIT")) {
                    bullshitCount++;
                    wordCount += words.size();
                    words.clear();
                    continue;
                }
                words.add(word);
            }
        }

        int div = gcd(wordCount, bullshitCount);
        System.out.printf("%d / %d", wordCount / div, bullshitCount / div);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
