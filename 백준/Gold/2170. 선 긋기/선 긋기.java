import java.util.*;
import java.io.*;
public class Main {
    public static class Line{
        int s;
        int e;
        public Line(int s,int e){
            this.s = s;
            this.e = e;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Line[] lines = new Line[N];
        StringTokenizer st;
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lines[i] = new Line(s, e);
        }
        // 시작 점 순으로 오름차순 정렬 같은 경우 끝점 기준 오름차순 정렬
        Arrays.sort(lines,(o1,o2)->{
            if(o1.s == o2.s)
                return Integer.compare(o1.e,o2.e);
            return Integer.compare(o1.s, o2.s);
        });
        // 끝점 기분 내림차순
        PriorityQueue<Line> pq = new PriorityQueue<>(((o1, o2) -> {
            return o2.e - o1.e;
        }));
        //첫번째 선 추가
        pq.add(lines[0]);
        for(int i =1;i<N;i++){
            // 가장 마지막선의 끝점보다 시작점이 높으면 새로운 선을 추가함
            if(lines[i].s>pq.peek().e){
                pq.add(lines[i]);
            }
            /* 시작 시간 순으로 정렬했기 때문에 가장 마지막의 선과 겹침
             * 가장 마지막 선을 뺀 뒤 시작 점과 끝점을 다시 초기화 하여 추가
             */
            else{
                Line peek = pq.poll();
                pq.add(new Line(Math.min(lines[i].s, peek.s), Math.max(lines[i].e, peek.e)));
            }
        }
        int sum = 0;
        for(Line line:pq){
            sum+=line.e- line.s;
        }
        System.out.println(sum);
    }
}