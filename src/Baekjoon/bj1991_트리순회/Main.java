package Baekjoon.bj1991_트리순회;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static StringBuilder sb;
    public static class Node{
        String value;
        Node left;
        Node right;
        boolean checked;

        Node(String s) {
            this.value = s;
            this.left=null;
            this.right=null;
            this.checked=false;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right){
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());

        HashMap<String, Node> map = new HashMap<String, Node>();

        Node temp ,templ, tempr;
        String c, l, r;
        for(int i = 0; i < count; i++){
            st = new StringTokenizer(br.readLine());
            c = st.nextToken();
            temp = map.get(c);
            if(temp == null){
                temp = new Node(c);
                map.put(c,temp);
            }

            l = st.nextToken();
            if(!l.equals(".")){
                templ = map.get(l);
                if(templ == null){
                    templ = new Node(l);
                    map.put(l,templ);
                }
                temp.setLeft(templ);
            }

            r = st.nextToken();
            if(!r.equals(".")){
                tempr = map.get(r);
                if(tempr == null){
                    tempr = new Node(r);
                    map.put(r,tempr);
                }
                temp.setRight(tempr);
            }
        }

        sb = new StringBuilder();
        pre(map.get("A"));
        String pre = sb.toString();

        sb = new StringBuilder();
        in(map.get("A"));
        String in = sb.toString();

        sb = new StringBuilder();
        post(map.get("A"));
        String post = sb.toString();

        bw.write(pre+"\n"+in+"\n"+post+"\n");
        bw.flush();
        bw.close();
    }

    public static void pre(Node node){
        if(node == null) return;
        sb.append(node.value);
        pre(node.left);
        pre(node.right);
    }

    public static void in(Node root){
        if(root == null) return;
        in(root.left);
        sb.append(root.value);
        in(root.right);
    }

    public static void post(Node root){
        if(root == null) return;
        post(root.left);
        post(root.right);
        sb.append(root.value);
    }
}
