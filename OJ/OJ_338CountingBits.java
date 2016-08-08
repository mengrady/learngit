package OJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by meng_jian on 2016/8/8.
 */
/*
题意：给定一个非负整数num。对于每一个满足0 ≤ i ≤ num的数字i，计算其数字的二进制表示中1的个数，并以数组形式返回。
思路：状态转移方程,其实质是 res[n] = res[n >> 1] + (n & 1);即对于一个数n，它二进制中1的个数等于n右移一位 + n的最低位是否为1
      如7 = 0111,res[0111] = res[011] + 1 = res[3] + 1 = (res[01] + 1) + 1 = 3
*/
public class OJ_338CountingBits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for(int i = 1;i < res.length;i++){
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
    public static void main(String[] args) {
        OJ_338CountingBits oj = new OJ_338CountingBits();
        int[] res = oj.countBits(15);
        System.out.println(Arrays.toString(res));
    }
}
