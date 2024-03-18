import java.io.*;
import java.util.*;

public class Main {
    static long N;
    public static long count(long mid){
        long count = 0;
        for(int i=1;i<=(int)N;i++){
            if(mid/i>N){
                count+=N;
            }
            else{
                count+=(mid/i);
            }
        }
        return count;
    }
    public static long find(long lo,long hi,int K){
        while (lo<hi){
            long mid = (lo+hi)/2;
            long C = count(mid);
            if(C>=K){
                hi = mid;
        }
            else if (C<K){
                lo = mid+1;
        }
        }
        return lo;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        int K = Integer.parseInt(br.readLine());
        long lo = 1L;
        long hi = N*N;
        System.out.println(find(lo,hi,K));
    }
}