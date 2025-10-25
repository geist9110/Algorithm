package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_29198 implements ProblemInterface {

    private static class WordCount implements Comparable<WordCount> {

        int[] counts = new int[26];

        public WordCount(String word) {
            for (char w : word.toCharArray()) {
                counts[w - 'A']++;
            }
        }

        @Override
        public int compareTo(WordCount o) {
            for (int i = 0; i < o.counts.length; i++) {
                if (this.counts[i] > o.counts[i]) {
                    return -1;
                }

                if (this.counts[i] < o.counts[i]) {
                    return 1;
                }
            }
            return 0;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        WordCount[] words = new WordCount[N];
        for (int i = 0; i < N; i++) {
            words[i] = new WordCount(br.readLine());
        }

        Arrays.sort(words);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            for (int k = 0; k < K; k++) {
                for (int j = 0; j < words[k].counts[i]; j++) {
                    sb.append((char) (i + 'A'));
                }
            }
        }

        System.out.print(sb);
    }
}