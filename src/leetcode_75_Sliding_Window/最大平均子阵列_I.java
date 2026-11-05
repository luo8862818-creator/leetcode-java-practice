package leetcode_75_Sliding_Window;

public class 最大平均子阵列_I {
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println("结果是：" + findMaxAverage(nums, k));
    }

    public static double findMaxAverage1(int[] nums, int k) {

        double maxAverage = Double.NEGATIVE_INFINITY;

        // 外层循环：确定窗口起始位置
        for (int i = 0; i <= nums.length - k; i++) {

            int sum = 0;

            // 内层循环：计算当前窗口的总和
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }

            // 计算平均值
            double average = (double) sum / k;

            // 更新最大平均值
            maxAverage = Math.max(maxAverage, average);
        }

        return maxAverage;
    }


    public static double findMaxAverage(int[] nums, int k) {

        // 1. 计算第一个窗口的总和
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // 2. 初始化最大窗口总和
        int maxSum = sum;

        // 3. 窗口向右移动
        for (int i = k; i < nums.length; i++) {

            // 减去离开窗口的元素
            sum -= nums[i - k];

            // 加上新进入窗口的元素
            sum += nums[i];

            // 更新最大总和
            maxSum = Math.max(maxSum, sum);
        }

        // 4. 返回最大平均值
        return (double) maxSum / k;
    }


}
