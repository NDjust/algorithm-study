package Mathematics;

import java.util.Scanner;

public class baekjoon1929 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        if(n <= 1) return;

        boolean[] arr = new boolean[n+1];    //true 이면 해당 인덱스 소수.
        arr[0] = arr[1] = false;
        for(int i=2; i<=n; i+=1) {
            arr[i] = true;
        }

        //2 부터 숫자를 키워가며 배수들을 제외(false 할당)
        for(int i=2; i*i<=n; i+=1) {
            for(int j=i*i; j<=n; j+=i) {
                arr[j] = false;        //2를 제외한 2의 배수 false
            }
        }
        for (int i = m; i <= n; i++) {
            if (arr[i]) {
                System.out.println(i);
            }
        }
    }
}
