package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_15973 implements ProblemInterface {

    private static final int minX = 0;
    private static final int minY = 1;
    private static final int maxX = 2;
    private static final int maxY = 3;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] firstBox = new int[4];
        for (int i = 0; i < 4; i++) {
            firstBox[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] secondBox = new int[4];
        for (int i = 0; i < 4; i++) {
            secondBox[i] = Integer.parseInt(st.nextToken());
        }

        // POINT
        if (
            (firstBox[maxX] == secondBox[minX] && firstBox[maxY] == secondBox[minY])
                || (firstBox[maxX] == secondBox[minX] && firstBox[minY] == secondBox[maxY])
                || (firstBox[minX] == secondBox[maxX] && firstBox[minY] == secondBox[maxY])
                || (firstBox[minX] == secondBox[maxX] && firstBox[maxY] == secondBox[minY])
        ) {
            System.out.print("POINT");
            return;
        }

        // NULL
        if (
            (firstBox[maxX] < secondBox[minX])
                || (firstBox[maxY] < secondBox[minY])
                || (firstBox[minX] > secondBox[maxX])
                || (firstBox[minY] > secondBox[maxY])
        ) {
            System.out.print("NULL");
            return;
        }

        // LINE
        if (
            (firstBox[maxX] == secondBox[minX])
                || (firstBox[maxY] == secondBox[minY])
                || (firstBox[minX] == secondBox[maxX])
                || (firstBox[minY] == secondBox[maxY])
        ) {
            System.out.print("LINE");
            return;
        }

        System.out.print("FACE");

    }
}
