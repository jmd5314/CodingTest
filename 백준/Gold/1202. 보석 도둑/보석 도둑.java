import java.util.*;
import java.io.*;
public class Main {
    public static class Jew{
        int weight;
        int price;
        public Jew(int weight,int price){
            this.weight = weight;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Jew[] jews = new Jew[N];
        Integer[] C = new Integer[K];
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jews[i] = new Jew(weight, price);
        }
        for(int i =0;i<K;i++){
            C[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(jews,((o1, o2) -> {
            return o1.weight - o2.weight;
        }));
        // 가방 무게 오름차순 정렬
        Arrays.sort(C);
        // 가격 내림차순
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        int index = 0;
        for(int i = 0;i<K;i++){
            // 현재 가방 보다 무게가 가벼운 가방들을 우선순위 큐에 넣음
            while (index < N && jews[index].weight <= C[i]) {
                pq.add(jews[index++].price);
            }
            if(!pq.isEmpty()){
                sum += pq.poll();
            }
        }
        System.out.println(sum);
    }
}