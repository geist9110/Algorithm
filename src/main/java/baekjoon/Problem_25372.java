package baekjoon;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import baekjoon.config.ProblemInterface;

public class Problem_25372 implements ProblemInterface{

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int t=Integer.parseInt(br.readLine());t>0;t--){
            String s = br.readLine();
            if(s.length()>=6 && s.length()<=9){
                sb.append("yes\n");
            }else{
                sb.append("no\n");
            }
        }
        System.out.print(sb);
    }
    
}
