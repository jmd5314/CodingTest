import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static int start, mid, end;
    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < N - 2; i++) {
            start = i;
            mid = i + 1;
            end = N - 1;
            while (mid < end) {
                int sum = arr[start] + arr[mid] + arr[end];
                if (sum == 0) {
                    // 만약 둘이 같은 수인 경우 사이의 값들은 전부 같은 값들이므로 사이의 갯수 중 2개를 선택하는 조합을 더해준다
                    if (arr[mid] == arr[end]) {
                        int n = end - mid + 1;
                        result += n * (n - 1) / 2;
                        break;
                    }
                    int l = 1;
                    int r = 1;
                    while (mid + 1 < end && arr[mid] == arr[mid + 1]) {
                        mid++;
                        l++;
                    }
                    while (end - 1 > mid && arr[end] == arr[end - 1]) {
                        end--;
                        r++;
                    }
                    mid++;
                    end--;
                    result += r * l;
                }
                if (sum < 0) {
                    mid++;
                }
                if (sum > 0) {
                    end--;
                }
            }
        }
        System.out.println(result);
    }
}