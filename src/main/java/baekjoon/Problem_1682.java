package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_1682 implements ProblemInterface {
    private static final int[] FACT = new int[8];

    private static class Element {
        int[] array;
        int count;

        public Element(int[] array, int count) {
            this.array = array;
            this.count = count;
        }

    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] targetArray = new int[8];
        for (int i = 0; i < 8; i++) {
            targetArray[i] = Integer.parseInt(st.nextToken());
        }

        FACT[0] = 1;
        for (int i = 1; i < 8; i++) {
            FACT[i] = FACT[i - 1] * i;
        }

        boolean[] visited = new boolean[FACT[7] * 8];
        Queue<Element> queue = new LinkedList<>();

        int[] initState = { 1, 2, 3, 4, 5, 6, 7, 8 };
        queue.add(new Element(initState, 0));
        visited[encode(initState)] = true;

        while (!queue.isEmpty()) {
            Element element = queue.poll();
            if (isEqual(element.array, targetArray)) {
                System.out.print(element.count);
                return;
            }

            int[][] nexts = new int[][] {
                    transformA(element.array),
                    transformB(element.array),
                    transformC(element.array),
                    transformD(element.array)
            };

            for (int[] next : nexts) {
                int index = encode(next);
                if (visited[index]) {
                    continue;
                }

                visited[index] = true;
                queue.add(new Element(next, element.count + 1));

            }
        }
    }

    private static int[] transformA(int[] array) {
        return new int[] {
                array[7], array[6], array[5], array[4],
                array[3], array[2], array[1], array[0],
        };
    }

    private static int[] transformB(int[] array) {
        return new int[] {
                array[3], array[0], array[1], array[2],
                array[5], array[6], array[7], array[4]
        };
    }

    private static int[] transformC(int[] array) {
        return new int[] {
                array[0], array[2], array[5], array[3],
                array[4], array[6], array[1], array[7]
        };
    }

    private static int[] transformD(int[] array) {
        return new int[] {
                array[4], array[1], array[2], array[3],
                array[0], array[5], array[6], array[7]
        };
    }

    private static boolean isEqual(int[] array, int[] targetArray) {
        for (int i = 0; i < 8; i++) {
            if (array[i] != targetArray[i]) {
                return false;
            }
        }
        return true;
    }

    private static int encode(int[] a) {
        int rank = 0;
        for (int i = 0; i < 8; i++) {
            int smaller = 0;
            for (int j = i + 1; j < 8; j++) {
                if (a[j] < a[i])
                    smaller++;
            }
            rank += smaller * FACT[7 - i];
        }
        return rank;
    }

}
