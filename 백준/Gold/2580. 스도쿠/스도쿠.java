import java.io.*;
import java.util.*;
public class Main{
    public static StringBuilder sb = new StringBuilder();
    public static int arr[][] = new int [9][9];
    public static void sudoku(int row,int col){
        //해당 행이 다 채워졌을 경우 다음 행의 첫번째부터 시작
        if(col==9){
            sudoku(row+1,0);
            return;
        }
        // 행과 열이 다 채워졌을경우
        if(row ==9){
            for(int i =0;i<9;i++){
                for(int j=0;j<9;j++){
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0); // 끝까지 탐색 한뒤 return 을 하면 0,0으로 다시 되돌아가는데, 더이상의 검사는 필요 없기때문에 출력한뒤에 시스템을 종료해버린다.
        }
        if(arr[row][col]==0){
            for(int i=1;i<=9;i++){
                //값이 중복되지 않는지 검사
                if(possibility(row,col,i)){
                    arr[row][col] = i;
                    sudoku(row,col+1);
                }
            }
            //만약 다 검사했는데, 넣을 수 있는 값이 없을때는 다시 0으로 초기화 시키고 재귀에서 빠져나와야 한다!
            arr[row][col] = 0;
            return;
        }
        sudoku(row,col+1);

    }
    public static boolean possibility(int row,int col,int value){
        //같은 행 검사
        for(int i=0;i<9;i++){
            if(arr[row][i]==value){
                return false;
            }
        }
        //같은 열 검사
        for(int i=0;i<9;i++){
            if(arr[i][col]==value){
                return false;
            }
        }
        // 3*3 검사의 행의 첫 위치, 열의 첫 위치
        int set_row = (row/3)*3;
        int set_col = (col/3)*3;
        for(int i=set_row;i<set_row+3;i++){
            for(int j=set_col;j<set_col+3;j++){
                if(arr[i][j]==value)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<9;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<9;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sudoku(0,0);
    }
}