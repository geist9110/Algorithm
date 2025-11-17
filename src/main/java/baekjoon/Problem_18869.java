package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_18869 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] spaces = new int[M][N];
        List<List<Integer>> sortedSpaces = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> space = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                spaces[i][j] = Integer.parseInt(st.nextToken());
                space.add(spaces[i][j]);
            }
            Collections.sort(space);
            sortedSpaces.add(space);
        }

        int[][] compressedSpace = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                compressedSpace[i][j] = Collections.binarySearch(sortedSpaces.get(i), spaces[i][j]);
            }
        }

        int result = 0;
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                if (Arrays.equals(compressedSpace[i], compressedSpace[j])) {
                    result++;
                }
            }
        }

        System.out.print(result);
    }

}
