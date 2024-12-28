package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem_26069 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        set.add("ChongChong");
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String leftPerson = st.nextToken();
            String rightPerson = st.nextToken();

            if (set.contains(leftPerson)) {
                set.add(rightPerson);
            }

            if (set.contains(rightPerson)) {
                set.add(leftPerson);
            }
        }
        System.out.print(set.size());
    }
}
