package leetcode_75_Two_Pointers;

public class 移动零 {
    public static void main(String[] args) {
        int[] nums = {0, 0,1,0,1,1};
        moveZeroes(nums);
//        test();
    }

    private static void moveZeroes(int[] nums) {
        int j = 0;

        // 第一轮：把所有非零元素依次放到前面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        // 第二轮：剩余位置全部填0
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }

    public static void test() {
        for (int i =0; i < 5; i++) {
            System.out.println("i = " + i);
        }
    }

    public static void moveZeroes1(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            if (nums[i] != 0) {
                i++;
                continue;
            }

            // 把后面的元素整体向前移动一位
            for (int j = i; j < nums.length - 1; j++) {
                nums[j] = nums[j + 1];
            }

            nums[nums.length - 1] = 0;

            // 注意：这里不增加i，继续检查当前位置
        }
    }
}
