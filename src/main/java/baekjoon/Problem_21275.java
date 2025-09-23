package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Problem_21275 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] XA = st.nextToken().chars().map(e -> convertCharToInt(e)).toArray();
        int[] XB = st.nextToken().chars().map(e -> convertCharToInt(e)).toArray();

        Map<Integer, Long> AMap = toDecimalMap(XA);
        Map<Integer, Long> BMap = toDecimalMap(XB);

        int count = 0;
        int aBase = 0;
        int bBase = 0;
        for (Entry<Integer, Long> a : AMap.entrySet()) {
            for (Entry<Integer, Long> b : BMap.entrySet()) {
                if (a.getValue().equals(b.getValue()) && !a.getKey().equals(b.getKey())) {
                    count++;
                    aBase = a.getKey();
                    bBase = b.getKey();
                }

                if (count >= 2) {
                    break;
                }
            }
        }

        if (count == 0) {
            System.out.print("Impossible");
            return;
        }

        if (count == 1) {
            System.out.printf("%d %d %d", AMap.get(aBase), aBase, bBase);
            return;
        }

        System.out.print("Multiple");
    }

    private static int convertCharToInt(int e) {
        if (e >= '0' && e <= '9') {
            return e - '0';
        }
        return e - 'a' + 10;
    }

    private static Map<Integer, Long> toDecimalMap(int[] arr) {
        Map<Integer, Long> map = new HashMap<>();
        for (int base = Math.max(getMaxValue(arr), 1) + 1; base <= 36; base++) {
            long decimal = convertToDecimal(arr, base);
            if (decimal < 0) {
                break;
            }
            map.put(base, decimal);
        }
        return map;
    }

    private static long convertToDecimal(int[] arr, int base) {
        long result = 0;
        long multiple = 1;
        for (int index = arr.length - 1; index >= 0; index--) {
            result += arr[index] * multiple;
            multiple *= base;
        }
        return result;
    }

    private static int getMaxValue(int[] arr) {
        int result = 0;
        for (int c : arr) {
            result = Math.max(result, c);
        }
        return result;
    }
}
