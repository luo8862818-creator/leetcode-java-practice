package leetcode_75_Sliding_Window;

public class 删掉一个元素以后全为1的最长子数组 {
    public static void main(String[] args) {
        int nums[] = {1,1,0,0,1};

        longestSubarray(nums);
    }
    public static int longestSubarray1(int[] nums) {
        int maxLength = 0;

        // 依次尝试删除每一个元素
        for (int i = 0; i < nums.length; i++) {
            int count = 0;

            // 遍历剩余元素
            for (int j = 0; j < nums.length; j++) {
                System.out.println(" i = " + i + " j = " + j);
                // 跳过被删除的元素
                if (j == i) {
                    continue;
                }
                System.out.println("------------");

                if (nums[j] == 1) {
                    count++;
                    maxLength = Math.max(maxLength, count);
                    System.out.println("maxLength = " + maxLength + " cunt = " + count);
                } else {
                    count = 0;
                }
            }
        }

        return maxLength;
    }

    public static int longestSubarray(int[] nums) {
        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            // 右指针遇到 0，记录数量
            if (nums[right] == 0) {
                zeroCount++;
            }

            // 窗口中不能存在两个及以上的 0
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // 窗口长度减 1，因为必须删除一个元素
            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }
}

