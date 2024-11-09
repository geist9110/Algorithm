package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_9506 implements ProblemInterface {

    /*
    https://www.acmicpc.net/problem/9506

    약수들의 합 다국어
    브론즈 1

    문제
    어떤 숫자 n이 자신을 제외한 모든 약수들의 합과 같으면, 그 수를 완전수라고 한다.

    예를 들어 6은 6 = 1 + 2 + 3 으로 완전수이다.

    n이 완전수인지 아닌지 판단해주는 프로그램을 작성하라.

    입력
    입력은 테스트 케이스마다 한 줄 간격으로 n이 주어진다. (2 < n < 100,000)

    입력의 마지막엔 -1이 주어진다.

    출력
    테스트케이스 마다 한줄에 하나씩 출력해야 한다.

    n이 완전수라면, n을 n이 아닌 약수들의 합으로 나타내어 출력한다(예제 출력 참고).

    이때, 약수들은 오름차순으로 나열해야 한다.

    n이 완전수가 아니라면 n is NOT perfect. 를 출력한다.
     */

    private static Queue<Integer> queue = new LinkedList<>();
    private static int sum;
    private static StringBuilder sb = new StringBuilder();

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (
            int n = Integer.parseInt(br.readLine());
            n != -1;
            n = Integer.parseInt(br.readLine())
        ) {
            initProcess();
            calcMeasure(n);

            if (isPerfectNumber(sum, n)) {
                writePerfectNumber(n);
                continue;
            }

            writeNotPerfectNumber(n);
        }
        System.out.print(sb.toString().trim());
    }

    private static void writeNotPerfectNumber(int n) {
        sb.append(n).append(" is NOT perfect.\n");
    }

    private static void writePerfectNumber(int n) {
        sb.append(n).append(" = ");
        while (!queue.isEmpty()) {
            sb.append(queue.poll()).append(!queue.isEmpty() ? " + " : "\n");
        }
    }

    private static void initProcess() {
        queue.clear();
        sum = 0;
    }

    private static void calcMeasure(int n) {
        for (int i = 1; i < n; i++) {
            if (isMeasure(n, i)) {
                addQueueAndSum(i);
            }
        }
    }

    private static void addQueueAndSum(int i) {
        queue.add(i);
        sum += i;
    }

    private static boolean isMeasure(int n, int i) {
        return n % i == 0;
    }

    private static boolean isPerfectNumber(int sum, int n) {
        return sum == n;
    }
}
