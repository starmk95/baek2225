import java.util.*;

public class Main {
    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[][] cases = new long[n+1][k+1]; // 0~n까지의 정수 k개를 더해서 그 합을 n으로 만드는 경우의 수
        long mod = 1000000000;
        // Bottom-Up 방식
        // 점화식 : cases[n][k] = cases[0][k-1] + cases[1][k-1] + ... + cases[n][k-1]
        cases[0][0] = 1;
        for (int i=1;i<=k;i++) {
            for (int j=0;j<=n;j++) {
                for (int l=0;l<=j;l++) {
                    cases[j][i] += cases[j-l][i-1];
                    cases[j][i] %= mod;
                }
            }
        }
        System.out.println(cases[n][k]);
    }
}
