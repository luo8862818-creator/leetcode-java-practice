package leetcode_75_prefix_sum;

public class 寻找中心下标 {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        pivotIndex(nums);
    }
    public static int pivotIndex1(int[] nums) {

        // 遍历每一个下标
        for (int i = 0; i < nums.length; i++) {

            int leftSum = 0;
            int rightSum = 0;

            // 计算左边的和
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }

            // 计算右边的和
            for (int j = i + 1; j < nums.length; j++) {
                rightSum += nums[j];
            }

            // 判断左右两边是否相等
            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }
    public static int pivotIndex(int[] nums) {

        // 第一步：计算整个数组的总和
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        // 第二步：从左往右遍历
        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {

            // 第三步：计算右边的和
            int rightSum = totalSum - leftSum - nums[i];

            // 第四步：判断左右两边是否相等
            if (leftSum == rightSum) {
                return i;
            }

            // 第五步：更新左边的和
            leftSum += nums[i];
        }

        return -1;
    }
}
