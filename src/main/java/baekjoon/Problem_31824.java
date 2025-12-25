package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

import baekjoon.config.ProblemInterface;

public class Problem_31824 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        SortedMap<String, String> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            String value = st.nextToken();
            map.put(key, value);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            StringBuilder querySb = new StringBuilder();
            for (int startIndex = 0; startIndex < query.length(); startIndex++) {
                for (String key : map.keySet()) {
                    if (query.startsWith(key, startIndex)) {
                        querySb.append(map.get(key));
                    }
                }
            }

            if (querySb.length() == 0) {
                sb.append("-1\n");
            } else {
                sb.append(querySb).append("\n");
            }
        }

        System.out.print(sb);
    }

}
