package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Problem_7785 implements ProblemInterface {

    private static final String LEAVE = "leave";

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String log = st.nextToken();

            if (log.equals(LEAVE)) {
                set.remove(name);
                continue;
            }
            set.add(name);
        }

        StringBuilder sb = new StringBuilder();
        for (String company : set) {
            sb.append(company).append("\n");
        }
        System.out.print(sb.toString().trim());
    }
}
