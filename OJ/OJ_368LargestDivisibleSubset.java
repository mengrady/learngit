package OJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by meng_jian on 2016/8/8.
 */
public class OJ_368LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if(nums.length == 0){
            return list;
        }
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        int[] pre = new int[nums.length];
        res[0] = 1;
        pre[0] = -1;
        int max = 1;
        int maxindex = 0;
        for(int i = 1;i < res.length;i++){
            res[i] = 1;
            pre[i] = -1;
            for(int j = 0;j < i;j++){
                if(nums[i] % nums[j] == 0){
                    if(res[j] + 1 > res[i]) {
                        res[i] = res[j] + 1;
                        pre[i] = j;
                    }
                    if(res[i] > max){
                        max = res[i];
                        maxindex = i;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(pre));
        int index = maxindex;
        while(index != -1){
            list.add(0,nums[index]);
            index = pre[index];
        }
        return list;
    }

    public List<Integer> largestDivisibleSubset2(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        if (nums == null || nums.length == 0)
            return ret;
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];
        Arrays.fill(dp, 1);
        prev[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
        }
        // find the max of dp
        int maxIndex = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        int len = dp[maxIndex];
        while (true) {
            ret.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
            if (--len <= 0)
                break;
        }
        return ret;
    }

    public static void main(String[] args) {
        OJ_368LargestDivisibleSubset oj = new OJ_368LargestDivisibleSubset();
        int[] nums= {1,2,4,8,9,72};
        List<Integer> list = oj.largestDivisibleSubset(nums);
        System.out.println(list);
    }
}
