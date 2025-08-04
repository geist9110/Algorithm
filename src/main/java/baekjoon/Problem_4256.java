package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem_4256 implements ProblemInterface {

    private static int[] preOrder;
    private static int[] inOrder;
    private static Stack<Integer> stack = new Stack<>();

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            preOrder = new int[n];
            inOrder = new int[n];

            StringTokenizer preOrderTokenizer = new StringTokenizer(br.readLine());
            StringTokenizer inOrderTokenizer = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                preOrder[i] = Integer.parseInt(preOrderTokenizer.nextToken());
                inOrder[i] = Integer.parseInt(inOrderTokenizer.nextToken());
            }

            makePostOrder(0, 0, n - 1);
            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void makePostOrder(int preOrderStart, int inOrderStart, int inOrderEnd) {
        if (inOrderStart > inOrderEnd) {
            return;
        }

        int rootValue = preOrder[preOrderStart];
        int rootIndex = -1;
        for (int i = inOrderStart; i <= inOrderEnd; i++) {
            if (inOrder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        stack.push(rootValue);
        makePostOrder(preOrderStart + rootIndex - inOrderStart + 1, rootIndex + 1, inOrderEnd);
        makePostOrder(preOrderStart + 1, inOrderStart, rootIndex - 1);
    }
}
