package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_1041 implements ProblemInterface {

    private static final int DICE_FACE = 6;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] faces = new long[DICE_FACE - 2];
        long topFace = Long.parseLong(st.nextToken());
        for (int i = 0; i < faces.length; i++) {
            faces[i] = Long.parseLong(st.nextToken());
        }
        long bottomFace = Long.parseLong(st.nextToken());

        long temp = faces[2];
        faces[2] = faces[3];
        faces[3] = temp;

        if (N == 1) {
            long sum = topFace + bottomFace + Arrays.stream(faces).sum();
            long maxFace = Math.max(Math.max(topFace, bottomFace), Arrays.stream(faces).max().getAsLong());

            System.out.print(sum - maxFace);
            return;
        }

        long minOneFace = Math.min(topFace, bottomFace);
        long minTwoFace = Long.MAX_VALUE;
        long minThreeFace = Long.MAX_VALUE;

        for (int i = 0; i < faces.length; i++) {
            minOneFace = Math.min(faces[i], minOneFace);

            long nextFace = faces[(i + 1) % faces.length];
            minTwoFace = Math.min(minTwoFace, topFace + faces[i]);
            minTwoFace = Math.min(minTwoFace, bottomFace + faces[i]);
            minTwoFace = Math.min(minTwoFace, faces[i] + nextFace);

            minThreeFace = Math.min(minThreeFace, faces[i] + topFace + nextFace);
            minThreeFace = Math.min(minThreeFace, faces[i] + bottomFace + nextFace);
        }

        long threeFaceCount = 4;
        long twoFaceCount = 4 + (N - 2) * 8;
        long oneFaceCount = (N - 2) * (N - 2) * 5 + (N - 2) * 4;

        System.out.print(minOneFace * oneFaceCount + minTwoFace * twoFaceCount + minThreeFace * threeFaceCount);
    }

}
