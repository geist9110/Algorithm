package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_25327 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            String fruit = st.nextToken();
            String color = st.nextToken();

            map.merge("", 1, Integer::sum);
            map.merge(subject, 1, Integer::sum);
            map.merge(fruit, 1, Integer::sum);
            map.merge(color, 1, Integer::sum);
            map.merge(subject + fruit, 1, Integer::sum);
            map.merge(subject + color, 1, Integer::sum);
            map.merge(fruit + color, 1, Integer::sum);
            map.merge(subject + fruit + color, 1, Integer::sum);
        }

        for (int i = 0; i < m; i++) {
            String query = br.readLine().replace("-", "").replace(" ", "");
            sb.append(map.getOrDefault(query, 0)).append("\n");
        }

        System.out.print(sb);
    }

}
