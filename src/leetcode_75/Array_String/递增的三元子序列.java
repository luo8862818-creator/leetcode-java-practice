package leetcode_75.Array_String;

public class 递增的三元子序列 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 0, 4, 6};
        increasingTriplet(nums);
    }

    public static boolean increasingTriplet1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] < nums[j] && nums[j] < nums[k]) {
                        System.out.println("满足条件时：i = " + i + " j = " + j + " k = " + k);
                        return true;
                    }
                }
            }
        }

        return false;
    }


    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
            System.out.println("fist = " + first + ", second = " + second);
        }

        return false;
    }



}
