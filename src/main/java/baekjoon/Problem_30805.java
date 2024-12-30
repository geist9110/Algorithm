package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_30805 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> firstArray = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            firstArray.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        LinkedList<Integer> secondArray = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            secondArray.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> result = findLastLCS(firstArray, secondArray, new LinkedList<>());
        sb.append(result.size()).append("\n");
        for (Integer i : result) {
            sb.append(i).append(" ");
        }

        System.out.print(sb);
    }

    private static List<Integer> findLastLCS(
        List<Integer> firstArray,
        List<Integer> secondArray,
        List<Integer> result
    ) {
        if (firstArray.isEmpty() || secondArray.isEmpty()) {
            return result;
        }

        int firstArrayMaxIndex = firstArray.indexOf(Collections.max(firstArray));
        int firstArrayMaxValue = firstArray.get(firstArrayMaxIndex);
        int secondArrayMaxIndex = secondArray.indexOf(Collections.max(secondArray));
        int secondArrayMaxValue = secondArray.get(secondArrayMaxIndex);

        if (firstArrayMaxValue == secondArrayMaxValue) {
            result.add(firstArray.get(firstArrayMaxIndex));
            return findLastLCS(
                firstArray.subList(firstArrayMaxIndex + 1, firstArray.size()),
                secondArray.subList(secondArrayMaxIndex + 1, secondArray.size()),
                result
            );
        }

        if (firstArrayMaxValue > secondArrayMaxValue) {
            firstArray.remove(firstArrayMaxIndex);
            return findLastLCS(firstArray, secondArray, result);
        }

        secondArray.remove(secondArrayMaxIndex);
        return findLastLCS(firstArray, secondArray, result);
    }
}
