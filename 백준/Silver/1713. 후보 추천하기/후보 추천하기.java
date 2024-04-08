import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        class Student implements Comparable<Student>{
            int index;
            int count;
            int time;
            public Student(int index,int count,int time){
                this.index = index;
                this.count = count;
                this.time = time;
            }
            @Override
            public int compareTo(Student o){
                // 만약 추천 수가 같다면 시간 순으로 정렬
                if(this.count==o.count){
                    return this.time - o.time;
                }
                return this.count-o.count;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] students = new int[101];
        List<Student> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<M;i++){
            int index = Integer.parseInt(st.nextToken());
            // 학생이 있으면
            if(students[index]>0){
                students[index]++;
            for(int j =0;j<list.size();j++){
                if(list.get(j).index==index){
                    // 해당 학생 추천수 증가
                    list.get(j).count++;
                }
            }
            }
            // 없으면
            else{
                // 꽉 찼을 경우
                if(list.size()==N){
                    //조건 대로 정렬
                    Collections.sort(list);
                    // 제거 1순위 후보 인덱스 값
                    int remove = list.get(0).index;
                    // 후보 카운트 값 초기화
                    students[remove] = 0;
                    // 리스트에서 제거
                    list.remove(0);
                }
                list.add(new Student(index,1,i));
                students[index]++;
            }
        }
        for(int i =1;i<=100;i++){
            if(students[i]!=0)
                sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}