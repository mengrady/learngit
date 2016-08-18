package binaryTree;

/**
 * Created by meng_jian on 2016/7/25.
 */
public class BinaryTree {
    public int val;
    public BinaryTree left;
    public BinaryTree right;
    public BinaryTree(int val){
        this.val = val;
    }
    public String toString(){
        return this.val + "";
    }
}
