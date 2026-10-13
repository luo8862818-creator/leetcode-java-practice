package LinkedListRecursion;

public class LinkedListRecursionDemo {

    private static int callId = 0;

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        System.out.println("========== 开始 ==========");

        printReverse(n1, 1);

        System.out.println("========== 结束 ==========");
    }

    public static void printReverse(Node node, int depth) {

        int myCallId = ++callId;

        log(depth, "==============================");
        log(depth, "【创建栈帧】callId = " + myCallId);

        if (node == null) {
            log(depth, "node = null");
            log(depth, "【满足终止条件】");
            log(depth, "【执行 return】");
            log(depth, "【当前栈帧销毁】callId = " + myCallId);
            log(depth, "返回上一层");
            return;
        }

        log(depth, "当前 node.value = " + node.value);

        if (node.next == null) {
            log(depth, "node.next = null");
        } else {
            log(depth, "node.next.value = " + node.next.value);
        }

        log(depth, "");
        log(depth, "【准备递归】");

        if (node.next == null) {
            log(depth, "即将调用 printReverse(null)");
        } else {
            log(depth,
                    "即将调用 printReverse("
                            + node.next.value
                            + ")"
            );
        }

        log(depth, "【当前层暂停】");
        log(depth, "保存当前栈帧：");
        log(depth, "callId = " + myCallId);
        log(depth, "node.value = " + node.value);
        log(depth, "暂停在 printReverse(node.next)");

        printReverse(node.next, depth + 1);

        /*
         * 下一层return以后，
         * 当前层从这里恢复。
         */

        log(depth, "");
        log(depth, "【下一层已经 return】");
        log(depth, "【恢复当前栈帧】");
        log(depth, "callId = " + myCallId);
        log(depth, "node.value = " + node.value);

        log(depth, "【执行递归后面的代码】");
        log(depth, "打印：" + node.value);

        System.out.println(
                "    ".repeat(depth - 1)
                        + ">>> 数据：" + node.value
        );

        log(depth, "");
        log(depth, "【后续已经没有代码】");
        log(depth, "【执行到 printReverse 方法最后的 } 】");
        log(depth, "【方法自然结束，相当于隐式 return】");
        log(depth, "【当前栈帧销毁】callId = " + myCallId);

    } // ← 当前层真正执行到这里

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