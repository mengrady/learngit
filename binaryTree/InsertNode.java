package binaryTree;

/**
 * Created by meng_jian on 2016/7/28.
 */
/*
将给定的node插入到二叉排序树中
 */
public class InsertNode {
    public void insert(BinaryTree root,BinaryTree node){
        if(root == null || node == null){
            return;
        }
        if(node.val < root.val){
            if(root.left != null){
                insert(root.left,node);
            }
            else {
                root.left = node;
                return ;
            }
        } else {
            if(root.right != null){
                insert(root.right,node);
            }
            else {
                root.right = node;
                return;
            }
        }
    }
    public static void main(String[] args) {
        InsertNode insertNode = new InsertNode();
        BinaryTree root = new BinaryTree(17);
        BinaryTree l = new BinaryTree(15);
        BinaryTree r = new BinaryTree(20);
        BinaryTree ll = new BinaryTree(10);
        BinaryTree lr = new BinaryTree(16);
        BinaryTree lll = new BinaryTree(6);
        BinaryTree llr = new BinaryTree(13);
        BinaryTree llll = new BinaryTree(18);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        ll.left = lll;
        ll.right = llr;
        insertNode.insert(root,llll);
        System.out.println(r.left.val);
    }
}
