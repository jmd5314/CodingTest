import java.util.*;
import java.io.*;
public class Main {
    public static class Lecture{
        int s;
        int t;
        public Lecture(int s,int t){
            this.s = s;
            this.t = t;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Lecture[] lectures = new Lecture[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(s, t);
        }
        /* 시작 시간을 기준으로 오름차순 정렬
         * 그래야 최대한 빈칸을 줄이고 최솟값을 구할 수 있음
         * 시작 시간이 같다면 종료시간을 기준으로 오름차순 정렬
         */
        Arrays.sort(lectures, ((o1, o2) -> {
            if (o1.s == o2.s)
                return o1.t - o2.t;
            return o1.s - o2.s;
        }));
        // 우선순위 큐에 종료시간만 들어감 오름차순 자동 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 첫번째 강의 종료시간 add
        pq.add(lectures[0].t);
        for(int i =1;i<N;i++){
            /* 종료시간이 가장 빠른 강의와 현재 강의 시작시간 비교
             * 종료시간이 가장 빠른 강의<= 현재 강의 시작시간 이면 top 의 값을 제거하고 추가
             * 없다면 새 강의실을 배정해야되는 것임 ( 가장 빠른 강의 보다 낮으면 충족하는 강의실이 없기 때문!)
             */
            if(pq.peek()<=lectures[i].s){
                pq.poll();
            }
            pq.add(lectures[i].t);
        }
        System.out.println(pq.size());
    }
}