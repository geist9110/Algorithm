package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Problem_11656 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        LinkedList<String> suffixes = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            suffixes.add(S.substring(i));
        }

        suffixes.sort(String::compareTo);

        for (String s : suffixes) {
            bw.write(s);
            bw.newLine();
        }
        bw.flush();
    }
}
