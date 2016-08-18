package binaryTree.commonparent;

import binaryTree.BinaryTree;

/**
 * Created by meng_jian on 2016/7/25.
 */
//二叉搜索树寻找公共父节点
public class BinarySortTree {
    public BinaryTree getCommonParent(BinaryTree root,BinaryTree t1,BinaryTree t2){
        if(root == null){
            return null;
        }
        if(root == t1){
            return t1;
        } else if(root == t2){
            return t2;
        } else if(root.val > t1.val && root.val < t2.val){
            return root;
        }
        BinaryTree res ;
        if(root.val > t1.val && root.val > t2.val){
            res = getCommonParent(root.left,t1,t2);
        } else {
            res = getCommonParent(root.right,t1,t2);
        }
        return res;
    }
    public static void main(String[] args){
        BinarySortTree bs = new BinarySortTree();
        BinaryTree root = new BinaryTree(17);
        BinaryTree l = new BinaryTree(15);
        BinaryTree r = new BinaryTree(20);
        BinaryTree ll = new BinaryTree(10);
        BinaryTree lr = new BinaryTree(16);
        BinaryTree lll = new BinaryTree(6);
        BinaryTree llr = new BinaryTree(13);
        BinaryTree llll = new BinaryTree(5);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        ll.left = lll;
        ll.right = llr;
        lll.left = llll;
        BinaryTree  res = bs.getCommonParent(root,ll,r);
        System.out.println(res.val);
    }
}
