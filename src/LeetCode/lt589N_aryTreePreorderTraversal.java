package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class lt589N_aryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> answer = new ArrayList<>();
        check(answer,root);
        return answer;
    }

    public static Node check(List<Integer> answer, Node root){
        if(root == null){
            return null;
        }
        answer.add(root.val);
        if(root.children != null){
            for(int i = 0 ; i < root.children.size();i++){
                check(answer, root.children.get(i));
            }
        }
        return null;
    }
}
