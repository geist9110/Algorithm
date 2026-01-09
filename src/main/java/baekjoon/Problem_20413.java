package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_20413 implements ProblemInterface {

    private static final char[] RATING = { 'B', 'S', 'G', 'P', 'D' };

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Character, Integer> rateMap = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            rateMap.put(RATING[i], Integer.parseInt(st.nextToken()) - 1);
        }
        rateMap.put(RATING[4], rateMap.get(RATING[3]) + 1);

        int previousAmount = 0;
        int totalAmount = 0;
        String rating = br.readLine();

        for (int i = 0; i < rating.length(); i++) {
            char rate = rating.charAt(i);
            int limit = rateMap.get(rate);

            previousAmount = limit - previousAmount;
            if (rate == RATING[4]) {
                totalAmount += limit;
            } else {
                totalAmount += previousAmount;
            }
        }

        System.out.print(totalAmount);
    }
}
