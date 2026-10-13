package StringRecursion;

public class StringRecursionDemo {

    public static void main(String[] args) {
        String str = "abcd";

        String result = reverse(str, 0, 1);

        System.out.println("最终结果：" + result);
    }

    public static String reverse(
            String str,
            int index,
            int depth) {

        log(depth, "==============================");
        log(depth, "【进入方法】index = " + index);

        if (index == str.length()) {
            log(depth, "【终止条件】index == str.length()");
            log(depth, "【return 空字符串】");
            return "";
        }

        char currentChar = str.charAt(index);

        log(depth, "当前字符 = " + currentChar);

        log(depth,
                "准备调用 reverse(str, "
                        + (index + 1)
                        + ")"
        );

        log(depth, "【当前层暂停】");
        log(depth, "保存 index = " + index);
        log(depth, "保存 currentChar = " + currentChar);

        String childResult = reverse(
                str,
                index + 1,
                depth + 1
        );

        log(depth, "");
        log(depth, "【下一层已经 return】");
        log(depth, "【恢复当前层】");
        log(depth, "index = " + index);
        log(depth, "currentChar = " + currentChar);
        log(depth, "childResult = \"" + childResult + "\"");

        String result = childResult + currentChar;

        log(depth,
                "【拼接】\"" + childResult
                        + "\" + \"" + currentChar
                        + "\" = \"" + result + "\""
        );

        log(depth, "【return \"" + result + "\"】");

        return result;

    } // 上面已经 return，不会自然执行到这里

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