package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_1700 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        List<Queue<Integer>> itemIndex = new ArrayList<>();
        for (int i = 0; i <= K; i++) {
            itemIndex.add(new LinkedList<>());
        }
        itemIndex.get(0).add(Integer.MIN_VALUE);

        int[] itemOrder = new int[K];
        for (int i = 0; i < K; i++) {
            itemOrder[i] = Integer.parseInt(st.nextToken());
            itemIndex.get(itemOrder[i]).add(i);
        }

        Set<Integer> concent = new HashSet<>();
        int itemOrderIndex = 0;

        while (itemOrderIndex < K && concent.size() < N) {
            int currentItem = itemOrder[itemOrderIndex++];
            concent.add(currentItem);
            itemIndex.get(currentItem).poll();
        }

        int result = 0;
        while (itemOrderIndex < K) {
            int currentItem = itemOrder[itemOrderIndex++];

            if (concent.contains(currentItem)) {
                itemIndex.get(currentItem).poll();
                continue;
            }

            int maxIndexItem = 0;
            for (int concentItem : concent) {
                if (itemIndex.get(concentItem).isEmpty()) {
                    maxIndexItem = concentItem;
                    break;
                }

                if (itemIndex.get(concentItem).peek() > itemIndex.get(maxIndexItem).peek()) {
                    maxIndexItem = concentItem;
                }
            }

            result++;
            itemIndex.get(currentItem).poll();
            concent.remove(maxIndexItem);
            concent.add(currentItem);
        }

        System.out.print(result);
    }
}