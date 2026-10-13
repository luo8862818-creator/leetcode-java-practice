package leetcode_75.Array_String.ArrayRecursion;

import java.util.Arrays;

public class ArrayRecursionDemo {

    private static int callId = 0;

    public static void main(String[] args) {

        int[] nums = {10, 20, 30, 40};

        System.out.println("========== 程序开始 ==========");
        System.out.println("数组：" + Arrays.toString(nums));

        int result = sum(nums, 0, 1);

        System.out.println();
        System.out.println("最终结果：" + result);
        System.out.println("========== 程序结束 ==========");
    }

    public static int sum(
            int[] nums,
            int index,
            int depth) {

        int myCallId = ++callId;

        log(depth, "================================");
        log(depth, "【创建栈帧】callId = " + myCallId);
        log(depth, "当前 index = " + index);

        if (index == nums.length) {

            log(depth, "【终止条件】");
            log(depth, "index == nums.length");
            log(depth, index + " == " + nums.length);

            log(depth, "【return 0】");
            log(depth, "当前栈帧 callId=" + myCallId + " 销毁");
            log(depth, "返回上一层");

            return 0;
        }

        int currentValue = nums[index];

        log(depth, "当前元素 nums[" + index + "] = " + currentValue);

        log(depth, "");
        log(depth, "准备调用下一层：");
        log(depth, "sum(nums, " + (index + 1) + ")");

        log(depth, "【当前层暂停】");
        log(depth, "保存当前栈帧：");
        log(depth, "callId = " + myCallId);
        log(depth, "index = " + index);
        log(depth, "currentValue = " + currentValue);

        int childResult = sum(
                nums,
                index + 1,
                depth + 1
        );

        /*
         * 下一层 return 后，
         * 才会继续执行这里。
         */

        log(depth, "");
        log(depth, "【下一层已经 return】");
        log(depth, "【恢复当前栈帧】");

        log(depth, "callId = " + myCallId);
        log(depth, "index = " + index);
        log(depth, "currentValue = " + currentValue);
        log(depth, "下一层返回 childResult = " + childResult);

        int result = currentValue + childResult;

        log(depth, "");
        log(depth, "【开始计算】");

        log(depth,
                currentValue
                        + " + "
                        + childResult
                        + " = "
                        + result
        );

        log(depth, "【return " + result + "】");
        log(depth, "当前栈帧 callId=" + myCallId + " 销毁");
        log(depth, "返回上一层");

        return result;

    } // 注意：这里不会自然执行到，因为上面已经执行 return result

    private static void log(int depth, String message) {

        String indent = "    ".repeat(depth - 1);

        System.out.println(
                indent
                        + "[第"
                        + depth
                        + "层] "
                        + message
        );
    }
}