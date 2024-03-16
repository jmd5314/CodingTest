import java.util.*;
import java.io.*;

public class Main {

    public static int[] square;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int N;
        while(true) {

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());

            if(N == 0) {
                break;
            }
            square = new int[N];

            for(int i = 0; i < N; i++) {
                square[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(getArea(0, N - 1)).append('\n');
            square = null;
        }
        System.out.println(sb);
    }

    public static long getArea(int lo, int hi) {

        // 막대 폭이 1일경우
        if(lo == hi) {
            return square[lo];
        }

        int mid = (lo + hi) / 2;

        /*
         *  mid 를 기점으로 양쪽으로 나누어 양쪽 구간 중 큰 넓이를 저장
         *  왼쪽 부분 : lo ~ mid
         *  오른쪽 부분 : mid + 1 ~ hi
         */
        long leftArea = getArea(lo, mid);
        long rightArea = getArea(mid + 1, hi);

        long max = Math.max(leftArea, rightArea);

        // 양쪽 구간 중 큰 값과 중간 구간을 비교하여 더 큰 넓이로 갱신
        max = Math.max(max, getMidArea(lo, hi, mid));

        return max;

    }

    // 중간지점 영역의 넓이를 구하는 메소드
    public static long getMidArea(int lo, int hi, int mid) {

        int toLeft = mid;	// 중간 지점으로부터 왼쪽으로 갈 변수
        int toRight = mid;	// 중간 지점으로부터 오른쪽으로 갈 변수

        long height = square[mid];

        // 초기 넓이는 height * 1
        long maxArea = height;


        // 양 끝 범위를 벗어나기 전까지 반복
        while(lo < toLeft && toRight < hi) {

            //양쪽 중 높은 값을 선택하되, 높이를 현재 높이보다 같거나 낮은 값을 선택해야됨
            if(square[toLeft - 1] < square[toRight + 1]) {
                toRight++;
                height = Math.min(height, square[toRight]);
            }
            else {
                toLeft--;
                height = Math.min(height, square[toLeft]);
            }

            // 최대 넓이 갱신
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }


        // 오른쪽 구간을 끝까지 탐색 못했다면 마저 탐색함
        while(toRight < hi) {
            toRight++;
            height = Math.min(height, square[toRight]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        // 왼쪽 구간을 끝까지 탐색 못했다면 마저 탐색함
        while(lo < toLeft) {
            toLeft--;
            height = Math.min(height, square[toLeft]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        return maxArea;
    }

}