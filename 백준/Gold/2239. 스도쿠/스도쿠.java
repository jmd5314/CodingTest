import java.util.*;
import java.io.*;
public class Main {
    static int [][] puzzle;
    public static void sudoku(int row, int col){
        // 행을 다 채웠으면 다음 열의 첫번째 행부터 시작
        if(col==9){
            sudoku(row + 1, 0);
            return;
        }
        // 스도쿠 완성 시
        if(row==9){
            for(int i =0;i<9;i++){
                for(int j =0;j<9;j++){
                    System.out.print(puzzle[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }
        // 값이 채워져 있지 않다면
        if(puzzle[row][col]==0){
            for(int i =1;i<=9;i++){
                /* 검사 값이 검사를 다 통과한다면
                 * 값을 채워주고 다음 행으로 넘어감
                 */
                if (isPossible(row, col, i)) {
                    puzzle[row][col] = i;
                    sudoku(row, col + 1);
                }
            }
            //만약 다 검사했는데, 넣을 수 있는 값이 없을때는 다시 0으로 초기화 시키고 재귀에서 빠져나와야 함
            puzzle[row][col] = 0;
            return;
        }
        // 값이 있는 경우는 그냥 다음 스도쿠로 넘어가면 됨
        sudoku(row, col + 1);
    }
    public static boolean isPossible(int row,int col,int value){
        // 가로 검사
        for(int i =0;i<9;i++){
            if(puzzle[row][i]==value)
                return false;
        }
        // 세로 검사
        for(int i =0;i<9;i++){
            if(puzzle[i][col]==value)
                return false;
        }
        // 작은 네모 검사
        int s_row = (row / 3) * 3;
        int s_col = (col / 3) * 3;
        for(int i =s_row;i<s_row+3;i++){
            for(int j =s_col;j<s_col+3;j++){
                if(puzzle[i][j]==value)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        puzzle = new int[9][9];
        for(int i =0;i<9;i++){
            String num = br.readLine();
            for(int j = 0;j<9;j++){
                puzzle[i][j] = num.charAt(j) - '0';
            }
        }
        sudoku(0,0);
    }
}