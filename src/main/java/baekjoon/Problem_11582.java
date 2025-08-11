package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11582 implements ProblemInterface {

    private static int[] array;
    private static int k;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        k = Integer.parseInt(br.readLine());
        sort(0, N - 1, 1);

        for (int i : array) {
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }

    private static void sort(int start, int end, int currentSortPeople) {
        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        sort(start, mid, currentSortPeople * 2);
        sort(mid + 1, end, currentSortPeople * 2);

        if (currentSortPeople >= k) {
            conquer(start, end);
        }
    }

    private static void conquer(int start, int end) {
        int mid = (start + end) / 2;
        int left = start;
        int right = mid + 1;
        int tempArrayIndex = 0;
        int[] tempArray = new int[end - start + 1];

        while (left <= mid && right <= end) {
            if (array[left] <= array[right]) {
                tempArray[tempArrayIndex++] = array[left++];
                continue;
            }
            tempArray[tempArrayIndex++] = array[right++];
        }

        while (left <= mid) {
            tempArray[tempArrayIndex++] = array[left++];
        }

        while (right <= end) {
            tempArray[tempArrayIndex++] = array[right++];
        }

        System.arraycopy(tempArray, 0, array, start, tempArray.length);
    }
}
