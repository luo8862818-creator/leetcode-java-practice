package Stack;

import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
        print(3);
        System.out.println("-----------------------");
        print2(2);
    }

    public static void print(int n) {
        Stack<Integer> stack = new Stack<>();

        while (n != 0) {
            System.out.println("递：" + n);

            System.out.println("【入栈】" + n);
            stack.push(n);

            System.out.println("当前栈：" + stack);
            System.out.println();

            n--;
        }

        System.out.println("========== 到底了 ==========");
        System.out.println();

        while (!stack.isEmpty()) {
            int value = stack.pop();

            System.out.println("【出栈】" + value);
            System.out.println("归：" + value);
            System.out.println("当前栈：" + stack);
            System.out.println();
        }
    }

    public static void print2(int n) {
        if (n == 0) {
            return;
        }

        System.out.println("递：" + n);

        print2(n - 1);

        System.out.println("归：" + n);
    }

}