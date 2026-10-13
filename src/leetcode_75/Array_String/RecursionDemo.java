package leetcode_75.Array_String;

public class RecursionDemo {
    private static int depth = 0;

    public static void main(String[] args) {

//        countDown(3);
        //带返回值的递归
//        System.out.println("最终结果 = " + sum(4));
//        printBefore(3);
//        printAfter(3);
//        test(3);
        branch(2);
    }


    public static void branch(int n) {
        depth++;
        String indent = "  ".repeat(depth - 1);
        System.out.println(indent + "【进入】branch(" + n + ")");
        if (n == 0) {
            System.out.println(indent + "【终止】branch(0)");
            depth--;
            return;
        }
        System.out.println(indent + "→ 第一次递归 branch(" + (n - 1) + ")");
        branch(n - 1);
        System.out.println(indent + "← 第一次递归完成，回到 branch(" + n + ")");
        System.out.println(indent + "→ 第二次递归 branch(" + (n - 1) + ")");
        branch(n - 1);
        System.out.println(indent + "← 第二次递归完成，branch(" + n + ") 结束");
        depth--;
    }

    public static void test(int n) {
        System.out.println("【进入】n = " + n);

        if (n == 0) {
            System.out.println("【终止】n = 0");
            return;
        }

        System.out.println(">>> 前：" + n);

        test(n - 1);

        System.out.println("<<< 后：" + n);

        System.out.println("【退出】n = " + n);
    }

    public static void printAfter(int n) {
        System.out.println("【进入】printAfter(" + n + ")");

        if (n == 0) {
            System.out.println("【终止】n = 0，return");
            return;
        }

        System.out.println("【递归】准备调用 printAfter(" + (n - 1) + ")");

        printAfter(n - 1);

        System.out.println("【恢复】回到 printAfter(" + n + ")");
        System.out.println("【打印】n = " + n);
    }

    public static void printBefore(int n) {
        System.out.println("【进入】printBefore(" + n + ")");

        if (n == 0) {
            System.out.println("【终止】n = 0，return");
            return;
        }

        System.out.println("【打印】n = " + n);

        System.out.println("【递归】准备调用 printBefore(" + (n - 1) + ")");
        printBefore(n - 1);

        System.out.println("【恢复】printBefore(" + n + ") 即将结束");
    }


    public static int sum(int n) {
        depth++;

        System.out.println(
                "  ".repeat(depth - 1)
                        + "→ 进入 sum(" + n + ")"
        );

        if (n == 1) {
            System.out.println(
                    "  ".repeat(depth - 1)
                            + "← sum(1) 返回 1"
            );

            depth--;
            return 1;
        }

        int childResult = sum(n - 1);

        int result = n + childResult;

        System.out.println(
                "  ".repeat(depth - 1)
                        + "← sum(" + n + ")："
                        + n + " + " + childResult
                        + " = " + result
        );

        depth--;

        return result;
    }

    public static void countDown(int n) {
        System.out.println("进入 countDown，n = " + n);

        if (n == 0) {
            System.out.println("到达终止条件，准备返回");
            return;
        }

        System.out.println("准备调用 countDown(" + (n - 1) + ")");

        countDown(n - 1);

        System.out.println("countDown(" + n + ") 即将结束");
    }
}
