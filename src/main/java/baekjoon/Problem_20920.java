package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem_20920 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> wordCount = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String nextString = br.readLine();
            if (nextString.length() < M) {
                continue;
            }
            wordCount.put(nextString, wordCount.getOrDefault(nextString, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        wordCount.entrySet().stream()
            .sorted((o1, o2) -> {
                if (o1.getValue().equals(o2.getValue())) {
                    if (o1.getKey().length() == o2.getKey().length()) {
                        return o1.getKey().compareTo(o2.getKey());
                    }
                    return o2.getKey().length() - o1.getKey().length();
                }
                return o2.getValue() - o1.getValue();
            })
            .forEach(entry -> sb.append(entry.getKey()).append("\n"));

        bw.write(sb.toString());
        bw.flush();

    }
}
