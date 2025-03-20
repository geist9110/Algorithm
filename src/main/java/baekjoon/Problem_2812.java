package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_2812 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String number = br.readLine();
        Deque<Character> deque = new ArrayDeque<>();

        int index = 0;
        while (index < N && K > 0) {
            while (!deque.isEmpty() && deque.peekLast() < number.charAt(index) && K > 0) {
                deque.pollLast();
                K--;
            }
            deque.addLast(number.charAt(index++));
        }

        while (index < N) {
            deque.addLast(number.charAt(index++));
        }

        for (int i = deque.size() - K; i > 0; i--) {
            bw.write(deque.pollFirst());
        }

        bw.flush();
    }

}
