package exercises;

public class TwoSum {
    public static void main(String[] args) {
        int[] value = twoSum(new int[] {3,2,4}, 6);
        System.out.println("[" + value[0] + "," + value[1] + "]");
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int x = 0; x < nums.length; x++) {
            for (int y = x + 1; y < nums.length; y++) {
                if (nums[x] + nums[y] == target) {
                    return new int[] {x, y};
                }
            }
        }
        return new int[] {0,0};
    }
}
