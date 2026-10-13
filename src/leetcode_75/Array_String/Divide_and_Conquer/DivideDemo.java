package leetcode_75.Array_String.Divide_and_Conquer;

public class DivideDemo {

    private static int callId = 0;

    public static void main(String[] args) {
        int[] nums = {8, 4, 6, 2};

        divide(nums, 0, nums.length - 1, 1);
    }

    public static void divide(
            int[] nums,
            int left,
            int right,
            int depth) {

        int myCallId = ++callId;

        log(depth, "================================");

        log(depth,
                "【创建栈帧】callId=" + myCallId
                        + "，left=" + left
                        + "，right=" + right
        );

        if (left == right) {
            log(depth,
                    "【终止条件】left == right"
            );

            log(depth,
                    "当前只剩一个元素 nums[" + left + "] = " + nums[left]
            );

            log(depth,
                    "【return】销毁当前栈帧 callId=" + myCallId
            );

            return;
        }

        int mid = (left + right) / 2;

        log(depth,
                "计算 mid = (" + left + " + " + right + ") / 2 = " + mid
        );

        log(depth,
                "准备递归左边：divide("
                        + left + ", " + mid + ")"
        );

        log(depth,
                "【当前层暂停】callId=" + myCallId
                        + " 保存 left=" + left
                        + " right=" + right
                        + " mid=" + mid
        );

        divide(nums, left, mid, depth + 1);

        log(depth,
                "【左边返回】恢复 callId=" + myCallId
        );

        log(depth,
                "恢复的值：left=" + left
                        + " right=" + right
                        + " mid=" + mid
        );

        log(depth,
                "准备递归右边：divide("
                        + (mid + 1) + ", " + right + ")"
        );

        log(depth,
                "【当前层再次暂停】callId=" + myCallId
        );

        divide(nums, mid + 1, right, depth + 1);

        log(depth,
                "【右边返回】恢复 callId=" + myCallId
        );

        log(depth,
                "【当前区间处理完成】"
                        + left + " ~ " + right
        );

        log(depth,
                "【return】销毁 callId=" + myCallId
        );
    }

    private static void log(int depth, String message) {
        String indent = "    ".repeat(depth - 1);

        System.out.println(
                indent + "[第" + depth + "层] " + message
        );
    }
}