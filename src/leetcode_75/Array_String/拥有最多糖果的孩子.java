package leetcode_75.Array_String;

import java.util.ArrayList;
import java.util.List;

public class 拥有最多糖果的孩子 {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        System.out.println("最大数： " + max);
        List<Boolean> result = new ArrayList<>();
        for (int candy  : candies) {
            if (candy + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        System.out.println("最后结果是什么： " + result);
        return null;
    }
    public static void main(String[] args) {
       int[] candies = {2,3,5,1,3};
//       int[] candies = new int[]{2,3,5,1,3};
       int extraCandies = 3;
        kidsWithCandies(candies, extraCandies);
    }
}
