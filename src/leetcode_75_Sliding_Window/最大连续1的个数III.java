package leetcode_75_Sliding_Window;

public class 最大连续1的个数III {
    public static void main(String[] args) {
        int nums[] = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
//        System.out.println("数组长度：" + nums.length);
        System.out.println("最后结果是：" + longestOnes(nums, k));
    }

    public static int longestOnes1(int[] nums, int k) {
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {

            int zeroCount = 0;

            for (int j = i; j < nums.length; j++) {

                if (nums[j] == 0) {
                    zeroCount++;
                }

                if (zeroCount > k) {
                    System.out.println("for循环跳出， j = " + j);
                    break;
                }

                int length = j - i + 1;


                System.out.println("开始统计满足情况");
                maxLength = Math.max(maxLength, length);
                System.out.println("i = " + i + ", j = " + j + " ,zeroCount = " + zeroCount + ", length = " + length + ", maxLength = " + maxLength);
            }
        }

        return maxLength;
    }

    public static int longestOnes(int[] nums, int k) {

        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            // 右指针遇到 0，计数加一
            if (nums[right] == 0) {
                zeroCount++;
            }

            // 如果 0 的数量超过 k，缩小窗口
            while (zeroCount > k) {

                // 左边移出去的元素如果是 0，计数减一
                if (nums[left] == 0) {
                    zeroCount--;
                }

                left++;
            }

            // 此时窗口合法，计算长度
            int length = right - left + 1;

            // 更新最大长度
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}
