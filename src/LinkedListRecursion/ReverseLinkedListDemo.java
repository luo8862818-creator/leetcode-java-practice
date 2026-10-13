package LinkedListRecursion;

public class ReverseLinkedListDemo {

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

        n1.next = n2;
        n2.next = n3;

        System.out.println("========== 开始 ==========");
        System.out.println("原始链表：");
        printList(n1);

        System.out.println();
        System.out.println("========== 开始递归反转 ==========");

        Node newHead = reverse(n1, 1);

        System.out.println();
        System.out.println("========== 反转完成 ==========");
        System.out.println("新的头节点 = " + newHead.value);
        System.out.println("最终链表：");
        printList(newHead);
    }

    public static Node reverse(Node head, int depth) {
        int myCallId = ++callId;

        log(depth, "========================================");
        log(depth, "【创建栈帧】callId = " + myCallId);
        log(depth, "当前 head = " + nodeValue(head));

        if (head == null || head.next == null) {
            log(depth, "【满足终止条件】");

            if (head == null) {
                log(depth, "head == null");
            } else {
                log(depth, "head.next == null");
                log(depth, "当前已经是最后一个节点：" + head.value);
            }

            log(depth, "【return head】");
            log(depth, "返回节点：" + nodeValue(head));
            log(depth, "当前栈帧销毁 callId = " + myCallId);

            return head;
        }

        log(depth, "当前关系：");
        log(depth, head.value + " → " + head.next.value);

        log(depth, "");
        log(depth, "【准备递归】");
        log(depth, "调用 reverse(" + head.next.value + ")");
        log(depth, "【当前层暂停】");
        log(depth, "保存 head = " + head.value);
        log(depth, "保存 head.next = " + head.next.value);

        Node newHead = reverse(head.next, depth + 1);

        log(depth, "");
        log(depth, "【下一层已经 return】");
        log(depth, "【恢复当前栈帧】callId = " + myCallId);
        log(depth, "恢复 head = " + head.value);
        log(depth, "现在 newHead = " + newHead.value);

        log(depth, "");
        log(depth, "当前指针：");
        log(depth, "head = " + head.value);
        log(depth, "head.next = " + head.next.value);
        log(depth, "head.next.next = " + nodeValue(head.next.next));

        log(depth, "");
        log(depth, "准备执行：");
        log(depth, "head.next.next = head;");
        log(depth, "也就是：");
        log(depth, head.next.value + ".next = " + head.value);

        head.next.next = head;

        log(depth, "【执行完成】");
        log(depth, "现在：" + head.next.value + " → " + head.value);

        log(depth, "");
        log(depth, "但是现在出现了双向指向：");
        log(depth, head.value + " → " + head.next.value);
        log(depth, head.next.value + " → " + head.value);

        log(depth, "");
        log(depth, "准备执行：");
        log(depth, "head.next = null;");
        log(depth, "也就是：" + head.value + ".next = null");

        head.next = null;

        log(depth, "【执行完成】");
        log(depth, head.value + " → null");

        log(depth, "");
        log(depth, "【return newHead】");
        log(depth, "newHead 始终是：" + newHead.value);
        log(depth, "当前栈帧销毁 callId = " + myCallId);

        return newHead;

    } // 上面执行 return newHead，不会自然执行到这里

    private static String nodeValue(Node node) {
        if (node == null) {
            return "null";
        }
        return String.valueOf(node.value);
    }

    private static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.value + " → ");
            current = current.next;
        }

        System.out.println("null");
    }

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
