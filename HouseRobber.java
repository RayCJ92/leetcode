// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

// Credits:
// Special thanks to @ifanchu for adding this problem and creating all test cases. Also thanks to @ts for adding additional test cases.

// Subscribe to see which companies asked this question.

//#1 Dynamic Programming
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length ; i++){
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        return dp[nums.length-1];
    }
}

//#2 use 2 variables
class Solution2 {
    public int rob(int[] nums) {
        int robCurrent = 0;
        int noCurrent = 0;
        for (int i = 0; i < nums.length; i++){
            int temp = robCurrent;                                  
            robCurrent = Math.max(nums[i]+noCurrent,robCurrent);  //max of robbing ith house
            noCurrent = temp;                                       //max of not robbing ith house(in face,it is the money rob last time)
        }
        return Math.max(noCurrent,robCurrent);
    }
}

//#3 use recursion (bad code, OJ timeout)
class Solution3 {
   public int rob(int[] nums){
        return dp(nums.length, nums);
    }

    int dp(int n, int[] nums){
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return nums[0]>nums[1]?nums[0]:nums[1];
        else {
            int dp1 =(nums[n-1]+dp(n-2, nums));
            int dp2 = dp(n-1,nums);
            return dp1>dp2?dp1:dp2;
        }
    }
}