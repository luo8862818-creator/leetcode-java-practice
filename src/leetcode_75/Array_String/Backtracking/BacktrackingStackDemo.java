package leetcode_75.Array_String.Backtracking;


import java.util.ArrayList;
import java.util.List;

public class BacktrackingStackDemo {

    private static int callId = 0;

    public static void main(String[] args) {
        char[] chars = {'A', 'B', 'C'};
        List<Character> path = new ArrayList<>();
        boolean[] used = new boolean[chars.length];

        System.out.println("========== 程序开始 ==========");
        backtrack(chars, path, used, 1);
        System.out.println("========== 程序结束 ==========");
    }

    public static void backtrack(
            char[] chars,
            List<Character> path,
            boolean[] used,
            int depth) {

        int myCallId = ++callId;

        log(depth, "==================================================");
        log(depth, "【创建栈帧】");
        log(depth, "调用编号 callId = " + myCallId);
        log(depth, "递归层数 depth = " + depth);
        log(depth, "进入时 path = " + path);
        log(depth, "进入时 used = " + usedToString(chars, used));

        if (path.size() == chars.length) {
            log(depth, "【满足终止条件】path.size() == " + chars.length);
            log(depth, "★★★★★ 找到答案：" + path);
            log(depth, "【当前栈帧准备销毁】callId = " + myCallId);
            log(depth, "【return】返回调用我的上一层");
            return;
        }

        log(depth, "【准备进入 for 循环】i 从 0 开始");

        for (int i = 0; i < chars.length; i++) {

            log(depth, "");
            log(depth, "------------------------------");
            log(depth, "【for 本轮开始】");
            log(depth, "当前栈帧 callId = " + myCallId);
            log(depth, "当前层 depth = " + depth);
            log(depth, "当前 i = " + i);
            log(depth, "chars[" + i + "] = " + chars[i]);
            log(depth, "当前 path = " + path);
            log(depth, "当前 used = " + usedToString(chars, used));

            if (used[i]) {
                log(depth, "【判断】" + chars[i] + " 已经使用");
                log(depth, "【continue】本轮结束");
                log(depth, "接下来执行当前层自己的 i++");
                continue;
            }

            log(depth, "【判断】" + chars[i] + " 没有使用，可以选择");

            path.add(chars[i]);
            used[i] = true;

            log(depth, "【做选择】选择 " + chars[i]);
            log(depth, "选择后 path = " + path);
            log(depth, "选择后 used = " + usedToString(chars, used));

            log(depth, "");
            log(depth, "↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
            log(depth, "【即将递归】backtrack(...)");
            log(depth, "当前层马上暂停！");
            log(depth, "当前栈帧 callId = " + myCallId);
            log(depth, "当前层 depth = " + depth);
            log(depth, "当前层 for 的 i = " + i);
            log(depth, "当前层暂停在 backtrack(...) 这一行");
            log(depth, "必须等下一层 return，当前层才能继续");
            log(depth, "↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");

            backtrack(chars, path, used, depth + 1);

            log(depth, "");
            log(depth, "↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
            log(depth, "【下一层已经 return】");
            log(depth, "恢复当前栈帧 callId = " + myCallId);
            log(depth, "恢复当前层 depth = " + depth);
            log(depth, "重要：恢复后当前 i 仍然 = " + i);
            log(depth, "因为这个 i 属于当前栈帧，一直被保存着");
            log(depth, "现在继续执行 backtrack(...) 后面的代码");
            log(depth, "↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");

            char removed = path.remove(path.size() - 1);
            used[i] = false;

            log(depth, "【撤销选择】撤销 " + removed);
            log(depth, "撤销后 path = " + path);
            log(depth, "撤销后 used = " + usedToString(chars, used));

            log(depth, "【本轮 for 即将结束】当前 i = " + i);

            if (i + 1 < chars.length) {
                log(depth, "接下来执行 i++");
                log(depth, "所以当前层 i 将从 " + i + " 变成 " + (i + 1));
                log(depth, "下一轮将检查 chars[" + (i + 1) + "] = " + chars[i + 1]);
            } else {
                log(depth, "i 已经是最后一个下标");
                log(depth, "i++ 后 for 条件不成立，for 将结束");
            }
        }

        log(depth, "");
        log(depth, "【for 循环彻底结束】");
        log(depth, "当前栈帧 callId = " + myCallId);
        log(depth, "当前 path = " + path);
        log(depth, "【当前栈帧准备销毁】");
        log(depth, "【return 给上一层】");
        log(depth, "==================================================");
    }

    private static void log(int depth, String message) {
        String indent = "    ".repeat(depth - 1);
        System.out.println(indent + "[第" + depth + "层] " + message);
    }

    private static String usedToString(char[] chars, boolean[] used) {
        StringBuilder sb = new StringBuilder("{");

        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i])
                    .append("=")
                    .append(used[i]);

            if (i < chars.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("}");
        return sb.toString();
    }
}