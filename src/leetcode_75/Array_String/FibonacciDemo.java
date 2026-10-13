package leetcode_75.Array_String;

public class FibonacciDemo {

    private static int depth = 0;

    public static void main(String[] args) {
        int result = fib(4);

        System.out.println();
        System.out.println("最终结果：fib(4) = " + result);
    }

    public static int fib(int n) {
        depth++;
        String indent = "  ".repeat(depth - 1);
        System.out.println(indent + "【进入】fib(" + n + ")");

        // 终止条件
        if (n == 0) {
            System.out.println(indent + "【终止】fib(0) = 0");
            depth--;
            return 0;
        }
        if (n == 1) {
            System.out.println(indent + "【终止】fib(1) = 1");

            depth--;
            return 1;
        }

        System.out.println(indent + "准备计算左边 fib(" + (n - 1) + ")");

        int left = fib(n - 1);

        System.out.println(indent + "左边计算完成，left = " + left);

        System.out.println(indent + "准备计算右边 fib(" + (n - 2) + ")");

        int right = fib(n - 2);

        System.out.println(indent + "右边计算完成，right = " + right);

        int result = left + right;

        System.out.println(indent + "【计算】fib(" + n + ") = " + left + " + " + right + " = " + result);

        System.out.println(indent + "【返回】fib(" + n + ") = " + result);

        depth--;

        return result;
    }
}
