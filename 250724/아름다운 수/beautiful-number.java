import java.io.*;
import java.util.*;


public class Main {
    static int n;
    static int cnt = 0;
    static int[] arr;



    static void func(int num){
        if(num == n){
            cnt++;
        }
        else{
            for(int i = 1;i<=4;i++){
                if(num+i > n){
                     return;
                }
                else{
                    for(int j = 0;j<i;j++){
                        arr[num + j] = i;
                    }
                    func(num + i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        func(0);
        System.out.println(cnt);

        
    }
}