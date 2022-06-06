package set_map.set.treeSet;

public class BSTree {
    private TreeNode root=null;

    public boolean contains(int dest){
        TreeNode cur=root;
        while (cur!=null){
            if(cur.key==dest){
                return true;
            }else if(cur.key<dest){
                cur=cur.right;
            }else{
                cur=cur.left;
            }
        }
        return false;
    }


    //给定顺序不同，得到的搜索树的结构也不同
    public boolean add(int dest){
        TreeNode treeNode = new TreeNode(dest);
        TreeNode parent=null;//定义一个节点用于记录双亲结点

        if(root==null){
            root=treeNode;
            return true;
        }

        TreeNode cur=root;
        while(cur!=null){
            if(cur.key==dest){
                return false;
            }else if(dest<cur.key){
                parent=cur;
                cur=cur.left;
            }else {
                parent=cur;
                cur=cur.right;
            }
        }
        //此时到了null的位置，是插入的时候了
        if(dest<parent.key){
            parent.left=treeNode;
        }else {
            parent.right=treeNode;
        }
        return true;
    }
    public boolean remove(int key){
        TreeNode parent=null;
        TreeNode cur=root;
        while(cur!=null){
            if(cur.key==key){
                deleteKey(parent,cur,key);
                return true;
            }else if(key< cur.key){
                parent=cur;
                cur=cur.left;
            }else{
                parent=cur;
                cur=cur.right;
            }
        }
        return false;
    }

    private void deleteKey(TreeNode parent,TreeNode node, int key) {
        if(node.left==null){
            if(node==root){
                root=root.right;
            }else if(node==parent.left){
                parent.left=node.right;
            }else{
                parent.right=node.right;
            }
        }else if(node.right==null){
            if(node==root){
                root=root.left;
            }else if(node==parent.left){
                parent.left=node.left;
            }else {
                parent.left=node.left;
            }
        }else{
            replaceDelete(parent,node);
        }
    }

    private void replaceDelete(TreeNode parent, TreeNode node) {
        TreeNode canparent=node;
        TreeNode candidate =node.left;
        while (candidate.right!=null){
            canparent=candidate;
            candidate=candidate.right;
        }
        //将值进行替换
        node.key= candidate.key;
        //删除候选人的节点
        if(canparent==node){
            canparent.left=candidate.left;
        }else {
            canparent.right=null;
        }
    }

    public static void main(String[] args) {
        int[] keys={9,7,13,21,5,8,16,32,4,0,1,6,2,3};
        BSTree bsTree = new BSTree();
        for (int key : keys) {
            bsTree.add(key);
        }
        System.out.println(true);
        int[] re={2,6,7,13,9};
        for (int i : re) {
            bsTree.remove(i);
        }
        System.out.println(true);
    }

}
