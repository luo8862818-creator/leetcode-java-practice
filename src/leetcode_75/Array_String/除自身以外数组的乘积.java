package leetcode_75.Array_String;

import java.util.Arrays;

public class 除自身以外数组的乘积 {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        System.out.println("最后结果：" + Arrays.toString(result));
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] answer = new int[n];

        // 第一步：计算前缀乘积
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // 第二步：计算后缀乘积
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        // 第三步：前缀乘积 × 后缀乘积
        for (int i = 0; i < n; i++) {
            answer[i] = left[i] * right[i];
        }

        return answer;
    }

    public static int[] productExceptSelf1(int[] nums) {
        int[] answer = new int[nums.length];
        System.out.println("还未循环循环之前：" + Arrays.toString(answer));
        // 外层循环：决定计算哪个位置
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            // 内层循环：遍历所有元素
            for (int j = 0; j < nums.length; j++) {
                // 遇到自己就跳过
                if (i == j) {
                    continue;
                }
                product = product * nums[j];
            }
            answer[i] = product;
        }

        return answer;
    }

}
