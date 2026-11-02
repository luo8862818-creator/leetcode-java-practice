package leetcode_75_Two_Pointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class K和数对的最大数目 {
    public static void main(String[] args) {
        int nums[] = {1,2,2,3,4};
        int k = 5;
        System.out.println("次数: " + maxOperations(nums, k));

    }

    public static int maxOperations1(int[] nums, int k) {
        int operations = 0;
        int n = nums.length;
        // 用于记录哪些元素已经被使用过，避免重复配对
        boolean[] used = new boolean[n];
        // 外层循环：依次固定第一个数
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue; // 如果该数字已经被用过了，跳过
            }

            // 内层循环：寻找能和 nums[i] 相加等于 k 的第二个数
            for (int j = i + 1; j < n; j++) {
                if (!used[j] && nums[i] + nums[j] == k) {
                    // 找到配对，标记为已使用
                    used[i] = true;
                    used[j] = true;
                    operations++;
                    break; // 找到一对后，跳出内层循环，处理下一个外层数字
                }
            }
        }

        return operations;
    }

    public static int maxOperations2(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int operations = 0;
        // 双指针相向而行
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                operations++;
                left++;
                right--;
            } else if (sum < k) {
                left++;  // 和偏小，左指针右移
            } else {
                right--; // 和偏大，右指针左移
            }
        }

        return operations;
    }

    public static int maxOperations(int[] nums, int k) {
        // key: 数字, value: 该数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        int operations = 0;

        for (int num : nums) {
            int target = k - num;
            // 检查哈希表中是否存在配对的数字
            if (map.getOrDefault(target, 0) > 0) {
                operations++;
                // 配对成功，将补数的计数减 1
                map.put(target, map.get(target) - 1);
            } else {
                // 没有找到配对，将当前数字存入哈希表或增加计数
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return operations;
    }
}
