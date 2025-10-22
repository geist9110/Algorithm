package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem_5555 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String findString = br.readLine();
        Pattern pattern = Pattern.compile(findString);
        int N = Integer.parseInt(br.readLine());
        int reuslt = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            s = s + s;
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                reuslt++;
            }
        }
        System.out.print(reuslt);
    }
}
