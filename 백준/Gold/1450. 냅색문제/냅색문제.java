import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int C;
    static int [] arr;
    static List<Integer> left;
    static List<Integer> right;

    public static void bruteForce(List<Integer> list, int start, int end, int sum) {
        // 합이 가방 허용 무게보다 높으면 return
        if (sum > C) return;
        // 완전 탐색이므로 끝까지 간 경우 sum 이 C 이하이면 리스트에 추가
        if(start==end){
            list.add(sum);
            return;
        }
        // 현재 값을 선택해서 다음 수로 넘어가거나 선택하지 않고 넘어가는 두가지 재귀
        bruteForce(list,start+1,end,sum);
        bruteForce(list, start + 1, end, sum + arr[start]);
    }
    public static int binarySearch(int start,int end,int val){
        while (start<=end){
            int mid = (start+end)/2;
            if(right.get(mid)<=C-val){
                start = mid + 1;
            }
            else {
                end = mid-1;
            }
        }
        return end;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        left = new ArrayList<>();
        right = new ArrayList<>();
        // N/2까지 탐색함
        bruteForce(left, 0, N / 2, 0);
        // N까지 탐색함 배열 마지막 인덱스는 N-1
        bruteForce(right, N / 2, N, 0);
        Collections.sort(right);
        int count = 0;
        int index = 0;
        for (int i = 0;i<left.size();i++){
            index = binarySearch(0, right.size() - 1, left.get(i));
            count += index + 1;
        }
        System.out.println(count);
    }
}