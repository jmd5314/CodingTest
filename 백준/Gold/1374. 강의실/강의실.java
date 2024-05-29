import java.util.*;
import java.io.*;
class Main {
    public static class Lecture{
        int n;
        int s;
        int e;
        public Lecture(int n,int s,int e){
            this.n = n;
            this.s = s;
            this.e = e;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Lecture [] lec = new Lecture[N];
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lec[i] = new Lecture(n, s, e);
        }
        // 시작 시간 오름차순 정렬
        Arrays.sort(lec,(o1,o2)->{
            if(o1.s==o2.s){
                return o1.e - o2.e;
            }
            return o1.s - o2.s;
       });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lec[0].e);
        for(int i =1;i<N;i++){
            // 만약 가장 종료시간이 짧은 강의 보다 시작시간이 크거나 같으면 그 강의를 빼고 종료시간을 최신화 시켜줌
            if(pq.peek()<=lec[i].s)
                pq.poll();
            // 강의 추가
            pq.add(lec[i].e);
        }
        System.out.println(pq.size());
    }
}