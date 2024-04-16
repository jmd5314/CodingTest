import java.util.*;
import java.io.*;
public class Main {
    public static void postOrder(Node node){
        if(node!=null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.idx);
        }
    }
    public static class Node{
        int idx;
        Node left,right;
        Node(int idx){
            this.idx = idx;
        }
        public void insert(int num){
            if(num<idx){
                if(this.left==null){
                    this.left = new Node(num);
                }
                else{
                    this.left.insert(num);
                }
            }
            else{
                if(this.right==null) {
                    this.right = new Node(num);
                }
                else{
                    this.right.insert(num);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        while (true){
            String input = br.readLine();
            if(input==null||input.equals(""))
                break;
            int n = Integer.parseInt(input);
            root.insert(n);
        }
        postOrder(root);
    }
}