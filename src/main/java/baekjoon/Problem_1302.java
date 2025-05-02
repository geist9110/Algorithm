package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem_1302 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        int titleCount = 0;
        String maxCountTitle = "{";

        for (int i = 0; i < N; i++) {
            String title = br.readLine();
            int count = map.getOrDefault(title, 0) + 1;
            map.put(title, count);

            if (count < titleCount) {
                continue;
            }

            if (count == titleCount && maxCountTitle.compareTo(title) < 0) {
                continue;
            }

            maxCountTitle = title;
            titleCount = count;
        }

        System.out.print(maxCountTitle);
    }
}
