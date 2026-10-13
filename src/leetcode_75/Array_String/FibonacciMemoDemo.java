package leetcode_75.Array_String;

import java.util.HashMap;
import java.util.Map;

public class FibonacciMemoDemo {

    private static final Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        int result = fib(4);

        System.out.println();
        System.out.println("最终结果：fib(5) = " + result);
    }

    public static int fib(int n) {
        System.out.println("【进入】fib(" + n + ")");

        if (n == 0) {
            System.out.println("【终止】fib(0) = 0");
            return 0;
        }

        if (n == 1) {
            System.out.println("【终止】fib(1) = 1");
            return 1;
        }

        // 以前计算过
        if (cache.containsKey(n)) {
            int result = cache.get(n);

            System.out.println(
                    "【缓存命中】fib(" + n + ") = " + result
            );

            return result;
        }

        System.out.println(
                "【开始计算】fib(" + n + ")"
        );

        int left = fib(n - 1);
        int right = fib(n - 2);

        int result = left + right;

        // 保存计算结果
        cache.put(n, result);

        System.out.println(
                "【保存缓存】fib(" + n + ") = " + result
        );

        return result;
    }
}