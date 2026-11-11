package leetcode_75_prefix_sum;

public class 找出最高海拔 {
    public static void main(String[] args) {
        int[] nums = {0, -5, -4, 1, 1, -6};
        System.out.println("结果是 : " + largestAltitude(nums));
    }
    public static int largestAltitude1(int[] gain) {

        int[] altitudes = new int[gain.length + 1];

        altitudes[0] = 0;

        for (int i = 0; i < gain.length; i++) {
            altitudes[i + 1] = altitudes[i] + gain[i];
        }

        int maxAltitude = altitudes[0];

        for (int i = 0; i < altitudes.length; i++) {
            maxAltitude = Math.max(maxAltitude, altitudes[i]);
        }

        return maxAltitude;
    }

    public static int largestAltitude(int[] gain) {

        int currentAltitude = 0;
        int maxAltitude = 0;

        for (int i = 0; i < gain.length; i++) {

            currentAltitude += gain[i];

            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }

        return maxAltitude;
    }


}
