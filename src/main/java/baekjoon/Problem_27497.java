package baekjoon;

import baekjoon.config.ProblemInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem_27497 implements ProblemInterface {

    private static class Block {
        char operator;
        char c;

        public Block(char c, char operator) {
            this.c = c;
            this.operator = operator;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Block> blocks = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            char operator = s.charAt(0);
            if (operator == '1' || operator == '2') {
                blocks.add(new Block(s.charAt(2), operator));
                continue;
            }
            if (!blocks.isEmpty()) {
                blocks.pop();
            }
        }

        if (blocks.isEmpty()) {
            System.out.print(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        Stack<Character> backwardChars = new Stack<>();
        while (!blocks.isEmpty()) {
            Block block = blocks.pop();
            if (block.operator == '2') {
                sb.append(block.c);
                continue;
            }
            backwardChars.add(block.c);
        }
        while (!backwardChars.isEmpty()) {
            sb.append(backwardChars.pop());
        }

        System.out.print(sb);
    }
}
