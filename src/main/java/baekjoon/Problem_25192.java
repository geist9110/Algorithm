package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Problem_25192 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            String message = br.readLine();
            if (message.equals("ENTER")) {
                count += set.size();
                set.clear();
                continue;
            }
            set.add(message);
        }
        count += set.size();

        System.out.println(count);
    }
}
