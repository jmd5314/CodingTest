import java.util.*;
import java.io.*;
public class Main {
    static int[] inorder;
    static int[] postorder;
    static int[] inorderIndex;
    static StringBuilder sb = new StringBuilder();
    public static void preorder(int i_start,int i_end,int p_start,int p_end){
        if(i_start>i_end||p_start>p_end){
            return;
        }
        int root = postorder[p_end];
        sb.append(root + " ");
        int rootIndex = inorderIndex[root];
        // root 노드의 인덱스를 기점으로 왼쪽은 다 leftNode
        int leftLength = rootIndex-i_start;
        // 왼쪽 탐색  root-> left -> right 이기 때문에
        preorder(i_start, rootIndex - 1, p_start, p_start + leftLength - 1);
        // postorder 마지막이 rootNode
        preorder(rootIndex + 1, i_end, p_start + leftLength, p_end - 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        inorder = new int[n];
        postorder = new int[n];
        inorderIndex = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<n;i++){
            inorder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<n;i++){
            postorder[i] = Integer.parseInt(st.nextToken());
        }
        for(int i =0;i<n;i++){
            inorderIndex[inorder[i]] = i;
        }
        preorder(0, n - 1, 0, n - 1);
        System.out.println(sb);
    }
}