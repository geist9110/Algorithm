package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2346 implements ProblemInterface {

    private static class Node {

        private final int index;
        private final int value;

        private Node next;
        private Node prev;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] array = br.readLine().split(" ");

        Node current = new Node(1, Integer.parseInt(array[0]));
        Node temp = current;

        for (int i = 1; i < array.length; i++) {
            Node next = new Node(i + 1, Integer.parseInt(array[i]));
            temp.next = next;
            next.prev = temp;
            temp = next;
        }

        current.prev = temp;
        temp.next = current;

        for (int i = 0; i < N; i++) {
            sb.append(current.index).append(" ");
            int moveCnt = current.value;
            temp = current;
            current.prev.next = current.next;
            current.next.prev = current.prev;

            if (moveCnt > 0) {
                for (int j = 0; j < moveCnt; j++) {
                    temp = temp.next;
                }
            } else {
                for (int j = 0; j < -moveCnt; j++) {
                    temp = temp.prev;
                }
            }

            current = temp;
        }

        System.out.print(sb.toString().trim());
    }
}
