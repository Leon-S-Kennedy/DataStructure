package binary_tree.about_traversal.demo1;

import binary_tree.about_traversal.TreeNode;
import binary_tree.about_traversal.demo.TestTree1;

import java.util.Deque;
import java.util.LinkedList;


public class Demo {
    public static void pre_traversal(TreeNode root){
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode cur=root;
        while(cur!=null||!stack.isEmpty()){
            while (cur!=null){
                System.out.print(cur+" ");  //此处为第一经过节点
                stack.push(cur);
                cur=cur.left;
            }

            TreeNode node=stack.pop();
            cur=node.right;
        }
        System.out.println();
    }
    public static void in_traversal(TreeNode root){
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode cur=root;
        while(cur!=null||!stack.isEmpty()){
            while (cur!=null){
                //System.out.print(cur+" ");
                stack.push(cur);
                cur=cur.left;
            }

            TreeNode node=stack.pop();  //此处的node为第二次经过节点
            System.out.print(node+" ");
            cur=node.right;
        }
        System.out.println();
    }

    public static void post_traversal(TreeNode root){
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode cur=root;
        TreeNode last=null;
        while(cur!=null||!stack.isEmpty()){
            while (cur!=null){
                //System.out.print(cur+" ");
                stack.push(cur);
                cur=cur.left;
            }

            TreeNode node=stack.peek();
            if(node.right==null){
                //此时为第二次经过该节点，但是，由于其右边是null，可当作第三次经过。
                System.out.print(node+" ");
                last=node;
                stack.pop();

            }else if(node.right==last){
                //此时为第三次经过该节点node的值表示经过。
                System.out.print(node+" ");
                last=node;
                stack.pop();
            }
            else{
                //右边既不是null又不是上次的节点，说明此时为第二次经过。此时只需要更新cur为当前节点的右节点（画个图就知道了）。
                cur=node.right;
            }
        }
        System.out.println();
        //该方法使用了三个指针，cur,node,last来进行遍历。三个指针都是跳跃性的遍历。较为复杂。cur第一次经过节点，node出栈第二次经过节点，
        //用last记录上一个节点，如果上一个节点来自node的右子树，说明是第三次经过，此时就是输出的时候。
    }


    public static void main(String[] args) {
        TreeNode buildTree= TestTree1.buildTree();
        pre_traversal(buildTree);
        in_traversal(buildTree);
        post_traversal(buildTree);
    }
}
