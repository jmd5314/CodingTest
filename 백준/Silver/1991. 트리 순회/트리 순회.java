import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        class Node{
            char name;
            Node left;
            Node right;
            Node(char name){
                this.name = name;
            }
        }
        class Tree{
            public Node root;
            public void createNode(char name,char left, char right){
                if(root==null){
                    root = new Node(name);
                    if(left!='.')
                        root.left = new Node(left);
                    else
                        root.left = null;
                    if(right!='.')
                        root.right = new Node(right);
                    else
                        root.right = null;
                }
                else{
                    // 루트 부터 해당 노드 검색
                    searchNode(root, name, left, right);
                }
            }
            public void searchNode(Node node, char name,char left,char right){
                // 끝에 도달 하면 그냥 return
                if(node==null){
                    return;
                }
                // 해당 노드 찾은 경우
                else if(node.name==name){
                    if(left!='.')
                        node.left = new Node(left);
                    else
                        node.left = null;
                    if(right!='.')
                        node.right = new Node(right);
                    else
                        node.right = null;
                }
                else{
                    // 왼쪽 재귀 탐색
                    searchNode(node.left, name, left, right);
                    // 오른쪽 재귀 탐색
                    searchNode(node.right, name, left, right);
                }
            }
            // 전위 순회 루트->왼쪽->오른쪽
            public void preOrder(Node node){
                if(node!=null) {
                    System.out.print(node.name);
                    if(node.left!=null)
                        preOrder(node.left);
                    if(node.right!=null)
                        preOrder(node.right);
                }
            }
            // 중위 순회 왼쪽->루트->오른쪽
            public void inOrder(Node node){
                if(node!=null){
                    if(node.left!=null){
                        inOrder(node.left);}
                    System.out.print(node.name);
                    if(node.right!=null){
                        inOrder(node.right);
                    }
                }
            }
            //후위 순회 왼쪽->오른쪽->루트
            public void postOrder(Node node) {
                if(node!=null){
                    if(node.left!=null){
                        postOrder(node.left);
                    }
                    if(node.right!=null){
                        postOrder(node.right);
                    }
                    System.out.print(node.name);
                }
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Tree tree = new Tree();
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            char name = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.createNode(name, left, right);
        }
        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }
}