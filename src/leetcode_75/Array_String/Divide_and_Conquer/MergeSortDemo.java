package leetcode_75.Array_String.Divide_and_Conquer;

import java.util.Arrays;

public class MergeSortDemo {

    private static int callId = 0;

    public static void main(String[] args) {

        int[] nums = {8, 4, 6, 2};

        System.out.println("========== 程序开始 ==========");
        System.out.println("原始数组：" + Arrays.toString(nums));

        mergeSort(nums, 0, nums.length - 1, 1);

        System.out.println();
        System.out.println("最终数组：" + Arrays.toString(nums));
        System.out.println("========== 程序结束 ==========");
    }

    public static void mergeSort(
            int[] nums,
            int left,
            int right,
            int depth) {

        int myCallId = ++callId;

        log(depth, "==================================================");
        log(depth, "【创建栈帧】callId = " + myCallId);
        log(depth, "left = " + left);
        log(depth, "right = " + right);
        log(depth, "当前数组 = " + Arrays.toString(nums));

        // 递归终止条件
        if (left == right) {

            log(depth, "【满足终止条件】left == right");
            log(depth, "当前只剩一个元素 nums[" + left + "] = " + nums[left]);

            log(depth, "【执行 return】");
            log(depth, "当前栈帧 callId = " + myCallId + " 销毁");
            log(depth, "返回调用当前方法的上一层");

            return;
        }

        // 计算中间位置
        int mid = (left + right) / 2;

        log(depth, "【计算 mid】");
        log(depth,
                "mid = (" + left + " + " + right + ") / 2 = " + mid
        );

        /*
         * =========================
         * 处理左边
         * =========================
         */

        log(depth, "");
        log(depth, "↓↓↓↓↓↓ 开始递归左边 ↓↓↓↓↓↓");

        log(depth,
                "准备调用 mergeSort(nums, "
                        + left + ", "
                        + mid + ")"
        );

        log(depth, "【当前层即将暂停】");
        log(depth, "保存当前栈帧：");
        log(depth, "callId = " + myCallId);
        log(depth, "left = " + left);
        log(depth, "right = " + right);
        log(depth, "mid = " + mid);

        mergeSort(nums, left, mid, depth + 1);

        /*
         * 能执行到这里，
         * 说明左边递归已经 return。
         */

        log(depth, "");
        log(depth, "↑↑↑↑↑↑ 左边递归已经 return ↑↑↑↑↑↑");

        log(depth, "【恢复当前栈帧】");
        log(depth, "callId = " + myCallId);
        log(depth, "left = " + left);
        log(depth, "right = " + right);
        log(depth, "mid = " + mid);

        /*
         * =========================
         * 处理右边
         * =========================
         */

        log(depth, "");
        log(depth, "↓↓↓↓↓↓ 开始递归右边 ↓↓↓↓↓↓");

        log(depth,
                "准备调用 mergeSort(nums, "
                        + (mid + 1) + ", "
                        + right + ")"
        );

        log(depth, "【当前层再次暂停】");
        log(depth, "保存当前栈帧：");
        log(depth, "callId = " + myCallId);
        log(depth, "left = " + left);
        log(depth, "right = " + right);
        log(depth, "mid = " + mid);

        mergeSort(nums, mid + 1, right, depth + 1);

        /*
         * 能执行到这里，
         * 说明右边递归已经 return。
         */

        log(depth, "");
        log(depth, "↑↑↑↑↑↑ 右边递归已经 return ↑↑↑↑↑↑");

        log(depth, "【恢复当前栈帧】");
        log(depth, "callId = " + myCallId);
        log(depth, "left = " + left);
        log(depth, "right = " + right);
        log(depth, "mid = " + mid);

        /*
         * =========================
         * 左右都处理完成
         * 开始 merge
         * =========================
         */

        log(depth, "");
        log(depth, "★★★★★★ 左右递归都完成，开始 merge ★★★★★★");

        log(depth,
                "左边区间 = "
                        + Arrays.toString(
                        Arrays.copyOfRange(nums, left, mid + 1)
                )
        );

        log(depth,
                "右边区间 = "
                        + Arrays.toString(
                        Arrays.copyOfRange(nums, mid + 1, right + 1)
                )
        );

        merge(nums, left, mid, right, depth);

        log(depth, "");
        log(depth, "【merge 完成】");
        log(depth, "当前数组 = " + Arrays.toString(nums));

        /*
         * 这里非常重要：
         *
         * merge() 执行完成以后，
         * mergeSort() 后面已经没有代码了。
         *
         * 所以继续往下执行，
         * 执行到当前方法最后的 }
         *
         * 当前方法自然结束。
         */

        log(depth, "【当前层后续已经没有代码】");
        log(depth, "【即将执行到 mergeSort 方法最后的 } 】");
        log(depth, "【当前方法自然结束，相当于隐式 return】");
        log(depth, "【当前栈帧销毁】callId = " + myCallId);
        log(depth, "【返回调用当前方法的上一层】");

    } // ← mergeSort 当前层真正执行到这里，方法结束

    public static void merge(
            int[] nums,
            int left,
            int mid,
            int right,
            int depth) {

        log(depth, "");
        log(depth, "---------- 进入 merge() ----------");

        log(depth,
                "merge 参数：left=" + left
                        + "，mid=" + mid
                        + "，right=" + right
        );

        /*
         * 创建临时数组。
         *
         * 例如：
         *
         * left = 0
         * right = 1
         *
         * temp长度：
         *
         * 1 - 0 + 1 = 2
         */

        int[] temp = new int[right - left + 1];

        /*
         * i：
         * 指向左边数组
         *
         * j：
         * 指向右边数组
         *
         * k：
         * 指向 temp
         */

        int i = left;
        int j = mid + 1;
        int k = 0;

        log(depth, "初始化三个指针：");
        log(depth, "i = " + i + "（左边）");
        log(depth, "j = " + j + "（右边）");
        log(depth, "k = " + k + "（temp）");

        /*
         * 左右两边都有数据的时候：
         *
         * 比较 nums[i] 和 nums[j]
         *
         * 谁小，就把谁放进 temp。
         */

        while (i <= mid && j <= right) {

            log(depth, "");
            log(depth, "【while 比较】");

            log(depth,
                    "i=" + i
                            + " → nums[i]=" + nums[i]
            );

            log(depth,
                    "j=" + j
                            + " → nums[j]=" + nums[j]
            );

            log(depth,
                    "k=" + k
            );

            if (nums[i] <= nums[j]) {

                log(depth,
                        nums[i] + " <= " + nums[j]
                                + "，选择左边 " + nums[i]
                );

                temp[k] = nums[i];

                log(depth,
                        "temp[" + k + "] = " + nums[i]
                );

                i++;

                log(depth,
                        "左边指针 i++，现在 i = " + i
                );

            } else {

                log(depth,
                        nums[i] + " > " + nums[j]
                                + "，选择右边 " + nums[j]
                );

                temp[k] = nums[j];

                log(depth,
                        "temp[" + k + "] = " + nums[j]
                );

                j++;

                log(depth,
                        "右边指针 j++，现在 j = " + j
                );
            }

            k++;

            log(depth,
                    "temp指针 k++，现在 k = " + k
            );

            log(depth,
                    "当前 temp = " + Arrays.toString(temp)
            );
        }

        /*
         * 如果左边还有数据：
         * 全部复制进去。
         */

        log(depth, "");
        log(depth, "【检查左边是否还有剩余元素】");

        while (i <= mid) {

            log(depth,
                    "左边还有 nums[" + i + "] = " + nums[i]
            );

            temp[k] = nums[i];

            log(depth,
                    "temp[" + k + "] = " + nums[i]
            );

            i++;
            k++;

            log(depth,
                    "i = " + i + "，k = " + k
            );

            log(depth,
                    "当前 temp = " + Arrays.toString(temp)
            );
        }

        /*
         * 如果右边还有数据：
         * 全部复制进去。
         */

        log(depth, "");
        log(depth, "【检查右边是否还有剩余元素】");

        while (j <= right) {

            log(depth,
                    "右边还有 nums[" + j + "] = " + nums[j]
            );

            temp[k] = nums[j];

            log(depth,
                    "temp[" + k + "] = " + nums[j]
            );

            j++;
            k++;

            log(depth,
                    "j = " + j + "，k = " + k
            );

            log(depth,
                    "当前 temp = " + Arrays.toString(temp)
            );
        }

        /*
         * temp现在已经排好序。
         *
         * 把temp的数据复制回nums。
         */

        log(depth, "");
        log(depth,
                "【temp 排序完成】temp = "
                        + Arrays.toString(temp)
        );

        log(depth,
                "开始把 temp 复制回 nums"
        );

        for (int x = 0; x < temp.length; x++) {

            int numsIndex = left + x;

            log(depth,
                    "nums[" + numsIndex + "]"
                            + " = temp[" + x + "]"
                            + " = " + temp[x]
            );

            nums[numsIndex] = temp[x];
        }

        log(depth,
                "复制完成，nums = "
                        + Arrays.toString(nums)
        );

        log(depth, "【merge 后续没有代码】");
        log(depth, "【执行到 merge 方法最后的 } 】");
        log(depth, "【merge 方法自然结束，返回 mergeSort】");

    } // ← merge真正执行到这里

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