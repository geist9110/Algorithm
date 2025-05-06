package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_5052 implements ProblemInterface {

    private static class Node {

        boolean isLast;
        boolean isEmpty = true;
        Node[] children = new Node[10];

        public Node() {
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            Node root = new Node();
            boolean isConsistency = true;
            for (int n = Integer.parseInt(br.readLine()); n > 0; n--) {
                String number = br.readLine();
                Node currentNode = root;
                for (int i = 0; i < number.length(); i++) {
                    int c = number.charAt(i) - '0';
                    if (currentNode.children[c] == null) {
                        currentNode.isEmpty = false;
                        currentNode.children[c] = new Node();
                        currentNode = currentNode.children[c];
                        continue;
                    }

                    if (currentNode.children[c].isLast) {
                        isConsistency = false;
                        break;
                    }

                    currentNode = currentNode.children[c];
                }

                currentNode.isLast = true;

                if (!currentNode.isEmpty) {
                    isConsistency = false;
                    for (; n > 1; n--) {
                        br.readLine();
                    }
                    break;
                }
            }

            if (isConsistency) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
    }
}
