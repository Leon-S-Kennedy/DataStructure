package binary_tree.about_traversal.demo;


import binary_tree.about_traversal.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TestTree1 {
    public static TreeNode buildTree() {
        // 定义结点
        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');
        TreeNode f = new TreeNode('F');
        TreeNode g = new TreeNode('G');
        TreeNode h = new TreeNode('H');
        TreeNode i = new TreeNode('I');
        TreeNode j = new TreeNode('J');
        TreeNode k = new TreeNode('K');
        TreeNode l = new TreeNode('L');
        TreeNode m = new TreeNode('M');
        TreeNode n = new TreeNode('N');
        TreeNode o = new TreeNode('O');
        TreeNode p = new TreeNode('P');
        TreeNode q = new TreeNode('Q');

        // 定义结点之间的关系
        a.left = o;
        a.right = b;
        b.right = c;
        c.left = d;
        c.right = e;
        d.left = f;
        d.right = g;
        e.right = h;
        g.left = i;
        g.right = j;
        l.right = k;
        m.left = l;
        o.left = p;
        o.right = q;
        q.left = m;
        q.right = n;

        // 返回根结点
        return a;
    }
    public static void pre_traversal(TreeNode root){
        if(root!=null){
            System.out.printf("%c ",root.val);
            pre_traversal(root.left);
            pre_traversal(root.right);
        }
    }
    public static void in_traversal(TreeNode root){
        if(root!=null){
            in_traversal(root.left);
            System.out.printf("%c ",root.val);
            in_traversal(root.right);
        }
    }
    public static void post_traversal(TreeNode root){
        if(root!=null){
            post_traversal(root.left);
            post_traversal(root.right);
            System.out.printf("%c ",root.val);
        }
    }

    public static int node_count(TreeNode root){
        if(root==null){
            return 0;
        }
        return node_count(root.left)+ node_count(root.right)+1;
    }

    public static int liftnode_count(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return liftnode_count(root.left)+ liftnode_count(root.right);
    }

    //求解第K层的节点个数
    public static int node_k(TreeNode root,int k){
        if(root==null){
            return 0;
        }else if(k==1){
            return 1;
        }
        return node_k(root.left,k-1)+node_k(root.right,k-1);
    }
    //求解树的高度
    public static int tree_height(TreeNode root){
        if (root==null){
            return 0;
        }
        return max(tree_height(root.left),tree_height(root.right))+1;
    }

    private static int max(int l_tree_heigh, int r_tree_height) {
        return Math.max(l_tree_heigh, r_tree_height);
    }
    //查找树中的元素
    public static TreeNode search(TreeNode root,char search_c){
        if(root==null){
            return null;
        }else if(root.val==search_c){
            return root;
        }
        TreeNode left=search(root.left, search_c);
        return left==null? search(root.right, search_c):left;
    }
    //层序遍历
    public static void levelOrder(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node =queue.poll();
            System.out.printf("%c ",node.val);
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        System.out.println();
    }
    //层序遍历求节点个数
    public static int level_node_count(TreeNode root){
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int c=0;
        while (!queue.isEmpty()){
            TreeNode node =queue.poll();
            c++;
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return c;
    }
    //层序遍历求叶子节点个数
    public static int level_lift_node_count(TreeNode root){
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int c=0;
        while (!queue.isEmpty()){
            TreeNode node =queue.poll();
            if(node.left==null&&node.right==null){
                c++;
            }
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return c;
    }
    //判定是否完全二叉树
    public boolean isCompleteTree(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return false;
        }
        queue.offer(root);
        while (true){
            TreeNode node = queue.poll();
            if(node==null){
                break;
            }
            queue.offer(node.left);
            queue.offer(node.right);
        }
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node==null){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode treeNode = buildTree();
        System.out.println("前序遍历");
        pre_traversal(treeNode);
        System.out.println("\n中序遍历");
        in_traversal(treeNode);
        System.out.println("\n后序遍历");
        post_traversal(treeNode);
        System.out.println();

        System.out.println("节点个数："+node_count(treeNode));
        System.out.println("叶子节点个数"+ liftnode_count(treeNode));
        System.out.printf("第%d层的节点个数：%d\n",5,node_k(treeNode,5));
        System.out.println("树的层数为"+tree_height(treeNode)+"层");
        System.out.printf("%c\n",search(treeNode,'K').val);
        System.out.println("层序遍历");
        levelOrder(treeNode);
        System.out.println("层序法求节点个数"+level_node_count(treeNode));
        System.out.println("层序法求叶子节点个数"+level_lift_node_count(treeNode));
        pre_traversal(null);

    }

}