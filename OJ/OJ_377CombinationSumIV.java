package OJ;

/**
 * Created by meng_jian on 2016/8/4.
 */
public class OJ_377CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1;i < dp.length;i++){
            for(int j = 0;j < nums.length;j++){
                if(i - nums[j] >=0){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
    public static void main(String[] args) {
        OJ_377CombinationSumIV oj = new OJ_377CombinationSumIV();
        int[] nums = {1,3,7};
        int res = oj.combinationSum4(nums,4);
        System.out.println(res);
    }
}
