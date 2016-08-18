package binaryTree.commonparent;

import binaryTree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meng_jian on 2016/7/25.
 */
public class GeneralTree {
    public BinaryTree getCommonParent(BinaryTree node,BinaryTree t1,BinaryTree t2){
        List<BinaryTree> list1 = new ArrayList<BinaryTree>();
        List<BinaryTree> list2 = new ArrayList<BinaryTree>();
//        List<BinaryTree> res1 = new ArrayList<BinaryTree>();
//        List<BinaryTree> res2 = new ArrayList<BinaryTree>();
        findPath(node, t1, list1);
        findPath(node, t2, list2);
        int i = 0;
        while(i < list1.size() && i < list2.size() && list1.get(i) == list2.get(i)){
            i++;
        }
        return list1.get(--i);
    }
    //方法一：
//    public void findPath(BinaryTree node,BinaryTree t,List list,List res){
//        list.add(node);
//        if(node == t){
//            res.addAll(list);
//            return;
//        }
//        if(node.left != null){
//            findPath(node.left,t,list,res);
//        }
//        if (node.right != null){
//            findPath(node.right,t,list,res);
//        }
//        list.remove(list.size() - 1);
//    }
  //方法二
    public boolean findPath(BinaryTree node,BinaryTree t,List list){
        boolean res = false;
        list.add(node);
        if(node == t){
            res = true;
            return res;
        }
        if(!res && node.left != null){
            res = findPath(node.left,t,list);
        }
        if (!res && node.right != null){
            res = findPath(node.right,t,list);
        }
        if(!res){
            list.remove(list.size() - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        GeneralTree gt = new GeneralTree();
//        BinaryTree root = new BinaryTree(17);
//        BinaryTree l = new BinaryTree(15);
//        BinaryTree r = new BinaryTree(20);
//        BinaryTree ll = new BinaryTree(10);
//        BinaryTree lr = new BinaryTree(16);
//        BinaryTree lll = new BinaryTree(6);
//        BinaryTree llr = new BinaryTree(13);
//        BinaryTree llll = new BinaryTree(5);
//        root.left = l;
//        root.right = r;
//        l.left = ll;
//        l.right = lr;
//        ll.left = lll;
//        ll.right = llr;
//        lll.left = llll;
        BinaryTree root = new BinaryTree(10);
        BinaryTree l = new BinaryTree(6);
        BinaryTree r = new BinaryTree(19);
        BinaryTree ll = new BinaryTree(3);
        BinaryTree lr = new BinaryTree(8);
        BinaryTree lrl = new BinaryTree(7);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        lr.left = lrl;
        BinaryTree b = gt.getCommonParent(root,ll,lrl);
        System.out.println(b.val);
    }
}
